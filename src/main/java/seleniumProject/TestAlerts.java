package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAlerts {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Alerts.getSite());

        WebElement alertButton = driver.findElement(Alerts.getAlertButtonPath());
        WebElement timerAlertButton = driver.findElement(Alerts.getTimerAlertButtonPath());
        WebElement confirmButton = driver.findElement(Alerts.getConfirmButtonPath());

        alertButton.click();

        driver.switchTo()
                .alert()
                .accept();

        timerAlertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo()
                .alert()
                .accept();

        confirmButton.click();
        driver.switchTo()
                .alert()
                .dismiss();


        System.out.println(Alerts.isTestSuccess(driver) ? "Тест пройден успешно" : "Тест не пройден");


    }
}
