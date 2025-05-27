/*
 * The MIT License
 * Copyright © 2024 Landeshauptstadt München | it@M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.muenchen.mobidam.mdl;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
/*
 * TODO:
 * This class is the first attempt to process the MDS ModelsVehicle objects to a CSV file
 * with the possibility to define the fields the should be included.
 * The first next step should be to implement this processor into the EAI route, as the current
 * version is meant for local testing.
 * Further criteria could be found in the ticket MDAS-1583.
 * TODO: 
 * If the project is continued, it would be worth considering how the CSV conversion
 * can be implemented with Camel Bindy and without the intermediate step of file output and
 * instead in-memory.
 */
public class ProcessToCsv implements Processor {

    private static final String[] INCLUDED_FIELDS = {
            "provider_id", "device_id", "vehicle_id", "vehicle_type",
            "propulsion_types", "accessibility_attributes", "battery_capacity", "maximum_speed"
    };

    private final String outputFilePath = ".";

    @Override
    public void process(Exchange exchange) throws Exception {
        List<?> vehicles = exchange.getIn().getBody(List.class);

        if (vehicles == null || vehicles.isEmpty()) {
            return;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            // Write CSV header
            writer.writeNext(INCLUDED_FIELDS);

            for (Object vehicle : vehicles) {
                Class<?> clazz = vehicle.getClass();
                String[] row = new String[INCLUDED_FIELDS.length];

                for (int i = 0; i < INCLUDED_FIELDS.length; i++) {
                    try {
                        Field field = clazz.getDeclaredField(INCLUDED_FIELDS[i]);
                        field.setAccessible(true);
                        Object value = field.get(vehicle);
                        row[i] = value != null ? value.toString() : "";
                    } catch (NoSuchFieldException e) {
                        row[i] = ""; // Field not found, leave empty
                    }
                }

                writer.writeNext(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Schreiben der CSV-Datei", e);
        }
    }
}
