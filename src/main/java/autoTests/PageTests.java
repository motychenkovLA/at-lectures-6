package autoTests;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PageTests {

    private WebDriver webDriver;

    @Rule
    public Timeout durationsOfTests = Timeout.seconds(180);

    @Before
    public void driverInitialization() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void closingTheDriver() {
        if (webDriver != null)
            webDriver.quit();
    }

    @Test
    public void buttonPageTest() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        String expectedDoubleClickMeText = "You have done a double click";
        String expectedRightClickMeText = "You have done a right click";
        String expectedClickMeText = "You have done a dynamic click";

        PageWithButtons pageWithButtons = new PageWithButtons(webDriver);
        pageWithButtons.clickPageButtons();

        Assert.assertEquals("Тексты сообщений дабл клик не совпадают",
                expectedDoubleClickMeText, pageWithButtons.getDoubleClickMeText());
        Assert.assertEquals("Тексты сообщений правый клик не совпадают",
                expectedRightClickMeText, pageWithButtons.getRightClickMeText());
        Assert.assertEquals("Тексты сообщений клик не совпадают",
                expectedClickMeText, pageWithButtons.getClickMeText());
    }

    @Test
    public void alertPageTest() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");

        String expectedAlertCancelText = "You selected " + "Cancel";

        PageWithAlerts pageWithAlerts = new PageWithAlerts(webDriver);
        pageWithAlerts.clickPageButtons();

        Assert.assertEquals("Тексты сообщений отмены алерта не совпадают",
                expectedAlertCancelText, pageWithAlerts.getAlertCancelText());
    }
}
