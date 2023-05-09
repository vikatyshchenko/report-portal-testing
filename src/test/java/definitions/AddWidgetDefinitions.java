package definitions;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.steps.DashboardsSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomInt;

@Getter
@Setter
public class AddWidgetDefinitions {

    private DashboardsSteps dashboardsSteps = new DashboardsSteps();
    private static final String DASHBOARD_NAME = "DEMO DASHBOARD";
    private static final String FILTER_NAME = "DEMO_FILTER";

    private WidgetType widgetType;
    private String widgetName;

    protected final int RANDOM_VALUE = generateRandomInt(1000, 9999);

    @Given("User is on a Dashboard Page")
    public void userIsOnADashboardPage() {
        dashboardsSteps.assertDashboardVisible(DASHBOARD_NAME);
    }

    @And("User have chosen a Dashboard")
    public void userHaveChosenADashboard() {
        dashboardsSteps.selectDashboard(DASHBOARD_NAME);
    }

    @When("User creates new Widget")
    public void userCreatesNewWidgetWithTypeAndName(DataTable dataTable) {
        Map<String, String> widgetInfo = dataTable.asMap(String.class, String.class);
        WidgetType widget = Enum.valueOf(WidgetType.class, widgetInfo.get("type"));
        String widgetName = widgetInfo.get("name").concat(" " + RANDOM_VALUE);
        dashboardsSteps.addNewWidget()
                .chooseWidgetType(widget)
                .configureWidget(FILTER_NAME, widget)
                .typeWidgetName(widgetName)
                .createWidget();
        setWidgetName(widgetName);
        setWidgetType(widget);
    }

    @Then("New widget is created and visible on a Dashboard Page")
    public void newWidgetIsCreatedAndVisibleOnADashboardPage() {
        dashboardsSteps.assertWidgetVisible(getWidgetName(), getWidgetType());
    }

    @And("Widget can be deleted")
    public void widgetCanBeDeleted() {
        dashboardsSteps.deleteWidget(getWidgetName());
    }

}
