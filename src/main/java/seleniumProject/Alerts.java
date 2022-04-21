package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alerts {
    private static final String site = "https://demoqa.com/alerts";
    private static final By alertButtonPath = By.id("alertButton");
    private static final By timerAlertButtonPath = By.id("timerAlertButton");
    private static final By confirmButtonPath = By.id("confirmButton");


    public static String getSite() {
        return site;
    }

    public static By getAlertButtonPath() {
        return alertButtonPath;
    }

    public static By getTimerAlertButtonPath() {
        return timerAlertButtonPath;
    }

    public static By getConfirmButtonPath() {
        return confirmButtonPath;
    }

    public static boolean isTestSuccess(WebDriver driver) {
        return !driver.findElements(By.xpath("//span[contains(., 'Cancel')]")).isEmpty();
    }
}


