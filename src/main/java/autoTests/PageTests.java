package autoTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageTests {

    public static void main(String[] args) {
        buttonPageTest();
        alertPageTest();
    }

    public static void buttonPageTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        PageWithButtons pageWithButtons = new PageWithButtons(webDriver);
        pageWithButtons.clickPageButtons();
        pageWithButtons.assertTestText
                ("You have done a double click", pageWithButtons.getDoubleClickMeText());
        pageWithButtons.assertTestText
                ("You have done a right click", pageWithButtons.getRightClickMeText());
        pageWithButtons.assertTestText
                ("You have done a dynamic click", pageWithButtons.getClickMeText());
        webDriver.close();

    }

    public static void alertPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");

        PageWithAlerts pageWithAlerts = new PageWithAlerts(webDriver);
        pageWithAlerts.clickPageButtons();
        pageWithAlerts.assertTestText();
        webDriver.close();
    }
}
