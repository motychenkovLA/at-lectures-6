package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));

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

        boolean isHaveText = !driver.findElements(By.xpath("//span[contains(., 'Cancel')]")).isEmpty();

        if (isHaveText) {
            System.out.println("Тест пройден успешно");
        } else {
            System.out.println("Тест не пройден");
        }
    }
}