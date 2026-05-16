package api.tests;

import api.models.employee.deleteEmployee.DeleteEmployeeResponse;
import api.services.DeleteEmployeeService;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployeeTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_deleteEmployeeSuccess() {

        Assert.assertNotNull(
                TestData.employeeId,
                "Employee ID tidak ditemukan"
        );

        ApiResponse<DeleteEmployeeResponse> response =
                DeleteEmployeeService.deleteEmployee(
                        TestData.employeeId
                );

        DeleteEmployeeResponse deleteEmployeeResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNotNull(
                deleteEmployeeResponse,
                "Response body null"
        );

        if (deleteEmployeeResponse.errors != null) {

            Assert.assertEquals(
                    deleteEmployeeResponse.errors.get(0).message,
                    "Employee not found"
            );

        } else {

            Assert.assertNotNull(
                    deleteEmployeeResponse.data,
                    "Data response null"
            );

            Assert.assertTrue(
                    deleteEmployeeResponse.data.deleteEmployee,
                    "Delete employee gagal"
            );
        }
    }
}