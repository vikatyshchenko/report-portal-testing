package definitions;

import com.report.portal.business.steps.BaseService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberHooks {

    BaseService baseService = new BaseService();

    @Before
    public void login() {
        baseService.openInitialPage()
                .login()
                .isLogoVisible();
    }

    @After
    public void close() {
        closeWebDriver();
    }

}