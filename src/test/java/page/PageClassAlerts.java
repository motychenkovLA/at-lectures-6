package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageClassAlerts {
    private WebDriver webDriver;


    private By alertButtonxpath = By.xpath("//button[@id ='alertButton']");
    private By timerAlertButtonxpath = By.xpath("//button[@id ='timerAlertButton']");
    private By confirmButtonxpath = By.xpath("//button[@id ='confirmButton']");

    public PageClassAlerts(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickAlertButton() {
        WebElement alertButton = webDriver.findElement(alertButtonxpath);
        alertButton.click();
        webDriver.switchTo().alert().accept();
    }

    public void clickTimerAlertButton() {
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonxpath);
        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void clickConfirmButton() {
        WebElement confirmButton = webDriver.findElement(confirmButtonxpath);
        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean isHaveConfirmResult() {
        return !webDriver.findElements(By.xpath("//span[@id ='confirmResult']")).isEmpty();
    }


}
