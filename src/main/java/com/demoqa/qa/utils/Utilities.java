package com.demoqa.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoqa.qa.base.BaseClass;

public class Utilities extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 10;
	public static long EXPLICITYLY_WAIT = 15;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions act = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITYLY_WAIT));

	public void visibilityWait(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));

	}

	public void scrollUsingJs(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}

	public void scrollUsingJs() {
		js.executeScript("window.scrollBy(0,-300)");

	}

	public void actionClassMove(WebElement ele) {
		act.moveToElement(ele).perform();
	}

	public void actionClassClick(WebElement ele) {
		act.click(ele).perform();
	}

	public void removeByKeysandEnter(WebElement ele, String str) {
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(Keys.BACK_SPACE);
		ele.sendKeys(str);
	}

	public void selectAndReplaceText(WebElement ele, String str) {
		ele.click();
		ele.sendKeys(Keys.CONTROL + "a");
		ele.sendKeys(str);
		ele.sendKeys(Keys.ENTER);
	}

	public void waitForActivation(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public String getTextFromElement(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	public void takeScreenShot(String fileName) {
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenShot/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getCurrentDateAndTime() {

		
	}

}
