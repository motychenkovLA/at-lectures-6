package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageWithAlerts {

    private static final String url = "https://demoqa.com/alerts";

    private static final By alertButtonId = By.id("alertButton");
    private static final By timerAlertButtonId = By.id("timerAlertButton");
    private static final By confirmButtonId = By.id("confirmButton");

    private static final By textAlertCancelXpath = By.xpath("//span[text()='You selected ' and text()='Cancel'] ");

    public static String getUrl() {
        return url;
    }

    public static By getAlertButtonId() {
        return alertButtonId;
    }

    public static By getTimerAlertButtonId() {
        return timerAlertButtonId;
    }

    public static By getConfirmButtonId() {
        return confirmButtonId;
    }

    public static By getTextAlertCancelXpath() {
        return textAlertCancelXpath;
    }
}
