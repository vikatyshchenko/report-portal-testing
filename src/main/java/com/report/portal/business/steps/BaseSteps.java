package com.report.portal.business.steps;

import com.codeborne.selenide.Selenide;
import com.report.portal.business.page.objects.BasePage;
import com.report.portal.business.page.objects.LoginPage;

import static com.report.portal.business.page.objects.BasePage.gotoDashboardsPage;

public class BaseSteps {

    private final BasePage basePage = new BasePage();

    public BaseSteps login() {
        LoginPage loginPage = Selenide.open("http://localhost:8080/ui/#login", LoginPage.class);
        loginPage.setLogin(System.getenv("rp.login"))
                .setPassword(System.getenv("rp.password"))
                .submit();
        return this;
    }

    public BaseSteps isLogoVisible() {
        basePage.assertLogoVisible();
        return this;
    }

    public DashboardsSteps goToDashboards() {
        gotoDashboardsPage();
        return DashboardsSteps.init();
    }

}
