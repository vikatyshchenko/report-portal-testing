package junit.smoke;

import com.report.portal.business.steps.BaseSteps;
import com.report.portal.business.steps.DashboardsSteps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomInt;

public class BaseTest {

    protected static final String DASHBOARD_NAME = "DEMO DASHBOARD";
    protected static final String FILTER_NAME = "DEMO_FILTER";
    protected static final int RANDOM_VALUE = generateRandomInt(1000, 9999);
    static BaseSteps baseSteps = new BaseSteps();
    static DashboardsSteps dashboardsSteps;

    @BeforeAll
    public static void login() {
        dashboardsSteps = baseSteps.login()
                .isLogoVisible()
                .goToDashboards()
                .selectDashboard(DASHBOARD_NAME);
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }

}
