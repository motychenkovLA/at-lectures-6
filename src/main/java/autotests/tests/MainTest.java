package autotests.tests;

import autotests.pages.DemoqaAlertsPage;
import autotests.pages.DemoqaBrowserWindowsPage;
import autotests.pages.DemoqaButtonsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MainTest {

    private WebDriver webDriver;

    @Before
    public void startMethod(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
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

        WebElement doubleClickMe = webDriver.findElement(DemoqaButtonsPage.getDoubleClickMeLocator());
        WebElement rightClickMe = webDriver.findElement(DemoqaButtonsPage.getRightClickMeLocator());
        WebElement clickMe = webDriver.findElement(DemoqaButtonsPage.getClickMeLocator());

        Actions actions = new Actions(webDriver);
        actions.doubleClick(doubleClickMe)
                .contextClick(rightClickMe)
                .click(clickMe)
                .build()
                .perform();

        System.out.println(DemoqaButtonsPage.checkResult(webDriver));
    }

    @Test
    public void demoqaAlertsTest(){
        webDriver.get("https://demoqa.com/alerts");

        WebElement alertButton = webDriver.findElement(DemoqaAlertsPage.getAlertButtonLocator());
        WebElement timerAlertButton = webDriver.findElement(DemoqaAlertsPage.getTimerAlertButtonLocator());
        WebElement confirmButton = webDriver.findElement(DemoqaAlertsPage.getConfirmButtonLocator());

        alertButton.click();
        webDriver.switchTo()
                .alert()
                .accept();

        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        webDriver.switchTo()
                .alert()
                .accept();

        confirmButton.click();
        webDriver.switchTo()
                .alert()
                .dismiss();

        System.out.println(DemoqaAlertsPage.checkResult(webDriver));
    }

    @Test
    public void demoqaBrowserWindowsTest(){
        webDriver.get("https://demoqa.com/browser-windows");

        String demoqaWindowDesc = webDriver.getWindowHandle();

        WebElement tabButton = webDriver.findElement(DemoqaBrowserWindowsPage.getTabButtonLocator());
        tabButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        webDriver.switchTo()
                .window(demoqaWindowDesc);

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoqaWindowDesc);
        Iterator<String> iterator = handles.iterator();
        String secondWindow = iterator.next();

        webDriver.switchTo()
                .window(secondWindow);

        webDriver.get("https://google.com");

        webDriver.switchTo()
                .window(demoqaWindowDesc);
    }
}
