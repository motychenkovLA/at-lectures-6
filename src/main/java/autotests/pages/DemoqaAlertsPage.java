package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaAlertsPage {

    private WebDriver webDriver;
    private static By alertButtonLocator = By.id("alertButton");
    private static By timerAlertButtonLocator = By.id("timerAlertButton");
    private static By confirmButtonLocator = By.id("confirmButton");

    public DemoqaAlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    WebElement alertButton = webDriver.findElement(alertButtonLocator);
    WebElement timerAlertButton = webDriver.findElement(timerAlertButtonLocator);
    WebElement confirmButton = webDriver.findElement(confirmButtonLocator);



    public static String checkResult(WebDriver webDriver) {
        boolean isHaveCancel = !webDriver.findElements(By.xpath("//span[text()='Cancel']")).isEmpty();

        if (isHaveCancel) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }

    public void clickAndAcceptAlert() {
        alertButton.click();
        webDriver.switchTo()
                .alert()
                .accept();
    }

    public void clickAndWaitAlert() {
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        webDriver.switchTo()
                .alert()
                .accept();
    }

    public void clickAndDismiss() {
        confirmButton.click();
        webDriver.switchTo()
                .alert()
                .dismiss();
    }
}
