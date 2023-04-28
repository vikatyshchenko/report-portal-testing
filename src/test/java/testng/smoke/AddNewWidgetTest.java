package testng.smoke;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.steps.BaseSteps;
import com.report.portal.business.steps.DashboardsSteps;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.report.portal.business.constants.WidgetType.*;
import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomInt;

public class AddNewWidgetTest {

    BaseSteps baseSteps = new BaseSteps();
    DashboardsSteps dashboardsSteps;

    protected final String DASHBOARD_NAME = "DEMO DASHBOARD";
    protected final String FILTER_NAME = "DEMO_FILTER";

    protected final int randomValue = generateRandomInt(1000, 9999);

    @DataProvider(name = "widgetType", parallel = true)
    public Object[][] getWidgetType() {
        return new Object[][]{
                {LAUNCH_STAT},
                {LAUNCH_DURATION},
                {OVERALL_STAT},
                {FAILED_CASE_TREND}
        };
    }

    @BeforeMethod
    public void login() {
        dashboardsSteps = baseSteps.login()
                .isLogoVisible()
                .goToDashboards()
                .selectDashboard(DASHBOARD_NAME);
    }

    @AfterMethod
    public void close() {
        closeWebDriver();
    }

    @Test(dataProvider = "widgetType")
    @Description("Create widget test")
    public void createWidgetTest(WidgetType widgetType) {
        dashboardsSteps
                .addNewWidget()
                .chooseWidgetType(widgetType)
                .configureWidget(FILTER_NAME, widgetType)
                .describeWidget(widgetType, randomValue)
                .createWidget()
                .assertWidgetVisible(widgetType)
                .deleteWidget();
    }

}
