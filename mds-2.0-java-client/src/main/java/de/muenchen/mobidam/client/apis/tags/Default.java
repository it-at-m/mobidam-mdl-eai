package org.openapijsonschematools.client.apis.tags;

import org.openapijsonschematools.client.apiclient.ApiClient;
import org.openapijsonschematools.client.configurations.ApiConfiguration;
import org.openapijsonschematools.client.configurations.SchemaConfiguration;
import org.openapijsonschematools.client.paths.reportsfilename.ReportsfilenameGet;
import org.openapijsonschematools.client.paths.eventshistorical.EventshistoricalGet;
import org.openapijsonschematools.client.paths.vehiclesdeviceid.VehiclesdeviceidGet;
import org.openapijsonschematools.client.paths.eventsrecent.EventsrecentGet;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.VehiclesstatusdeviceidGet;
import org.openapijsonschematools.client.paths.stopsstopid.StopsstopidGet;
import org.openapijsonschematools.client.paths.trips.TripsGet;
import org.openapijsonschematools.client.paths.vehicles.VehiclesGet;
import org.openapijsonschematools.client.paths.stops.StopsGet;
import org.openapijsonschematools.client.paths.telemetry.TelemetryGet;
import org.openapijsonschematools.client.paths.vehiclesstatus.VehiclesstatusGet;

public class Default extends ApiClient implements
    ReportsfilenameGet.GetreportsfilenameOperation,
    EventshistoricalGet.GeteventshistoricaleventTimeOperation,
    VehiclesdeviceidGet.GetvehiclesdeviceIdOperation,
    EventsrecentGet.GeteventsrecentstartTimeendTimeOperation,
    VehiclesstatusdeviceidGet.GetvehiclesstatusdeviceIdOperation,
    StopsstopidGet.GetstopsstopIdOperation,
    TripsGet.GettripsendTimeOperation,
    VehiclesGet.GetvehiclesOperation,
    StopsGet.GetstopsOperation,
    TelemetryGet.GettelemetrytelemetryTimeOperation,
    VehiclesstatusGet.GetvehiclesstatusOperation
{
    public Default(ApiConfiguration apiConfiguration, SchemaConfiguration schemaConfiguration) {
        super(apiConfiguration, schemaConfiguration);
    }
}