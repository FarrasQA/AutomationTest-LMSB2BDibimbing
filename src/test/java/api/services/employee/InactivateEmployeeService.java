package api.services.employee;

import api.client.GraphQlClient;
import api.models.employee.inactivateEmployee.InactivateEmployeeResponse;
import api.models.employee.inactivateEmployee.InactivateEmployeeVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class InactivateEmployeeService {

    public static ApiResponse<InactivateEmployeeResponse> inactivateEmployee(
            String id
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/employee/InactivateEmployee.graphql"
        );

        InactivateEmployeeVariables variables =
                new InactivateEmployeeVariables(id);

        Response response = GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(InactivateEmployeeResponse.class)
        );
    }
}