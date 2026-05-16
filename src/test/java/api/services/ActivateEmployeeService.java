package api.services;

import api.client.GraphQlClient;
import api.models.employee.activateEmployee.ActivateEmployeeResponse;
import api.models.employee.activateEmployee.ActivateEmployeeVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class ActivateEmployeeService {

    public static ApiResponse<ActivateEmployeeResponse> activateEmployee(
            String id
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/ActivateEmployee.graphql"
        );

        ActivateEmployeeVariables variables =
                new ActivateEmployeeVariables(id);

        Response response = GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(ActivateEmployeeResponse.class)
        );
    }
}