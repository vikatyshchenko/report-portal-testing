package com.report.portal.business.steps;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.page.objects.AllDashboardsPage;
import com.report.portal.business.page.objects.DashboardPage;

import static com.report.portal.business.constants.StepLabel.*;

public class DashboardsService {

    private final AllDashboardsPage allDashboardsPage = new AllDashboardsPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    public DashboardsService selectDashboard(String dashboardName) {
        allDashboardsPage.goToDashboard(dashboardName);
        return this;
    }

    public DashboardsService assertDashboardVisible(String dashboardName) {
        dashboardPage.isDashboardVisible(dashboardName);
        return this;
    }

    public DashboardsService addNewWidget() {
        dashboardPage.addNewWidget();
        return this;
    }

    public DashboardsService chooseWidgetType(WidgetType widgetType) {
        dashboardPage.isStepLabelActive(SELECT)
                .selectWidgetType(widgetType)
                .pressNextButton();
        return this;
    }

    public DashboardsService configureWidget(String filterName, WidgetType widgetType) {
        dashboardPage.isStepLabelActive(CONFIGURE)
                .selectFilter(filterName)
                .isPreviewVisible(widgetType)
                .pressNextButton();
        return this;
    }

    public DashboardsService typeWidgetName(String widgetName) {
        dashboardPage.isStepLabelActive(SAVE)
                .typeWidgetName(widgetName);
        return this;
    }

    public DashboardsService createWidget() {
        dashboardPage.pressAddButton();
        return this;
    }

    public DashboardsService assertWidgetVisible(String widgetName, WidgetType widgetType) {
        dashboardPage.isWidgetVisible(widgetName, widgetType);
        return this;
    }

    public DashboardsService deleteWidget(String widgetName) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressDeleteWidgetHeaderButton(widgetName)
                .pressDeleteWidgetButton();
        return this;
    }

    public DashboardsService pressEditWidgetButton(String widgetName) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressEditWidgetHeaderButton(widgetName);
        return this;
    }

    public DashboardsService editWidgetName(String widgetName) {
        dashboardPage.typeWidgetName(widgetName);
        return this;
    }

    public DashboardsService editWidgetDescription(String widgetDescription) {
        dashboardPage.typeWidgetDescription(widgetDescription);
        return this;
    }

    public DashboardsService saveEdit() {
        dashboardPage.pressSaveButton();
        return this;
    }

    public DashboardsService assertWidgetDescriptionVisible(String widgetName, String widgetDescription) {
        dashboardPage.hoverWidgetDescription(widgetName)
                .isWidgetDescriptionVisible(widgetName, widgetDescription);
        return this;
    }

    public DashboardsService assertWidgetDescriptionInVisible(String widgetName) {
        dashboardPage.isWidgetDescriptionInVisible(widgetName);
        return this;
    }

}