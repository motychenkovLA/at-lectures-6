package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageClass2 {
    private WebDriver webDriver;

    private By alertButtonxpath = By.xpath("//button[@id ='alertButton']");
    private By timerAlertButtonxpath = By.xpath("//button[@id ='timerAlertButton']");
    private By confirmButtonxpath = By.xpath("//button[@id ='confirmButton']");

    public PageClass2(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void findEndClick() {
        WebElement alertButton = webDriver.findElement(alertButtonxpath);
        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonxpath);
        WebElement confirmButton = webDriver.findElement(confirmButtonxpath);

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
    }

    public boolean checkConfirmResult() {
        return !webDriver.findElements(By.xpath("//span[@id ='confirmResult']")).isEmpty();
    }


}
