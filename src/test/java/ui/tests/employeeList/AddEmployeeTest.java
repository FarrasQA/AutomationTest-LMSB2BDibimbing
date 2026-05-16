package ui.tests.employeeList;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.employeeList.AddEmployee;
import ui.test.employeeList.EmployeeBaseTest;

public class AddEmployeeTest extends EmployeeBaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(AddEmployeeTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_addEmployee1_successAddEmployee() {

        log.info("Add employee");

        AddEmployee addEmployee =
                new AddEmployee(DriverManager.getDriver());

        addEmployee.addEmployee(
                config.getProperty("employeeName"),
                config.getProperty("employeeID"),
                config.getProperty("employeeEmail"),
                config.getProperty("employeePhoneNumber"),
                config.getProperty("employeeRole")
        );

        Assert.assertTrue(
                addEmployee.isUserSuccessAddEmployee(),
                "User should see success add employee notification"
        );
    }

    @Test (priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_addEmployee2_failAddEmployeeWithEmptyData() {

        log.info("Add employee with empty data");

        AddEmployee addEmployee =
                new AddEmployee(DriverManager.getDriver());

        addEmployee.addEmployeeWithEmptyData();

        Assert.assertTrue(
                addEmployee.isUserFailAddEmployeeWithEmptyData(),
                "User should see validation message"
        );
    }

    @Test (priority = 3, groups = {"smoke", "regression"})
    public void ts_ui_addEmployee3_failAddEmployeeWithDuplicateData() {

        log.info("Add employee with duplicate data");

        AddEmployee addEmployee =
                new AddEmployee(DriverManager.getDriver());

        addEmployee.addEmployee(
                config.getProperty("employeeName"),
                config.getProperty("employeeID"),
                config.getProperty("employeeEmail"),
                config.getProperty("employeePhoneNumber"),
                config.getProperty("employeeRole")
        );

        Assert.assertTrue(
                addEmployee.isUserFailAddEmployeeWithDuplicateData(),
                "User should see duplicate employee notification"
        );
    }
}