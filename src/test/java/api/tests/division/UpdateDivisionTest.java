package api.tests.division;

import api.models.division.updateDivision.UpdateDivisionResponse;
import api.services.division.UpdateDivisionService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateDivisionTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_updateDivisionSuccess() {

        Assert.assertNotNull(
                TestData.divisionId,
                "Division ID tidak ditemukan"
        );

        ApiResponse<UpdateDivisionResponse> response =
                UpdateDivisionService.updateDivision(
                        TestData.divisionId,
                        "Quality Assurance AI",
                        "Quality Assurance for Artificial Intelligence"
                );

        UpdateDivisionResponse updateDivisionResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void ts_api_updateDivisionFailWithEmptyData() {

        Assert.assertNotNull(
                TestData.divisionId,
                "Division ID tidak ditemukan"
        );

        ApiResponse<UpdateDivisionResponse> response =
                UpdateDivisionService.updateDivision(
                        TestData.divisionId,
                        "",
                        ""
                );

        UpdateDivisionResponse updateDivisionResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNotNull(
                updateDivisionResponse.errors,
                "Error response seharusnya muncul"
        );
    }
}