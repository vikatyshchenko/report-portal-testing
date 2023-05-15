package definitions;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.steps.DashboardsSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

import static com.report.portal.core.utils.data.RandomSequenceCreator.generateRandomString;

@Getter
@Setter
public class EditWidgetDefinitions {

    private DashboardsSteps dashboardsSteps = new DashboardsSteps();
    private static final String RANDOM_WIDGET_NAME = generateRandomString(128);
    private static final String RANDOM_WIDGET_DESC = generateRandomString(1500);

    private WidgetType widgetType;
    private String widgetName;
    private String widgetDescription;

    @Given("Widget is visible")
    public void widgetIsVisible(DataTable dataTable) {
        Map<String, String> widgetInfo = dataTable.asMap(String.class, String.class);
        WidgetType widget = Enum.valueOf(WidgetType.class, widgetInfo.get("type"));
        String widgetName = widgetInfo.get("name");
        dashboardsSteps.assertWidgetVisible(widgetName, widget);
        setWidgetType(widget);
        setWidgetName(widgetName);
    }

    @When("User presses Edit Widget button")
    public void userPressesEditWidgetButton() {
        dashboardsSteps.pressEditWidgetButton(widgetName);
    }

    @And("enters new name {string}")
    public void entersNewName(String newName) {
        if (newName.startsWith("randomString")) {
            newName = RANDOM_WIDGET_NAME;
        }
        dashboardsSteps.editWidgetName(newName)
                .saveEdit();
        setWidgetName(newName);
    }

    @Then("widget name is changed to new name")
    public void widgetNameIsChangedToNewName() {
        dashboardsSteps.assertWidgetVisible(widgetName, widgetType);
    }

    @And("can be changed to default name {string}")
    public void canBeChangedToDefaultName(String name) {
        dashboardsSteps.pressEditWidgetButton(widgetName)
                .editWidgetName(name)
                .saveEdit();
        setWidgetName(name);
    }

    @And("enters new description {string}")
    public void entersNewDescription(String newDesc) {
        if (newDesc.startsWith("randomString")) {
            newDesc = RANDOM_WIDGET_DESC;
        }
        dashboardsSteps.editWidgetDescription(newDesc)
                .saveEdit();
        setWidgetDescription(newDesc);
    }

    @Then("widget description is changed to new description")
    public void widgetDescriptionIsChangedToNewDescription() {
        dashboardsSteps.assertWidgetDescriptionVisible(widgetName, widgetDescription);
    }

    @And("can be changed to default description")
    public void canBeChangedToDefaultDescription() {
        dashboardsSteps.pressEditWidgetButton(widgetName)
                .editWidgetDescription("")
                .saveEdit();
        setWidgetDescription("");
    }

    @But("widget description is not visible")
    public void widgetDescriptionIsNotVisible() {
        dashboardsSteps.assertWidgetDescriptionInVisible(widgetName);
    }

}