package api.tests.division;

import api.models.division.deleteDivision.DeleteDivisionResponse;
import api.services.division.DeleteDivisionService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteDivisionTest
        extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_deleteDivisionSuccess() {

        Assert.assertNotNull(
                TestData.divisionId,
                "Division ID tidak ditemukan"
        );

        ApiResponse<DeleteDivisionResponse> response =
                DeleteDivisionService.deleteDivision(
                        TestData.divisionId
                );

        DeleteDivisionResponse deleteDivisionResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNotNull(
                deleteDivisionResponse,
                "Response body null"
        );

        if (deleteDivisionResponse.errors != null
                && !deleteDivisionResponse.errors.isEmpty()) {

            Assert.assertEquals(
                    deleteDivisionResponse.errors.get(0).message,
                    "Division not found"
            );

        } else {

            Assert.assertNotNull(
                    deleteDivisionResponse.data,
                    "Data response null"
            );

            Assert.assertTrue(
                    deleteDivisionResponse.data.deleteDivision,
                    "Delete division gagal"
            );
        }
    }
}