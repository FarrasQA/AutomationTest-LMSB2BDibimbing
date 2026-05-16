package api.tests.employee;

import api.models.employee.createEmployee.CreateEmployeeResponse;
import api.services.employee.CreateEmployeeService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEmployeeTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_createEmployeeSuccess() {

        ApiResponse<CreateEmployeeResponse> response =
                CreateEmployeeService.createEmployee(
                        "joppy",
                        "1234",
                        "joppy123@gmail.com",
                        "81388889999",
                        "b0bf1653-3591-4c5c-b278-18c668689203",
                        "Manajer"
                );

        CreateEmployeeResponse createEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        TestData.employeeId =
                createEmployeeResponse.data.createEmployee.id;
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void ts_api_createEmployeeFailWithEmptyData() {

        ApiResponse<CreateEmployeeResponse> response =
                CreateEmployeeService.createEmployee(
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                );

        CreateEmployeeResponse createEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNull(
                createEmployeeResponse.data,
                "Data seharusnya null"
        );

        Assert.assertNotNull(
                createEmployeeResponse.errors,
                "Error response seharusnya muncul"
        );
    }

    @Test(priority = 3, groups = {"smoke", "regression"})
    public void ts_api_createEmployeeFailWithDuplicateData() {

        ApiResponse<CreateEmployeeResponse> response =
                CreateEmployeeService.createEmployee(
                        "joppy",
                        "1234",
                        "joppy123@gmail.com",
                        "81388889999",
                        "b0bf1653-3591-4c5c-b278-18c668689203",
                        "Manajer"
                );

        CreateEmployeeResponse createEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNull(
                createEmployeeResponse.data,
                "Data seharusnya null"
        );

        Assert.assertNotNull(
                createEmployeeResponse.errors,
                "Error duplicate email seharusnya muncul"
        );
    }
}