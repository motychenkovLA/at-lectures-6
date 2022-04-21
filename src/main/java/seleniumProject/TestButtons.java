package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestButtons {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Buttons.getSite());

        WebElement doubleClickBtn = driver.findElement(Buttons.getDoubleClickBtnPath());
        WebElement rightClickBtn = driver.findElement(Buttons.getRightClickBtnPath());
        WebElement clickMeBtn = driver.findElement(Buttons.getClickMeBtnPath());

        Actions action = new Actions(driver);

        action.doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMeBtn)
                .build()
                .perform();

        System.out.println(Buttons.isTestSuccess(driver) ? "Тест пройден успешно" : "Тест не пройден");


    }
}
