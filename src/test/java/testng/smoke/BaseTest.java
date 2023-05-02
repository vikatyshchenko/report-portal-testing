package testng.smoke;

import com.report.portal.business.steps.BaseSteps;
import com.report.portal.business.steps.DashboardsSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected static final String DASHBOARD_NAME = "DEMO DASHBOARD";
    BaseSteps baseSteps = new BaseSteps();
    DashboardsSteps dashboardsSteps;

    @BeforeTest
    public void login() {
        dashboardsSteps = baseSteps.login()
                .isLogoVisible()
                .goToDashboards()
                .selectDashboard(DASHBOARD_NAME);
    }

    @AfterTest
    public void close() {
        closeWebDriver();
    }

}
