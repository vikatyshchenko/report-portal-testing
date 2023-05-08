package com.report.portal.business.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WidgetType {

    LAUNCH_STAT("Launch statistics chart"),
    LAUNCH_DURATION("Launches duration chart"),
    OVERALL_STAT("Overall statistics"),
    FAILED_CASE_TREND("Failed cases trend chart");

    private final String widgetTitle;

}
