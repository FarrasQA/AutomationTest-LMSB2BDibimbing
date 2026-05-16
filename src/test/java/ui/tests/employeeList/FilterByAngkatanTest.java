package ui.tests.employeeList;

import core.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.employeeList.FilterByAngkatan;
import ui.pages.employeeMenu.EmployeeMenu;


public class FilterByAngkatanTest extends EmployeeBaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(FilterByAngkatanTest.class);

    @Test (priority = 1, groups = {"smoke", "regression"})
    public void ts_ui_filterByAngkatan1_filterEmployeeAllAngkatan() {

        log.info("Filter all angkatan");

        FilterByAngkatan filterByAngkatan =
                new FilterByAngkatan(DriverManager.getDriver());

        filterByAngkatan.filterAllAngkatan();
    }

    @Test (priority = 2, groups = {"smoke", "regression"})
    public void ts_ui_filterByAngkatan2_filterEmployee2024Ganjil() {

        log.info("Filter 2024 ganjil");

        FilterByAngkatan filterByAngkatan =
                new FilterByAngkatan(DriverManager.getDriver());

        filterByAngkatan.filterAngkatan2024Ganjil();

        Assert.assertTrue(
                filterByAngkatan.isUserSuccessFilterEmployee2024Ganjil(),
                "User should see 2024 ganjil employee data"
        );

    }

    @Test (priority = 3, groups = {"smoke", "regression"})
    public void ts_ui_filterByAngkatan3_filterEmployee2024Genap() {

        log.info("Filter 2024 genap");

        FilterByAngkatan filterByAngkatan =
                new FilterByAngkatan(DriverManager.getDriver());

        filterByAngkatan.filterAngkatan2024Genap();

        Assert.assertTrue(
                filterByAngkatan.isUserSuccessFilterEmployee2024Genap(),
                "User should see 2024 genap employee data"
        );

        EmployeeMenu employeeMenu =
                new EmployeeMenu(DriverManager.getDriver());
        employeeMenu.manageEmployeeData();
    }

    @Test (priority = 4, groups = {"smoke", "regression"})
    public void ts_ui_filterByAngkatan4_filterEmployee2025Ganjil() {

        log.info("Filter 2025 ganjil");

        FilterByAngkatan filterByAngkatan =
                new FilterByAngkatan(DriverManager.getDriver());

        filterByAngkatan.filterAngkatan2025Ganjil();

        Assert.assertTrue(
                filterByAngkatan.isUserSuccessFilterEmployee2025Ganjil(),
                "User should see 2025 ganjil employee data"
        );

    }

    @Test (priority = 5, groups = {"smoke", "regression"})
    public void ts_ui_filterByAngkatan5_filterEmployee2025Genap() {

        log.info("Filter 2025 genap");

        FilterByAngkatan filterByAngkatan =
                new FilterByAngkatan(DriverManager.getDriver());

        filterByAngkatan.filterAngkatan2025Genap();

        Assert.assertTrue(
                filterByAngkatan.isUserSuccessFilterEmployee2025Genap(),
                "User should see 2025 genap employee data"
        );

    }
}