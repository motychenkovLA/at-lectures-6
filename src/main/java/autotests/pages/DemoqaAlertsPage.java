package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaAlertsPage {

    private static By alertButtonLocator = By.id("alertButton");
    private static By timerAlertButtonLocator = By.id("timerAlertButton");
    private static By confirmButtonLocator = By.id("confirmButton");

    public static By getAlertButtonLocator() {
        return alertButtonLocator;
    }

    public static By getTimerAlertButtonLocator() {
        return timerAlertButtonLocator;
    }

    public static By getConfirmButtonLocator() {
        return confirmButtonLocator;
    }

    public static String checkResult(WebDriver webDriver) {
        boolean isHaveCancel = !webDriver.findElements(By.xpath("//span[text()='Cancel']")).isEmpty();

        if (isHaveCancel) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }
}
