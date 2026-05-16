package ui.tests.programStudi;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import ui.pages.programStudi.SearchProgramStudi;
import ui.tests.employeeList.ProgramStudiBaseTest;

public class SearchProgramStudiTest extends ProgramStudiBaseTest {
    private static final Logger log = LoggerFactory.getLogger(SearchProgramStudiTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_searchProgramStudi1_successSearchProgramStudi() {

        log.info("Search program studi");

        SearchProgramStudi searchProgramStudi = new SearchProgramStudi(DriverManager.getDriver());

        searchProgramStudi.searchProgramStudi(config.getProperty("programStudiName"));
        Assert.assertTrue(searchProgramStudi.isUserSuccesssearchProgramStudi(),
                "User should see employee information filtered according to the entered keywords");

    }
}
