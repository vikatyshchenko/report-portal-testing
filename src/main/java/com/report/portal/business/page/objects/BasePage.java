package com.report.portal.business.page.objects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public BasePage assertLogoVisible() {
        $(By.className("layout__corner-area--DwLCT")).shouldBe(Condition.visible);
        return this;
    }

    public static AllDashboardsPage gotoDashboardsPage() {
        $(By.xpath("//a[contains(@href, 'dashboard')]")).click();
        return new AllDashboardsPage();
    }

}
