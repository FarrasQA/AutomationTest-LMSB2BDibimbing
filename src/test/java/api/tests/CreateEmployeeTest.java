package api.tests;

import api.models.employee.createEmployee.CreateEmployeeResponse;
import api.services.CreateEmployeeService;
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

        // VALIDASI ERROR RESPONSE
        if (createEmployeeResponse.errors != null
                && !createEmployeeResponse.errors.isEmpty()) {

            String errorMessage =
                    createEmployeeResponse.errors.get(0).message;

            Assert.fail(
                    "Create employee gagal: " + errorMessage
            );
        }

        // VALIDASI SUCCESS RESPONSE
        Assert.assertNotNull(
                createEmployeeResponse.data,
                "Data response null"
        );

        Assert.assertNotNull(
                createEmployeeResponse.data.createEmployee,
                "Create employee gagal"
        );

        Assert.assertNotNull(
                createEmployeeResponse.data.createEmployee.id,
                "Employee id null"
        );

        // SIMPAN EMPLOYEE ID
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
                "Harap isi field yang wajib diisi"
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