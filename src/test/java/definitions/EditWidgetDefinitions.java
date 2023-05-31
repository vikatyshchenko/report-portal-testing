package definitions;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.service.DashboardsService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomString;

@Getter
@Setter
public class EditWidgetDefinitions {

    private DashboardsService dashboardsService = new DashboardsService();
    private static final String RANDOM_WIDGET_NAME = generateRandomString(128);
    private static final String RANDOM_WIDGET_DESC = generateRandomString(1500);

    private WidgetType widgetType;
    private String widgetName;
    private String widgetDescription;

    @Then("Widget is visible")
    public void widgetIsVisible(DataTable dataTable) {
        Map<String, String> widgetInfo = dataTable.asMap(String.class, String.class);
        WidgetType widget = Enum.valueOf(WidgetType.class, widgetInfo.get("type"));
        String widgetName = widgetInfo.get("name");
        setWidgetType(widget);
        setWidgetName(widgetName);
        dashboardsService.assertWidgetVisible(widgetName, widget);
    }

    @When("I press Edit Widget button")
    public void userPressesEditWidgetButton() {
        dashboardsService.pressEditWidgetButton(widgetName);
    }

    @When("I enter new widget name {string}")
    public void entersNewName(String newName) {
        if (newName.startsWith("randomString")) {
            newName = RANDOM_WIDGET_NAME;
        }
        dashboardsService.editWidgetName(newName)
                .saveEdit();
        setWidgetName(newName);
    }

    @Then("Widget name is changed to new name")
    public void widgetNameIsChangedToNewName() {
        dashboardsService.assertWidgetVisible(widgetName, widgetType);
    }

    @When("I change widget name to default name {string}")
    public void canBeChangedToDefaultName(String name) {
        dashboardsService.pressEditWidgetButton(widgetName)
                .editWidgetName(name)
                .saveEdit();
        setWidgetName(name);
    }

    @When("I enter new widget description {string}")
    public void entersNewDescription(String newDesc) {
        if (newDesc.startsWith("randomString")) {
            newDesc = RANDOM_WIDGET_DESC;
        }
        dashboardsService.editWidgetDescription(newDesc)
                .saveEdit();
        setWidgetDescription(newDesc);
    }

    @Then("Widget description is changed to new description")
    public void widgetDescriptionIsChangedToNewDescription() {
        dashboardsService.assertWidgetDescriptionVisible(widgetName, widgetDescription);
    }

    @When("I change widget description to default")
    public void canBeChangedToDefaultDescription() {
        dashboardsService.pressEditWidgetButton(widgetName)
                .editWidgetDescription("")
                .saveEdit();
        setWidgetDescription("");
    }

    @But("Widget description is not visible")
    public void widgetDescriptionIsNotVisible() {
        dashboardsService.assertWidgetDescriptionInVisible(widgetName);
    }

}