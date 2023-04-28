package com.report.portal.business.page.objects;

import com.codeborne.selenide.Condition;
import com.report.portal.business.constants.StepLabel;
import com.report.portal.business.constants.WidgetType;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class DashboardPage extends BasePage {

    private final static String widgetHeaderXpath = "//div[@class='widgetHeader__widget-name--FjJLi']//div[text()='%s']";
    private final String widgetTypeHeaderXpath = widgetHeaderXpath.concat("/parent::div/following-sibling::div/span[text()='%s']");
    private final static String widgetControlXpath = "//div[text()='%s']/ancestor::div[@class='widgetHeader__info-block--1n0yX']" +
            "/following-sibling::div[@class='widget__common-control--2ajOp']/div/div[%d]";

    private final String widgetDescriptionTooltipXpath = widgetHeaderXpath.concat("/parent::div//div[@class='descriptionTooltipIcon__description-tooltip-icon--2N2NQ']");

    public static DashboardPage init() {
        return new DashboardPage();
    }

    public DashboardPage addNewWidget() {
        $(By.xpath("//span[text() = 'Add new widget']")).click();
        return this;
    }

    public DashboardPage selectWidgetType(WidgetType widgetType) {
        $(By.xpath(format("//div[text() = '%s']", widgetType.getWidgetTitle()))).click();
        return this;
    }

    public DashboardPage isStepLabelActive(StepLabel stepLabel) {
        String labelXpath = format("//div[text() = '%s']/parent::div", stepLabel.getStepTitle());
        $(By.xpath(labelXpath)).shouldBe(Condition.cssClass("stepLabelItem__active--23Ln_"));
        return this;
    }

    public DashboardPage selectFilter(String filterName) {
        $(By.xpath(format("//span[text() = '%s']/ancestor::label", filterName))).shouldBe(visible).click();
        return this;
    }

    public DashboardPage pressNextButton() {
        $(By.xpath("//span[text() = 'Next step']/ancestor::button")).scrollIntoView(true).click();
        return this;
    }

    public DashboardPage typeWidgetName(String widgetName) {
        $(By.xpath("//input[@placeholder = 'Enter widget name']")).setValue(widgetName);
        return this;
    }

    public DashboardPage typeWidgetDescription(String widgetDescription) {
        $(By.xpath("//textarea[@placeholder = 'Enter widget description']")).setValue(widgetDescription);
        return this;
    }

    public DashboardPage pressAddButton() {
        $(By.xpath("//button[text() = 'Add']")).scrollIntoView(true).click();
        return this;
    }

    public DashboardPage isPreviewVisible(WidgetType widgetType) {
        String xpath = format("//div[text() = '%s']", widgetType.getWidgetTitle());
        $(By.xpath(xpath)).shouldBe(visible);
        return this;
    }

    public DashboardPage isWidgetVisible(String widgetName, WidgetType widgetType) {
        String xpath = format(widgetTypeHeaderXpath, widgetName, widgetType.getWidgetTitle());
        $(By.xpath(xpath)).shouldBe(visible);
        return this;
    }

    public DashboardPage hoverWidgetHeader(String widgetName) {
        String xpath = format(widgetHeaderXpath, widgetName);
        $(By.xpath(xpath)).scrollIntoView(true).hover();
        return this;
    }

    public DashboardPage hoverWidgetDescription(String widgetName) {
        String xpath = format(widgetDescriptionTooltipXpath, widgetName);
        $(By.xpath(xpath)).scrollIntoView(true).hover();
        return this;
    }

    public DashboardPage isWidgetDescriptionVisible(String widgetName, String widgetDescription) {
        String xpath = format(widgetDescriptionTooltipXpath, widgetName);
        $(By.xpath(xpath)).shouldHave(attribute("content", widgetDescription));
        return this;
    }

    public DashboardPage isWidgetDescriptionInVisible(String widgetName) {
        String xpath = format(widgetDescriptionTooltipXpath, widgetName);
        $(By.xpath(xpath)).shouldBe(hidden);
        return this;
    }

    public DashboardPage pressEditWidgetHeaderButton(String widgetName) {
        String xpath = format(widgetControlXpath, widgetName, 1);
        $(By.xpath(xpath)).click();
        return this;
    }

    public DashboardPage pressDeleteWidgetHeaderButton(String widgetName) {
        String xpath = format(widgetControlXpath, widgetName, 3);
        $(By.xpath(xpath)).click();
        return this;
    }

    public DashboardPage pressDeleteWidgetButton() {
        $(By.xpath("//button[text() = 'Delete']")).click();
        return this;
    }

    public DashboardPage pressSaveButton() {
        $(By.xpath("//button[text() = 'Save']")).click();
        return this;
    }

}
