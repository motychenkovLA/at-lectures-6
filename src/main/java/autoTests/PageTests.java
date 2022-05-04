package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageTests {
    private static final By textAlertCancelXpath = By.xpath("//span[text()='You selected ' and text()='Cancel'] ");

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
        assertTestTextButtons
                ("You have done a double click", pageWithButtons.getDoubleClickMeText());
        assertTestTextButtons
                ("You have done a right click", pageWithButtons.getRightClickMeText());
        assertTestTextButtons
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
        assertTestTextAlerts(webDriver);
        webDriver.close();
    }

    public static void assertTestTextAlerts(WebDriver webDriver) {
        if (webDriver.findElement(textAlertCancelXpath).isDisplayed()) {
            System.out.println("Тест успешный");
        } else {
            System.out.println("Тест не выполнен");
        }
    }

    public static void assertTestTextButtons(String expectedText, String actualText) {
        if (expectedText.equals(actualText)) {
            System.out.println("Тест выполнен успешно");
        } else {
            System.out.println("Тест не выполнен");
        }
    }


}
