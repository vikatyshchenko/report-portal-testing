package definitions;

import com.report.portal.business.steps.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {

    private final BaseSteps baseSteps = new BaseSteps();

    @Given("Login page is open")
    public void loginPageIsOpen() {
        baseSteps.openInitialPage();
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        baseSteps.login();
    }

    @Then("User is signed in")
    public void userIsSignedIn() {
        baseSteps.isLogoVisible();
    }

    @And("User can navigate to the Dashboards Page")
    public void userCanNavigateToTheDashboardsPage() {
        baseSteps.goToDashboards();
    }

}