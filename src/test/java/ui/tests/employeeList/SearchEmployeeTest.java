package ui.tests.employeeList;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.employeeList.SearchEmployee;
import ui.test.employeeList.EmployeeBaseTest;

public class SearchEmployeeTest extends EmployeeBaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(SearchEmployeeTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_searchEmployee1_searchEmployeeByName() {

        log.info("Search employee by name");

        SearchEmployee searchEmployee =
                new SearchEmployee(DriverManager.getDriver());

        searchEmployee.searchEmployeeByName(
                config.getProperty("employeeName")
        );

        Assert.assertTrue(
                searchEmployee.isUserSuccesssearchEmployeeByName(),
                "User should see employee information filtered according to the entered keywords"
        );
    }

    @Test (priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_searchEmployee2_searchEmployeeByID() {

        log.info("Search employee by ID");

        SearchEmployee searchEmployee =
                new SearchEmployee(DriverManager.getDriver());

        searchEmployee.searchEmployeeByID(
                config.getProperty("employeeID")
        );

        Assert.assertTrue(
                searchEmployee.isUserSuccesssearchEmployeeByID(),
                "User should see employee information filtered according to the entered keywords"
        );
    }

    @Test (priority = 3, groups = {"smoke", "regression"})
    public void ts_ui_searchEmployee3_searchEmployeeByEmail() {

        log.info("Search employee by email");

        SearchEmployee searchEmployee =
                new SearchEmployee(DriverManager.getDriver());

        searchEmployee.searchEmployeeByEmail(
                config.getProperty("employeeEmail")
        );

        Assert.assertTrue(
                searchEmployee.isUserSuccesssearchEmployeeByEmail(),
                "User should see employee information filtered according to the entered keywords"
        );
    }
}