package autotests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DemoQaAlerts;
import pages.DemoQaButtons;

import java.time.Duration;

public class PageObjTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/chromedriver/chromedriver.exe");
        testButtons();
        testAlerts();
    }

    public static void testButtons(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/buttons");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        DemoQaButtons demoQaButtons = new DemoQaButtons(webDriver);
        demoQaButtons.findAndClick();
        demoQaButtons.checkTest();
    }
    public static void testAlerts(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        DemoQaAlerts demoQaAlerts = new DemoQaAlerts(webDriver);
        demoQaAlerts.findAndClick();
        demoQaAlerts.checkTest();
    }




}
