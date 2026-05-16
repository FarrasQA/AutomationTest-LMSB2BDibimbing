package ui.tests.programStudi;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import ui.pages.programStudi.AddProgramStudi;
import ui.test.employeeList.ProgramStudiBaseTest;

public class AddProgramStudiTest extends ProgramStudiBaseTest {
    private static final Logger log =
            LoggerFactory.getLogger(AddProgramStudiTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_addProgramStudi1_successAddProgramStudiByFillAllData() {

        log.info("Add program studi by fill all data");

        AddProgramStudi addProgramStudi =
                new AddProgramStudi(DriverManager.getDriver());

        addProgramStudi.addProgramStudi(
                config.getProperty("programStudiName"),
                config.getProperty("programStudiDescription"));

        Assert.assertTrue(
                addProgramStudi.isUserSuccessAddProgramStudi(),
                "User should see success add program studi notification"
        );

    }

    @Test (priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_addProgramStudi2_failAddProgamStudiWithEmptyData() {

        log.info("Add program studi with empty data");

        AddProgramStudi addProgramStudi =
                new AddProgramStudi(DriverManager.getDriver());

        addProgramStudi.addProgramStudiWithEmptyData();

        Assert.assertTrue(addProgramStudi.isUserFailAddProgramStudiWithEmptyData(),
                "User should see requirement fill field notification");
    }

}
