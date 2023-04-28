package junit.smoke;

import com.report.portal.business.constants.WidgetType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class AddNewWidgetTest extends BaseTest {

    @ParameterizedTest
    @EnumSource(WidgetType.class)
    void createWidgetTest(WidgetType widgetType) {
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
