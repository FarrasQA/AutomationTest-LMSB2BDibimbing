package api.services.division;

import api.client.GraphQlClient;
import api.models.division.createDivision.CreateDivisionResponse;
import api.models.division.createDivision.CreateDivisionVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class CreateDivisionService {

    public static ApiResponse<CreateDivisionResponse> createDivision(
            String name,
            String description
    ) {

        String query =
                TestDataLoader.load(
                        "graphql/mutations/division/CreateDivision.graphql"
                );

        CreateDivisionVariables variables =
                new CreateDivisionVariables(
                        name,
                        description
                );

        Response response =
                GraphQlClient.execute(
                        query,
                        variables
                );

        System.out.println(
                "Status: " + response.getStatusCode()
        );

        System.out.println(
                "Response body: "
                        + response.getBody().asString()
        );

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(CreateDivisionResponse.class)
        );
    }
}
