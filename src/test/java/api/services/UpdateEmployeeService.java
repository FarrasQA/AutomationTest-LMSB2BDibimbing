package api.services;

import api.client.GraphQlClient;
import api.models.employee.updateEmployee.UpdateEmployeeResponse;
import api.models.employee.updateEmployee.UpdateEmployeeVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class UpdateEmployeeService {

    public static ApiResponse<UpdateEmployeeResponse> updateEmployee(
            String id,
            String name,
            String employeeId,
            String email,
            String phoneNumber,
            String divisionId,
            String employeeRole
    ) {

        String query = TestDataLoader.load(
                "graphql/mutations/UpdateEmployee.graphql"
        );

        UpdateEmployeeVariables variables =
                new UpdateEmployeeVariables(
                        id,
                        name,
                        employeeId,
                        email,
                        phoneNumber,
                        divisionId,
                        employeeRole
                );

        Response response = GraphQlClient.execute(query, variables);

        return new ApiResponse<>(
                response.getStatusCode(),
                response.getHeaders(),
                response.as(UpdateEmployeeResponse.class)
        );
    }
}