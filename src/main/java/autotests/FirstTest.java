package autotests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
        WebElement webElement = webDriver.findElement(By.xpath("//button[text()='Double Click Me']"));
        Actions actions = new Actions(webDriver);
        actions .doubleClick(webElement);
        webElement = webDriver.findElement(By.xpath("//button[text()='Right Click Me']"));
        actions .contextClick(webElement);
        webElement = webDriver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(webElement)
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();
        System.out.println(isHaveDoubleClickText);
    }
}
