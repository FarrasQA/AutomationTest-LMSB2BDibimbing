package ui.tests.programStudi;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import ui.pages.employeeMenu.EmployeeMenu;
import ui.pages.programStudi.EditProgramStudi;


public class EditProgramStudiTest extends ProgramStudiBaseTest {
    private static final Logger log = LoggerFactory.getLogger(EditProgramStudiTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_editProgramStudi1_successEditProgramStudiDescription() {

        log.info("Edit program studi description");

        EditProgramStudi editProgramStudi =
                new EditProgramStudi(DriverManager.getDriver());

        editProgramStudi.editProgramStudiDescription(
                config.getProperty("programStudiName"),
                config.getProperty("editProgramStudiDescription"));

        Assert.assertTrue(editProgramStudi.isUserSuccessEditProgramStudiDescription(),
                "User should see success program studi description save correctly");

        EmployeeMenu employeeMenu =
                new EmployeeMenu(DriverManager.getDriver());
        employeeMenu.manageEmployeeData();
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_editProgramStudi2_failEditProgramStudiWithEmptyDescription() {

        log.info("Edit program studi with empty description");

        EditProgramStudi editProgramStudi =
                new EditProgramStudi(DriverManager.getDriver());

        editProgramStudi.editProgramStudiWithEmptyDescription(
                config.getProperty("programStudiName"));

        Assert.assertTrue(editProgramStudi.isUserFailEditProgramStudiWithEmptyDescription(),
                "User should see requirement fill field notification");


    }

}
