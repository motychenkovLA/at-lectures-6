package autotests.JUnit;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DemoQaAlerts;
import pages.DemoQaButtons;
import java.time.Duration;


public class JUnitTest {
    WebDriver webDriver;
    final String cancelText = "You selected Cancel";

    @Rule
    public Timeout timeout = Timeout.seconds(180);

    @Before
    public void chromeDriverInit(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void chromeDriverClose(){
        webDriver.close();
    }

    @Test
    public void testButtons(){
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.get("https://demoqa.com/buttons");

        DemoQaButtons demoQaButtons = new DemoQaButtons(webDriver);
        demoQaButtons.findAndClick();

        final String doubleClickText = "You have done a double click";
        final String rightClickText = "You have done a right click";
        final String dynamicClickText  = "You have done a dynamic click";


        Assert.assertEquals("Текст двойного клика отсутствует", doubleClickText, demoQaButtons.getDoubleClickMessageText());
        Assert.assertEquals("Текст правого клика отсутствует", rightClickText, demoQaButtons.getRightClickMessageText());
        Assert.assertEquals("Текст клика отсутствует", dynamicClickText, demoQaButtons.getClickMessageText());
    }

    @Test
    public void testAlerts(){
        webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        DemoQaAlerts demoQaAlerts = new DemoQaAlerts(webDriver);
        demoQaAlerts.clickAlertButton();
        demoQaAlerts.clickTimerAlertButton();
        demoQaAlerts.dismissAlert();

        Assert.assertEquals("Текст кнопки отмена отсутствует", cancelText, demoQaAlerts.getCancelText());
    }

}
