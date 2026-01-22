package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

	public static void takeScreenshot(WebDriver driver, String testName) {

	    if (driver == null) {
	        System.out.println("Driver is null. Screenshot skipped for: " + testName);
	        return;
	    }

	    if (!(driver instanceof TakesScreenshot)) {
	        System.out.println("Driver does not support screenshots. Skipped: " + testName);
	        return;
	    }

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);

	    String timestamp = LocalDateTime.now()
	            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	    File destination = new File(
	            "screenshots/" + testName + "_" + timestamp + ".png"
	    );

	    destination.getParentFile().mkdirs();

	    try {
	        Files.copy(source.toPath(), destination.toPath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
