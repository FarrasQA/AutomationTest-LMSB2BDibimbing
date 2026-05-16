package api.tests.division;

import api.models.division.createDivision.CreateDivisionResponse;
import api.services.division.CreateDivisionService;
import api.tests.BaseAuthenticatedTest;
import api.utils.ApiResponse;
import api.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDivisionTest extends BaseAuthenticatedTest {

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void ts_api_createDivisionSuccess() {

        ApiResponse<CreateDivisionResponse> response =
                CreateDivisionService.createDivision(
                        "Quality Assurance AI",
                        "Quality Assurance for AI"
                );

        CreateDivisionResponse createDivisionResponse =
                response.getResponseBody();

        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        // ===== NAME =====
        Assert.assertEquals(
                createDivisionResponse
                        .data
                        .createDivision
                        .name,
                "Quality Assurance AI",
                "Division name mismatch"
        );

        // ===== DESCRIPTION =====
        Assert.assertEquals(
                createDivisionResponse
                        .data
                        .createDivision
                        .description,
                "Quality Assurance for AI",
                "Division description mismatch"
        );

        // SIMPAN DIVISION ID
        TestData.divisionId =
                createDivisionResponse
                        .data
                        .createDivision
                        .id;
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void ts_api_createDivisionFailWithEmptyData() {

        ApiResponse<CreateDivisionResponse> response =
                CreateDivisionService.createDivision(
                        "",
                        ""
                );

        CreateDivisionResponse createDivisionResponse =
                response.getResponseBody();


        Assert.assertEquals(
                response.getStatusCode(),
                200
        );

        Assert.assertNull(
                createDivisionResponse.data,
                "Data seharusnya null"
        );

        Assert.assertNotNull(
                createDivisionResponse.errors,
                "Error response seharusnya muncul"
        );
    }
}