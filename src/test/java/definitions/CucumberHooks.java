package definitions;

import com.report.portal.business.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberHooks {

    BaseSteps baseSteps = new BaseSteps();

    @Before
    public void login() {
        baseSteps.openInitialPage()
                .login()
                .isLogoVisible();
    }

    @After
    public void close() {
        closeWebDriver();
    }

}