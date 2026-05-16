package ui.tests.employeeList;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.employeeList.EditEmployee;
import ui.pages.employeeMenu.EmployeeMenu;


public class EditEmployeeTest extends EmployeeBaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(EditEmployeeTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_editEmployee1_editRole() {

        log.info("Edit employee role");

        EditEmployee editEmployee =
                new EditEmployee(DriverManager.getDriver());

        editEmployee.editRoleEmployee(
                config.getProperty("employeeName"),
                config.getProperty("editEmployeeRole")
        );

        Assert.assertTrue(
                editEmployee.isUserSuccessEditRoleEmployee(),
                "User should see success edit employee notification"
        );

    }

    @Test (priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_editEmployee2_editRoleWithEmptyData() {

        log.info("Edit employee role with empty data");

        EditEmployee editEmployee =
                new EditEmployee(DriverManager.getDriver());

        editEmployee.editRoleEmployeeWithEmptyData(
                config.getProperty("employeeName")
        );

        Assert.assertTrue(
                editEmployee.isUserFailEditRoleEmployee(),
                "User should see fill required field notification"
        );


    }

    @Test (priority = 3, groups = {"smoke", "regression"})
    public void ts_ui_editEmployee3_editActiveToInactiveStatus() {

        log.info("Edit employee status from active to inactive");

        EmployeeMenu employeeMenu =
                new EmployeeMenu(DriverManager.getDriver());
        employeeMenu.manageEmployeeData();

        EditEmployee editEmployee =
                new EditEmployee(DriverManager.getDriver());

        editEmployee.editActiveToInactiveStatusEmployee(
                config.getProperty("employeeName")
        );

        Assert.assertTrue(
                editEmployee.isUserSuccessInactiveStatusEmployee(),
                "User should see inactive employee status"
        );

    }

    @Test (priority = 4, groups = {"smoke", "regression"})
    public void ts_ui_editEmployee4_editInactiveToActiveStatus() {

        log.info("Edit employee status from inactive to active");

        EmployeeMenu employeeMenu =
                new EmployeeMenu(DriverManager.getDriver());
        employeeMenu.manageEmployeeData();

        EditEmployee editEmployee =
                new EditEmployee(DriverManager.getDriver());

        editEmployee.editInactiveToActiveStatusEmployee(
                config.getProperty("employeeName")
        );

        Assert.assertTrue(
                editEmployee.isUserSuccessActiveStatusEmployee(),
                "User should see active employee status"
        );

    }
}