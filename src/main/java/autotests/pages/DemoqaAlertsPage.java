package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaAlertsPage {

    public static String checkResult(WebDriver webDriver) {
        boolean isHaveCancel = !webDriver.findElements(By.xpath("//span[text()='Cancel']")).isEmpty();

        if (isHaveCancel) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }
}
