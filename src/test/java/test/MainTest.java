package test;

import autotests.pages.DemoqaAlertsPage;
import autotests.pages.DemoqaButtonsPage;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Stopwatch;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MainTest {

    private WebDriver webDriver;

    @Before
    public void startMethod(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
    }

    @After
    public void quitDriver(){
        webDriver.quit();
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(120);

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    @DisplayName("Тест №1. Проверка страницы https://demoqa.com/buttons")
    public void demoqaButtonsTest(){
        webDriver.get("https://demoqa.com/buttons");
        DemoqaButtonsPage demoqaButtonsPage = new DemoqaButtonsPage(webDriver);
        demoqaButtonsPage.doubleClick();
        demoqaButtonsPage.rightClick();
        demoqaButtonsPage.click();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(demoqaButtonsPage.expectedHaveDoubleClickText,
                demoqaButtonsPage.getHaveDoubleClickText(webDriver),"\nНекорректное сообщение после дабл клика");
        softAssert.assertEquals(demoqaButtonsPage.expectedHaveRightClickText,
                demoqaButtonsPage.getHaveRightClickText(webDriver),"\nНекорректное сообщение после райт клика");
        softAssert.assertEquals(demoqaButtonsPage.expectedHaveDynamicClickText,
                demoqaButtonsPage.getHaveDynamicClickText(webDriver),"\nНекорректное сообщение после динамик клика");

        softAssert.assertAll();

        System.out.println(demoqaButtonsPage.checkResult(webDriver));
    }

    @Test
    @DisplayName("Тест №2. Проверка страницы https://demoqa.com/alerts")
    public void demoqaAlertsTest(){
        webDriver.get("https://demoqa.com/alerts");
        DemoqaAlertsPage demoqaAlertsPage = new DemoqaAlertsPage(webDriver);
        demoqaAlertsPage.clickAndAcceptAlert();
        demoqaAlertsPage.clickAndWaitAlert();
        demoqaAlertsPage.clickAndDismiss();
        Assert.assertEquals("Некорректное сообщение отмены аллерта", demoqaAlertsPage.expectedHaveCancelText,
                demoqaAlertsPage.getHaveCancelText(webDriver));
        System.out.println(DemoqaAlertsPage.checkResult(webDriver));
    }
}
