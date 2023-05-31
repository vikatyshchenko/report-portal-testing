package definitions;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.steps.DashboardsService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomInt;

@Getter
@Setter
public class AddWidgetDefinitions {

    private DashboardsService dashboardsService = new DashboardsService();
    private static final String DASHBOARD_NAME = "DEMO DASHBOARD";
    private static final String FILTER_NAME = "DEMO_FILTER";

    private WidgetType widgetType;
    private String widgetName;

    protected final int RANDOM_VALUE = generateRandomInt(1000, 9999);

    @Then("I am on a Dashboard Page")
    public void isOnDashboardPage() {
        dashboardsService.assertDashboardVisible(DASHBOARD_NAME);
    }

    @When("I choose a Dashboard")
    public void choseADashboard() {
        dashboardsService.selectDashboard(DASHBOARD_NAME);
    }

    @When("I create new Widget")
    public void createNewWidgetWithTypeAndName(DataTable dataTable) {
        Map<String, String> widgetInfo = dataTable.asMap(String.class, String.class);
        WidgetType widget = Enum.valueOf(WidgetType.class, widgetInfo.get("type"));
        String widgetName = widgetInfo.get("name").concat(" " + RANDOM_VALUE);
        dashboardsService.addNewWidget()
                .chooseWidgetType(widget)
                .configureWidget(FILTER_NAME, widget)
                .typeWidgetName(widgetName)
                .createWidget();
        setWidgetName(widgetName);
        setWidgetType(widget);
    }

    @Then("New widget is created and visible on a Dashboard Page")
    public void newWidgetIsCreatedAndVisibleOnADashboardPage() {
        dashboardsService.assertWidgetVisible(getWidgetName(), getWidgetType());
    }

    @Then("I delete widget")
    public void deleteWidget() {
        dashboardsService.deleteWidget(getWidgetName());
    }

}
