package org.openapijsonschematools.client.paths.stopsstopid.parameters;

import org.openapijsonschematools.client.parameter.ParameterStyle;
import org.openapijsonschematools.client.parameter.ParameterInType;
import org.openapijsonschematools.client.parameter.SchemaParameter;
import org.openapijsonschematools.client.paths.stopsstopid.parameters.routeparameter0.RouteParamSchema02;

public class RouteParameter0 {

    public static class RouteParameter01 extends SchemaParameter {
        public RouteParameter01() {
            super(
                "stop_id",
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
