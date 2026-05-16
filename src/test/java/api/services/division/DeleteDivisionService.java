package api.services.division;

import api.client.GraphQlClient;
import api.models.division.deleteDivision.DeleteDivisionResponse;
import api.models.division.deleteDivision.DeleteDivisionVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class DeleteDivisionService {

    public static ApiResponse<DeleteDivisionResponse> deleteDivision(
            String id
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/division/DeleteDivision.graphql"
        );

        DeleteDivisionVariables variables =
                new DeleteDivisionVariables(id);

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(DeleteDivisionResponse.class)
        );
    }
}