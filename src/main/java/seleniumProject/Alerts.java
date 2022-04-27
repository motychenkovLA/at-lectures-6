package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    private final String site = "https://demoqa.com/alerts";
    private final By alertButtonPath = By.id("alertButton");
    private final By timerAlertButtonPath = By.id("timerAlertButton");
    private final By confirmButtonPath = By.id("confirmButton");
    private final WebDriver driver;

    public Alerts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(site);

    }

    public void clickFirstButton() {
        WebElement alertButton = driver.findElement(alertButtonPath);
        alertButton.click();
        driver.switchTo()
                .alert()
                .accept();
    }

    public void clickSecondButton() {
        WebElement timerAlertButton = driver.findElement(timerAlertButtonPath);
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo()
                .alert()
                .accept();
    }

    public void clickThirdButton() {
        WebElement confirmButton = driver.findElement(confirmButtonPath);
        confirmButton.click();
        driver.switchTo()
                .alert()
                .dismiss();
    }

    public void isTestSuccess(WebDriver driver) {
        System.out.println(!driver.findElements(By.xpath("//span[contains(., 'Cancel')]")).isEmpty() ? "Тест пройден успешно" : "Тест не пройден");
    }
}


