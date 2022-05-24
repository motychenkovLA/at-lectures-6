package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaAlertsPage {

    private WebDriver webDriver;
    private static By alertButtonLocator = By.id("alertButton");
    private static By timerAlertButtonLocator = By.id("timerAlertButton");
    private static By confirmButtonLocator = By.id("confirmButton");
    private static By isHaveCancelLocator = By.xpath("//span[text()='Cancel']");

    public DemoqaAlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String checkResult(WebDriver webDriver) {
        boolean isHaveCancel = !webDriver.findElements(isHaveCancelLocator).isEmpty();

        if (isHaveCancel) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }

    public String getHaveCancelText(WebDriver webDriver) {
        return webDriver.findElement(isHaveCancelLocator).getText();
    }

    public void clickAndAcceptAlert() {
        webDriver.findElement(alertButtonLocator).click();
        webDriver.switchTo()
                .alert()
                .accept();
    }

    public void clickAndWaitAlert() {
        webDriver.findElement(timerAlertButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        webDriver.switchTo()
                .alert()
                .accept();
    }

    public void clickAndDismiss() {
        webDriver.findElement(confirmButtonLocator).click();
        webDriver.switchTo()
                .alert()
                .dismiss();
    }
}
