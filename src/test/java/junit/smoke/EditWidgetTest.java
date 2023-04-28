package junit.smoke;

import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.report.portal.business.constants.WidgetType.LAUNCH_STAT;
import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomString;

class EditWidgetTest extends BaseTest {

    private final String DEFAULT_WIDGET_NAME = "LAUNCH STATISTICS AREA";
    private static final String RANDOM_WIDGET_NAME = generateRandomString(128);
    private static final String RANDOM_WIDGET_DESCRIPTION = generateRandomString(1500);

    private static Stream<Arguments> getWidgetName() {
        return Stream.of(
                Arguments.of("TST"),
                Arguments.of("0123456789"),
                Arguments.of("[$&+,:;=?@#|<>.-^*()%!]"),
                Arguments.of(RANDOM_WIDGET_NAME)
        );
    }

    private static Stream<Arguments> getWidgetDescription() {
        return Stream.of(
                Arguments.of("T"),
                Arguments.of("0123456789"),
                Arguments.of("[$&+,:;=?@#|<>.-^*()%!]"),
                Arguments.of(RANDOM_WIDGET_DESCRIPTION)
        );
    }

    @ParameterizedTest()
    @MethodSource("getWidgetName")
    @Description("Create widget test")
    void editWidgetNameTest(String widgetName) {
        dashboardsSteps.setWidgetName(DEFAULT_WIDGET_NAME);
        dashboardsSteps
                .editWidgetName(widgetName)
                .assertWidgetVisible(LAUNCH_STAT)
                .editWidgetName(DEFAULT_WIDGET_NAME)
                .assertWidgetVisible(LAUNCH_STAT);
    }

    @ParameterizedTest()
    @Description("Create widget test")
    @MethodSource("getWidgetDescription")
    void editWidgetDescriptionTest(String widgetDescription) {
        dashboardsSteps.setWidgetName(DEFAULT_WIDGET_NAME);
        dashboardsSteps
                .editWidgetDescription(DEFAULT_WIDGET_NAME, widgetDescription)
                .assertWidgetDescriptionVisible(DEFAULT_WIDGET_NAME, widgetDescription)
                .editWidgetDescription(DEFAULT_WIDGET_NAME, "")
                .assertWidgetDescriptionInVisible(DEFAULT_WIDGET_NAME);
    }

}
