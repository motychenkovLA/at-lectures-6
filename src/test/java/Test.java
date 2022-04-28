import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.PageClass1;
import page.PageClass2;

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
        PageClass1 pageClass = new PageClass1(webDriver);
        pageClass.findEndClick();

        if (pageClass.doubleClickText() && pageClass.rightClickText() && pageClass.clickText()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        webDriver.quit();
    }

    public static void test2() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/alerts");
        PageClass2 pageClass = new PageClass2(webDriver);
        pageClass.findEndClick();

        if (pageClass.checkConfirmResult()) {
            System.out.println("Тест пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        webDriver.quit();
    }
}