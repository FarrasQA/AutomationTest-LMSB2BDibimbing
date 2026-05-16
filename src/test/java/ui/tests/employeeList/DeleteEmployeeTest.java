package ui.tests.employeeList;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.employeeList.DeleteEmployee;
import ui.test.employeeList.EmployeeBaseTest;

public class DeleteEmployeeTest extends EmployeeBaseTest{

    private static final Logger log =
            LoggerFactory.getLogger(DeleteEmployeeTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_deleteEmployee1_successDeleteEmployeeData() {

        log.info("Delete employee");

        DeleteEmployee deleteEmployee =
                new DeleteEmployee(DriverManager.getDriver());

        deleteEmployee.deleteEmployee(
                config.getProperty("employeeName")
        );

        Assert.assertTrue(
                deleteEmployee.isUserSuccessDeleteEmployee(),
                "User should see success delete employee notification"
        );
    }
}