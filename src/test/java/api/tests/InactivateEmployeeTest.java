package api.tests;

import api.models.employee.inactivateEmployee.InactivateEmployeeResponse;
import api.services.InactivateEmployeeService;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InactivateEmployeeTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_inactivateEmployeeSuccess() {

        Assert.assertNotNull(
                TestData.employeeId,
                "Employee ID tidak ditemukan"
        );

        ApiResponse<InactivateEmployeeResponse> response =
                InactivateEmployeeService.inactivateEmployee(
                        TestData.employeeId
                );

        InactivateEmployeeResponse inactivateEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(response.getStatusCode(), 200);

        Assert.assertNotNull(
                inactivateEmployeeResponse,
                "Response body null"
        );

        if (inactivateEmployeeResponse.errors != null) {

            Assert.assertEquals(
                    inactivateEmployeeResponse.errors.get(0).message,
                    "Employee already inactive"
            );

        } else {

            Assert.assertNotNull(
                    inactivateEmployeeResponse.data,
                    "Data response null"
            );

            Assert.assertTrue(
                    inactivateEmployeeResponse.data.inactivateEmployee,
                    "Employee gagal di-inactivate"
            );
        }
    }
}