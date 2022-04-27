package test;

import autotests.pages.DemoqaAlertsPage;
import autotests.pages.DemoqaButtonsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MainTest {

    private WebDriver webDriver;

    @Before
    public void startMethod(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
    }

    @After
    public void quitDriver(){
        webDriver.quit();
    }

    @Test
    public void demoqaButtonsTest(){
        webDriver.get("https://demoqa.com/buttons");
        DemoqaButtonsPage demoqaButtonsPage = new DemoqaButtonsPage(webDriver);
        demoqaButtonsPage.doubleClick();
        demoqaButtonsPage.rightClick();
        demoqaButtonsPage.click();
        System.out.println(demoqaButtonsPage.checkResult(webDriver));
    }

    @Test
    public void demoqaAlertsTest(){
        webDriver.get("https://demoqa.com/alerts");
        DemoqaAlertsPage demoqaAlertsPage = new DemoqaAlertsPage(webDriver);
        demoqaAlertsPage.clickAndAcceptAlert();
        demoqaAlertsPage.clickAndWaitAlert();
        demoqaAlertsPage.clickAndDismiss();
        System.out.println(DemoqaAlertsPage.checkResult(webDriver));
    }
}
