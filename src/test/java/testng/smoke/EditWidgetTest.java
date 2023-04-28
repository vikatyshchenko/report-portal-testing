package testng.smoke;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.report.portal.business.constants.WidgetType.LAUNCH_STAT;
import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomString;

public class EditWidgetTest extends BaseTest {

    private final String DEFAULT_WIDGET_NAME = "LAUNCH STATISTICS AREA";
    private final String RANDOM_WIDGET_NAME = generateRandomString(128);
    private final String RANDOM_WIDGET_DESCRIPTION = generateRandomString(1500);

    @DataProvider(name = "widgetName")
    public Object[][] getWidgetName() {
        return new Object[][]{
                {"TST"},
                {"0123456789"},
                {"[$&+,:;=?@#|<>.-^*()%!]"},
                {RANDOM_WIDGET_NAME}
        };
    }

    @DataProvider(name = "widgetDescription")
    public Object[][] getWidgetDescription() {
        return new Object[][]{
                {"T"},
                {"0123456789"},
                {"[$&+,:;=?@#|<>.-^*()%!]"},
                {RANDOM_WIDGET_DESCRIPTION}
        };
    }

    @Test(dataProvider = "widgetName")
    @Description("Create widget test")
    public void editWidgetNameTest(String widgetName) {
        dashboardsSteps.setWidgetName(DEFAULT_WIDGET_NAME);
        dashboardsSteps
                .editWidgetName(widgetName)
                .assertWidgetVisible(LAUNCH_STAT)
                .editWidgetName(DEFAULT_WIDGET_NAME)
                .assertWidgetVisible(LAUNCH_STAT);
    }

    @Test(dataProvider = "widgetDescription")
    @Description("Create widget test")
    public void editWidgetDescriptionTest(String widgetDescription) {
        dashboardsSteps.setWidgetName(DEFAULT_WIDGET_NAME);
        dashboardsSteps
                .editWidgetDescription(DEFAULT_WIDGET_NAME, widgetDescription)
                .assertWidgetDescriptionVisible(DEFAULT_WIDGET_NAME, widgetDescription)
                .editWidgetDescription(DEFAULT_WIDGET_NAME, "")
                .assertWidgetDescriptionInVisible(DEFAULT_WIDGET_NAME);
    }

}
