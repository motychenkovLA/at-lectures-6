package autotests.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DemoQaAlerts;
import pages.DemoQaButtons;

import java.time.Duration;

public class PageObjTest {

    private static final By cancelText = By.id("confirmResult");

        public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/chromedriver/chromedriver.exe");
        testButtons();
        testAlerts();
        checkTest();
    }

    public static void testButtons(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/buttons");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        DemoQaButtons demoQaButtons = new DemoQaButtons(webDriver);
        demoQaButtons.findAndClick();
    }
    public static void testAlerts(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        DemoQaAlerts demoQaAlerts = new DemoQaAlerts(webDriver);
        demoQaAlerts.clickAlertButton();
        demoQaAlerts.clickTimerAlertButton();
        demoQaAlerts.dismissAlert();

    }
    public static void checkTest(){
        WebDriver webDriver = new ChromeDriver();
        boolean isHaveCancelText = webDriver.findElement(cancelText).isDisplayed();


        if (isHaveCancelText){
            System.out.println("Тест пройден успешно!");
        }
        else System.out.println("Тест не пройден");
    }



}
