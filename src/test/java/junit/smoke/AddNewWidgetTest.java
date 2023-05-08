package junit.smoke;

import com.report.portal.business.constants.WidgetType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.report.portal.business.steps.DashboardsSteps.createWidgetName;

class AddNewWidgetTest extends BaseTest {

    @ParameterizedTest
    @EnumSource(WidgetType.class)
    void createWidgetTest(WidgetType widgetType) {
        String widgetName = createWidgetName(widgetType, RANDOM_VALUE);
        dashboardsSteps
                .addNewWidget()
                .chooseWidgetType(widgetType)
                .configureWidget(FILTER_NAME, widgetType)
                .describeWidget(widgetName)
                .createWidget()
                .assertWidgetVisible(widgetName, widgetType)
                .deleteWidget(widgetName);
    }

}
