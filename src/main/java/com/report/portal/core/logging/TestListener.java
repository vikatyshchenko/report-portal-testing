package com.report.portal.core.logging;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Log.getLogger().info("!! TEST FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.getLogger().info("!! TEST SKIPPED: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.getLogger().info("!! TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.getLogger().info("!! TEST PASSED: " + result.getName());
    }

}
