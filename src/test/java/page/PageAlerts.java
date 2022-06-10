package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageAlerts {
    private WebDriver webDriver;


    private By alertButtonXpath = By.xpath("//button[@id ='alertButton']");
    private By timerAlertButtonXpath = By.xpath("//button[@id ='timerAlertButton']");
    private By confirmButtonXpath = By.xpath("//button[@id ='confirmButton']");
    private By confirmResultXpath = By.xpath("//span[@id ='confirmResult']");

    public PageAlerts(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Нажать кнопку рядом с тестом: Click Button to see alert")
    public void clickAlertButton() {

        WebElement alertButton = webDriver.findElement(alertButtonXpath);
        alertButton.click();
        webDriver.switchTo().alert().accept();
    }

    @Step("Нажать кнопку рядом с тестом: On button click, alert will appear after 5 seconds")
    public void clickTimerAlertButton() {
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonXpath);
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    @Step("Нажать кнопку рядом с тестом: On button click, confirm box will appear")
    public void clickConfirmButton() {
        WebElement confirmButton = webDriver.findElement(confirmButtonXpath);
        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean isHaveConfirmResult() {
        return !webDriver.findElements(confirmResultXpath).isEmpty();
    }


}
