package api.services.division;

import api.client.GraphQlClient;
import api.models.division.updateDivision.UpdateDivisionResponse;
import api.models.division.updateDivision.UpdateDivisionVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class UpdateDivisionService {

    public static ApiResponse<UpdateDivisionResponse> updateDivision(
            String id,
            String name,
            String description
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/division/UpdateDivision.graphql"
        );

        UpdateDivisionVariables variables =
                new UpdateDivisionVariables(
                        id,
                        name,
                        description
                );

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(UpdateDivisionResponse.class)
        );
    }
}