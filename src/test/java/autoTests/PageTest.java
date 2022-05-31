package autoTests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Тесты на Junit")
public class PageTest {

    private WebDriver webDriver;

    @Rule
    public Timeout durationsOfTests = Timeout.seconds(180);

    @Step("Инициализация драйвера")
    @Before
    public void driverInitialization() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Step("Закрытие драйвера")
    @After
    public void closingTheDriver() {
        if (webDriver != null)
            webDriver.quit();
    }

    @DisplayName("Тест страницы с кнопками")
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

    @DisplayName("Тест страницы с алертами")
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
