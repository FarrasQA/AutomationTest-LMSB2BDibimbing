package api.tests.employee;

import api.models.employee.activateEmployee.ActivateEmployeeResponse;
import api.services.employee.ActivateEmployeeService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateEmployeeTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_activateEmployeeSuccess() {

        Assert.assertNotNull(
                TestData.employeeId,
                "Employee ID tidak ditemukan"
        );

        ApiResponse<ActivateEmployeeResponse> response =
                ActivateEmployeeService.activateEmployee(
                        TestData.employeeId
                );

        ActivateEmployeeResponse activateEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(
                activateEmployeeResponse,
                "Response body null"
        );

        if (activateEmployeeResponse.errors != null) {

            Assert.assertEquals(
                    activateEmployeeResponse.errors.get(0).message,
                    "Employee already active"
            );

        } else {

            Assert.assertNotNull(
                    activateEmployeeResponse.data,
                    "Data response null"
            );

            Assert.assertTrue(
                    activateEmployeeResponse.data.activateEmployee,
                    "Employee gagal di-activate"
            );
        }
    }
}