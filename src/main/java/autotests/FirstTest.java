package autotests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

//1. Зайти по адресу https://demoqa.com/buttons
//        2. Кликнуть по Double Click me - двойным нажатием.
//        3. Кликнуть по Right Click Me - правой кнопкой.
//        4. Кликнут по Click Me - левой кнопкой.
//        Проверить появился ли текст:
//        You have done a double click
//
//        You have done a right click
//
//        You have done a dynamic click
//
//        Как можно проверить?
//        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();

public class FirstTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/buttons");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        WebElement webElementDCM = webDriver.findElement(By.xpath("//button[text()='Double Click Me']"));
        WebElement webElementRCM  = webDriver.findElement(By.xpath("//button[text()='Right Click Me']"));
        WebElement webElementCM  = webDriver.findElement(By.xpath("//button[text()='Click Me']"));


        Actions actions = new Actions(webDriver);
        actions .doubleClick(webElementDCM);
        actions .contextClick(webElementRCM);
        actions.click(webElementCM)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.id("rightClickMessage")).isEmpty();
        boolean isHaveClickText = !webDriver.findElements(By.id("dynamicClickMessage")).isEmpty();

        if (isHaveDoubleClickText&&isHaveRightClickText&&isHaveClickText){
            System.out.println("Тест пройден успешно!");
        }
    }
}
