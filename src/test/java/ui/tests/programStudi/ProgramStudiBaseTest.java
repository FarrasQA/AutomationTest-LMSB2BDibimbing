package ui.test.employeeList;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.auth.Login;
import ui.pages.employeeMenu.EmployeeMenu;

public class ProgramStudiBaseTest extends BaseTest {

    protected Login login;
    protected EmployeeMenu employeeMenu;

    @BeforeMethod(alwaysRun = true)
    public void setupEmployeePage() {

        // 1. LOGIN STEP
        login = new Login(DriverManager.getDriver());

        login.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        Assert.assertTrue(
                login.isUserSuccessLogin(),
                "Login gagal - user tidak masuk dashboard"
        );

        // 2. DEFAULT STATE: EMPLOYEE MENU
        employeeMenu = new EmployeeMenu(DriverManager.getDriver());

        employeeMenu.manageEmployeeData();

        Assert.assertTrue(
                employeeMenu.isUserSuccessManageEmployeeData(),
                "Gagal masuk halaman Manage Employee"
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownEmployeeTest() {

        try {
            // optional safety step sebelum close
            if (employeeMenu != null) {
                employeeMenu.manageEmployeeData();
            }
        } catch (Exception e) {
            System.out.println("Ignore navigation error: " + e.getMessage());
        }

        DriverManager.quitDriver();
    }
}