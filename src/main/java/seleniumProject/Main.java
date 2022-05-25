package seleniumProject;

import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Main {
    private WebDriver driver;
    @Rule
    public Timeout durationsOfTests = Timeout.seconds(180);


    @Before
    public void driverInitialization() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closingTheDriver() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void buttonPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Buttons buttons = new Buttons(driver);
        buttons.clickAllButtons();
        buttons.isTestSuccess();
        String expectedDoubleClickMeText = "You have done a double click";
        String expectedRightClickMeText = "You have done a right click";
        String expectedClickMeText = "You have done a dynamic click";

        Assert.assertEquals("Тексты сообщений дабл клик не совпадают",
                expectedDoubleClickMeText, buttons.getDoubleClickMeText());
        Assert.assertEquals("Тексты сообщений правый клик не совпадают",
                expectedRightClickMeText, buttons.getRightClickMeText());
        Assert.assertEquals("Тексты сообщений клик не совпадают",
                expectedClickMeText, buttons.getClickMeText());
    }

    @Test
    public void alertsPageTest() {
        By examination = By.xpath("//span[contains(., 'Cancel')]");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedAlertCancelText = "You selected " + "Cancel";
        Alerts alerts = new Alerts(driver);
        alerts.clickFirstButton();
        alerts.clickSecondButton();
        alerts.clickThirdButton();
        System.out.println(!driver.findElements(examination).isEmpty() ? "Тест пройден успешно" : "Тест не пройден");
        Assert.assertEquals("Тексты сообщений не совпадают",
                expectedAlertCancelText, alerts.getAlertCancelText());


    }
}
