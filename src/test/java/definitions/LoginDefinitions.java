package definitions;

import com.report.portal.business.service.BaseService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinitions {

    private final BaseService baseService = new BaseService();

    @Given("Login page is open")
    public void loginPageIsOpen() {
        baseService.openInitialPage();
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        baseService.login();
    }

    @Then("User is signed in")
    public void userIsSignedIn() {
        baseService.isLogoVisible();
    }

    @Given("I navigate to the Dashboards Page")
    public void userCanNavigateToTheDashboardsPage() {
        baseService.goToDashboards();
    }

}