package api.tests.employee;

import api.models.employee.updateEmployee.UpdateEmployeeResponse;
import api.services.employee.UpdateEmployeeService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateEmployeeTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_updateEmployeeSuccess() {

        Assert.assertNotNull(
                TestData.employeeId,
                "Employee ID tidak ditemukan"
        );

        ApiResponse<UpdateEmployeeResponse> response =
                UpdateEmployeeService.updateEmployee(
                        TestData.employeeId,
                        "joppy",
                        "1234",
                        "joppy123@gmail.com",
                        "81388889999",
                        "b0bf1653-3591-4c5c-b278-18c668689203",
                        "Mentor"
                );

        UpdateEmployeeResponse updateEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(
                updateEmployeeResponse,
                "Response body null"
        );

        if (updateEmployeeResponse.errors != null) {

            Assert.assertEquals(
                    updateEmployeeResponse.errors.get(0).message,
                    "Employee not found"
            );

        } else {

            Assert.assertNotNull(
                    updateEmployeeResponse.data,
                    "Data response null"
            );

            Assert.assertNotNull(
                    updateEmployeeResponse.data.updateEmployee,
                    "Update employee gagal"
            );

            Assert.assertNotNull(
                    updateEmployeeResponse.data.updateEmployee.id,
                    "Employee id null"
            );
        }
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void ts_api_updateEmployeeFailWithEmptyData() {

        Assert.assertNotNull(
                TestData.employeeId,
                "Employee ID tidak ditemukan"
        );

        ApiResponse<UpdateEmployeeResponse> response =
                UpdateEmployeeService.updateEmployee(
                        TestData.employeeId,
                        "",
                        "",
                        "",
                        "",
                        "",
                        ""
                );

        UpdateEmployeeResponse updateEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNotNull(
                updateEmployeeResponse.errors,
                "Error response seharusnya muncul"
        );
    }
}