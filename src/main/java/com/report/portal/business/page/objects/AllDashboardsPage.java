package com.report.portal.business.page.objects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AllDashboardsPage extends BasePage {

    public DashboardPage goToDashboard(String dashboardName) {
        $(By.linkText(dashboardName)).click();
        return new DashboardPage();
    }

}
