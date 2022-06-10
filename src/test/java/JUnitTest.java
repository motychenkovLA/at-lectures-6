import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.PageButtons;
import page.PageAlerts;

import java.time.Duration;

@DisplayName("JUnitTests")
public class JUnitTest {
    WebDriver webDriver;

    @Before
    public void beforeMethod () {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @DisplayName("Тест с кнопками")
    @Test (timeout = 180000)
    public void test1() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");
        PageButtons pageClass = new PageButtons(webDriver);
        pageClass.clickDoubleButton();
        pageClass.clickRightButton();
        pageClass.clickButton();
        Assert.assertTrue( "Тест не пройден",pageClass.isHaveDoubleClickText()
                && pageClass.isHaveRightClickText() && pageClass.isHaveClickText());
        webDriver.quit();
    }

    @DisplayName("Тест с алертами")
    @Test (timeout = 180000)
    public void test2() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/alerts");
        PageAlerts pageClass = new PageAlerts(webDriver);
        pageClass.clickAlertButton();
        pageClass.clickTimerAlertButton();
        pageClass.clickConfirmButton();
        Assert.assertTrue("Тест не пройден",pageClass.isHaveConfirmResult());
        webDriver.quit();
    }
}