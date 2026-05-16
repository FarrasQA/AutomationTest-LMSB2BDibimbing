package ui.tests.programStudi;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import ui.pages.programStudi.DeleteProgramStudi;


public class DeleteProgramStudiTest extends ProgramStudiBaseTest {
    private static final Logger log = LoggerFactory.getLogger(DeleteProgramStudiTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_deleteProgramStudi1_successDeleteProgramStudi() {

        log.info("Delete program studi");

        DeleteProgramStudi deleteProgramStudi =
                new DeleteProgramStudi(DriverManager.getDriver());

        deleteProgramStudi.deleteProgramStudi(config.getProperty("programStudiName"));

        Assert.assertTrue(deleteProgramStudi.isUserSuccessDeleteProgramStudi(),
                "User should see success delete program studi notification");
    }

}
