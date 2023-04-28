package com.report.portal.business.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StepLabel {

    SELECT("Select widget type"),
    CONFIGURE("Configure widget"),
    SAVE("Save");

    private final String stepTitle;

}
