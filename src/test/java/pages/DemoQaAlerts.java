package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DemoQaAlerts {
    private static WebDriver webDriver;

    public DemoQaAlerts(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    private static final By alertButton = By.xpath("//button[@Id = 'alertButton']");
    private static final By timerAlertButton = By.xpath("//button[@Id = 'timerAlertButton']");
    private static final By confirmButton = By.xpath("//button[@Id = 'confirmButton']");
    private static final By cancelText = By.id("confirmResult");

    public  void findAndClick(){
        webDriver.findElement(alertButton).click();
        webDriver.switchTo()
                .alert()
                .accept();

        webDriver.findElement(timerAlertButton).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo()
                .alert()
                .accept();

        webDriver.findElement(confirmButton).click();
        webDriver.switchTo()
                .alert()
                .dismiss();
    }

    public  String getCancelText(){
        return webDriver.findElement(cancelText).getText();
    }


}
