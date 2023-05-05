package com.report.portal.business.steps;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.page.objects.AllDashboardsPage;
import com.report.portal.business.page.objects.DashboardPage;

import static com.report.portal.business.constants.StepLabel.*;

public class DashboardsSteps {

    private final AllDashboardsPage allDashboardsPage = new AllDashboardsPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    public static DashboardsSteps init() {
        return new DashboardsSteps();
    }

    public static String createWidgetName(WidgetType widgetType, int randomValue) {
        return widgetType.getWidgetTitle().concat("_" + randomValue);

    }

    public DashboardsSteps selectDashboard(String dashboardName) {
        allDashboardsPage.goToDashboard(dashboardName);
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

    public DashboardsSteps describeWidget(String widgetName) {
        dashboardPage.isStepLabelActive(SAVE)
                .typeWidgetName(widgetName)
                .typeWidgetDescription("Description: " + widgetName);
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

    public DashboardsSteps editWidgetName(String oldWidgetName, String newWidgetName) {
        dashboardPage.hoverWidgetHeader(oldWidgetName)
                .pressEditWidgetHeaderButton(oldWidgetName)
                .typeWidgetName(newWidgetName)
                .pressSaveButton();
        return this;
    }

    public DashboardsSteps editWidgetDescription(String widgetName, String widgetDescription) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressEditWidgetHeaderButton(widgetName)
                .typeWidgetDescription(widgetDescription)
                .pressSaveButton();
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
