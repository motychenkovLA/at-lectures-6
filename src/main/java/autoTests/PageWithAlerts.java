package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageWithAlerts {

    WebDriver webDriver;

    public PageWithAlerts(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By alertButtonId = By.id("alertButton");
    private static final By timerAlertButtonId = By.id("timerAlertButton");
    private static final By confirmButtonId = By.id("confirmButton");



    public PageWithAlerts clickPageButtons() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        WebElement alertButton = webDriver.findElement(alertButtonId);
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonId);
        WebElement confirmButton = webDriver.findElement(confirmButtonId);

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
        return new PageWithAlerts(webDriver);
    }


}
