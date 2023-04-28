package com.report.portal.business.steps;

import com.report.portal.business.constants.WidgetType;
import com.report.portal.business.page.objects.AllDashboardsPage;
import com.report.portal.business.page.objects.DashboardPage;
import lombok.Getter;
import lombok.Setter;

import static com.report.portal.business.constants.StepLabel.*;

@Getter
@Setter
public class DashboardsSteps {

    private AllDashboardsPage allDashboardsPage = AllDashboardsPage.init();
    private DashboardPage dashboardPage = DashboardPage.init();
    private String widgetName;

    public static DashboardsSteps init() {
        return new DashboardsSteps();
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

    public DashboardsSteps describeWidget(WidgetType widgetType, int randomValue) {
        widgetName = widgetType.getWidgetTitle().concat("_" + randomValue);
        dashboardPage.isStepLabelActive(SAVE)
                .typeWidgetName(widgetName)
                .typeWidgetDescription("Description: " + widgetName);
        return this;
    }

    public DashboardsSteps createWidget() {
        dashboardPage.pressAddButton();
        return this;
    }

    public DashboardsSteps assertWidgetVisible(WidgetType widgetType) {
        dashboardPage.isWidgetVisible(widgetName, widgetType);
        return this;
    }

    public DashboardsSteps deleteWidget() {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressDeleteWidgetHeaderButton(widgetName)
                .pressDeleteWidgetButton();
        return this;
    }

    public DashboardsSteps editWidgetName(String newWidgetName) {
        dashboardPage.hoverWidgetHeader(widgetName)
                .pressEditWidgetHeaderButton(widgetName)
                .typeWidgetName(newWidgetName)
                .pressSaveButton();
        widgetName = newWidgetName;
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
