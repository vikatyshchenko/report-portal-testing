package com.report.portal.business.steps;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.page.objects.AllDashboardsPage;
import com.report.portal.business.page.objects.DashboardPage;

import static com.report.portal.business.constants.StepLabel.*;

public class DashboardsSteps {

    private final AllDashboardsPage allDashboardsPage = new AllDashboardsPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    public DashboardsSteps selectDashboard(String dashboardName) {
        allDashboardsPage.goToDashboard(dashboardName);
        return this;
    }

    public DashboardsSteps assertDashboardVisible(String dashboardName) {
        dashboardPage.isDashboardVisible(dashboardName);
        return this;
    }

    public DashboardsSteps addNewWidget() {
        dashboardPage.addNewWidget();
        return this;
    }

    public DashboardsSteps chooseWidgetType(WidgetType widgetType) {
        dashboardPage.isStepLabelActive(SELECT)
                .selectWidgetType(widgetType)
                .pressNextButton();
        return this;
    }

    public DashboardsSteps configureWidget(String filterName, WidgetType widgetType) {
        dashboardPage.isStepLabelActive(CONFIGURE)
                .selectFilter(filterName)
                .isPreviewVisible(widgetType)
                .pressNextButton();
        return this;
    }

    public DashboardsSteps typeWidgetName(String widgetName) {
        dashboardPage.isStepLabelActive(SAVE)
                .typeWidgetName(widgetName);
        return this;
    }

    public DashboardsSteps createWidget() {
        dashboardPage.pressAddButton();
        return this;
    }

    public DashboardsSteps assertWidgetVisible(String widgetName, WidgetType widgetType) {
        dashboardPage.isWidgetVisible(widgetName, widgetType);
        return this;
    }

    public DashboardsSteps deleteWidget(String widgetName) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressDeleteWidgetHeaderButton(widgetName)
                .pressDeleteWidgetButton();
        return this;
    }

    public DashboardsSteps pressEditWidgetButton(String widgetName) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressEditWidgetHeaderButton(widgetName);
        return this;
    }

    public DashboardsSteps editWidgetName(String widgetName) {
        dashboardPage.typeWidgetName(widgetName);
        return this;
    }

    public DashboardsSteps editWidgetDescription(String widgetDescription) {
        dashboardPage.typeWidgetDescription(widgetDescription);
        return this;
    }

    public DashboardsSteps saveEdit() {
        dashboardPage.pressSaveButton();
        return this;
    }

    public DashboardsSteps assertWidgetDescriptionVisible(String widgetName, String widgetDescription) {
        dashboardPage.hoverWidgetDescription(widgetName)
                .isWidgetDescriptionVisible(widgetName, widgetDescription);
        return this;
    }

    public DashboardsSteps assertWidgetDescriptionInVisible(String widgetName) {
        dashboardPage.isWidgetDescriptionInVisible(widgetName);
        return this;
    }

}