import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.pageClassButtons;
import page.PageClassAlerts;

import java.time.Duration;

public class Test {
    private static WebDriver webDriver;

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");
        pageClassButtons pageClass = new pageClassButtons(webDriver);
        pageClass.clickDoubleButton();
        pageClass.clickRightButton();
        pageClass.clickButton();

        if (pageClass.isHaveDoubleClickText() && pageClass.isHaveRightClickText() && pageClass.isHaveClickText()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        webDriver.quit();
    }

    public static void test2() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/alerts");
        PageClassAlerts pageClass = new PageClassAlerts(webDriver);
        pageClass.clickAlertButton();
        pageClass.clickTimerAlertButton();
        pageClass.clickConfirmButton();

        if (pageClass.isHaveConfirmResult()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        webDriver.quit();
    }
}