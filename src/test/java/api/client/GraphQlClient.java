package api.client;

import api.config.EnvConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class GraphQlClient {

    public static Response execute(String query, Object vars) {
        boolean isDebug = "true".equals(EnvConfig.DEBUG);

        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(EnvConfig.BASE_URL)
                .contentType(ContentType.JSON);

        if (isDebug) requestSpecification.log().all();

        String sessionCookie = AuthSession.getSessionCookie();
        if (sessionCookie != null) {
            requestSpecification.cookie("sid_b2b", sessionCookie);
        }

        Response response = requestSpecification
                .body(Map.of("query", query, "variables", vars))
                .post("")
                .then()
                .extract()
                .response();

        if (isDebug) {
            System.out.println("Status: " + response.getStatusCode());
            System.out.println("Response body: " + response.getBody().asString());
        }

        return response;
    }
}