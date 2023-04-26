package com.report.portal.core.logging;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Log.getLogger().info("!! TEST FAILED: %s", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.getLogger().info("!! TEST SKIPPED: %s", result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.getLogger().info("!! TEST STARTED: %s", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.getLogger().info("!! TEST PASSED: %s", result.getName());
    }

}
