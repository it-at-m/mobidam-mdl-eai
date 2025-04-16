package org.openapijsonschematools.client.components.securityschemes;

import org.openapijsonschematools.client.securityschemes.HttpBearerSecurityScheme;

public class Bearer extends HttpBearerSecurityScheme {
    /*
    All MDS Provider endpoints require authentication.

JSON Web Token ([JWT](https://jwt.io/introduction/)) is RECOMMENDED as the token format.

MDS API producers MAY include any metadata in the JWT they wish that helps to route, log, permission, or debug agency requests, leaving their internal implementation flexible.
    */
    public Bearer(String accessToken) {
        super(accessToken, "JWT");
    }
}
