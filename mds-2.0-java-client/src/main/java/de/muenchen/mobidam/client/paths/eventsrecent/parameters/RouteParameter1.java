package org.openapijsonschematools.client.paths.eventsrecent.parameters;

import org.openapijsonschematools.client.parameter.ParameterStyle;
import org.openapijsonschematools.client.parameter.ParameterInType;
import org.openapijsonschematools.client.parameter.SchemaParameter;
import org.openapijsonschematools.client.paths.eventsrecent.parameters.routeparameter1.RouteParamSchema12;

public class RouteParameter1 {

    public static class RouteParameter11 extends SchemaParameter {
        public RouteParameter11() {
            super(
                "end_time",
                ParameterInType.QUERY,
                true,
                ParameterStyle.FORM,
                true,
                false,
                RouteParamSchema12.RouteParamSchema13.getInstance()
            );
        }
    }
}
