package api.services;

import api.client.GraphQlClient;
import api.models.employee.createEmployee.CreateEmployeeResponse;
import api.models.employee.createEmployee.CreateEmployeeVariables;
import api.utils.ApiResponse;
import api.utils.TestDataLoader;
import io.restassured.response.Response;

public class CreateEmployeeService {
  public static ApiResponse<CreateEmployeeResponse> createEmployee(
    String name,
    String employeeId,
    String email,
    String phoneNumber,
    String divisionId,
    String employeeRole
  ) {
    String query = TestDataLoader.load("graphql/mutations/CreateEmployee.graphql");
    CreateEmployeeVariables variables = new CreateEmployeeVariables(
      name,
      employeeId,
      email,
      phoneNumber,
      divisionId,
      employeeRole
    );

    Response response = GraphQlClient.execute(
      query,
      variables
    );

    System.out.println("Status: " + response.getStatusCode());
    System.out.println("Response body: " + response.getBody().asString());

    return new ApiResponse<>(
      response.getStatusCode(),
      response.getHeaders(),
      response.as(CreateEmployeeResponse.class)
    );
  }
}
