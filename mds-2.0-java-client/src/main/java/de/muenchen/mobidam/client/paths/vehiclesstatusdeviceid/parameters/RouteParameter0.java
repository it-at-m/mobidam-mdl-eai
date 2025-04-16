package org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.parameters;

import org.openapijsonschematools.client.parameter.ParameterStyle;
import org.openapijsonschematools.client.parameter.ParameterInType;
import org.openapijsonschematools.client.parameter.SchemaParameter;
import org.openapijsonschematools.client.paths.vehiclesstatusdeviceid.parameters.routeparameter0.RouteParamSchema02;

public class RouteParameter0 {

    public static class RouteParameter01 extends SchemaParameter {
        public RouteParameter01() {
            super(
                "device_id",
                ParameterInType.PATH,
                true,
                ParameterStyle.SIMPLE,
                false,
                false,
                RouteParamSchema02.RouteParamSchema03.getInstance()
            );
        }
    }
}
