package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtils.takeScreenshot(driver, result.getName());
    }
}
