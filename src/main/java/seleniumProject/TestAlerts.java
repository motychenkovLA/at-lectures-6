package seleniumProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestAlerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Alerts alerts = new Alerts(driver);
        alerts.clickFirstButton();
        alerts.clickSecondButton();
        alerts.clickThirdButton();
    }
}
