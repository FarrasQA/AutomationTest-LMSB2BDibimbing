package api.services.employee;

import api.client.GraphQlClient;
import api.models.employee.deleteEmployee.DeleteEmployeeResponse;
import api.models.employee.deleteEmployee.DeleteEmployeeVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class DeleteEmployeeService {

    public static ApiResponse<DeleteEmployeeResponse> deleteEmployee(
            String id
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/employee/DeleteEmployee.graphql"
        );

        DeleteEmployeeVariables variables =
                new DeleteEmployeeVariables(id);

        Response response =
                GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(DeleteEmployeeResponse.class)
        );
    }
}