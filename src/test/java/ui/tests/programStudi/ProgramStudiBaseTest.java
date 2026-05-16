package ui.tests.programStudi;

import core.BaseTest;
import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import ui.pages.auth.Login;
import ui.pages.employeeMenu.EmployeeMenu;

public class ProgramStudiBaseTest extends BaseTest {

    protected Login login;
    protected EmployeeMenu employeeMenu;

    @BeforeMethod(alwaysRun = true)
    public void setupEmployeePage() {

        login = new Login(DriverManager.getDriver());

        login.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        Assert.assertTrue(
                login.isUserSuccessLogin(),
                "Login gagal - user tidak masuk dashboard"
        );

        employeeMenu = new EmployeeMenu(DriverManager.getDriver());

        employeeMenu.manageEmployeeData();

        Assert.assertTrue(
                employeeMenu.isUserSuccessManageEmployeeData(),
                "Gagal masuk Employee Menu"
        );
    }
}
