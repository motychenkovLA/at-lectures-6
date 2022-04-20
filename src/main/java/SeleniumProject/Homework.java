package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Homework {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/buttons");
            WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
            WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
            WebElement clickMeBtn = driver.findElement(By.xpath("//button[text() = 'Click Me']"));
            Actions action = new Actions(driver);
            action.doubleClick(doubleClickBtn).contextClick(rightClickBtn).click(clickMeBtn).build().perform();

            System.out.println(!driver.findElements(By.id("doubleClickMessage")).isEmpty()); // Если клик не выполнен, ловим Catch
            System.out.println(!driver.findElements(By.id("rightClickMessage")).isEmpty());
            System.out.println(!driver.findElements(By.id("dynamicClickMessage")).isEmpty());
        } catch (Exception e) {
            System.out.println("Что то пошло не так");
        }

    }
}
