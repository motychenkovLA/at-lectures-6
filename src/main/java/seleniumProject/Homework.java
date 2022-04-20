package seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Homework {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://demoqa.com/buttons");

            WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
            WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
            WebElement clickMeBtn = driver.findElement(By.xpath("//button[text() = 'Click Me']"));

            Actions action = new Actions(driver);

            action.doubleClick(doubleClickBtn)
                    .contextClick(rightClickBtn)
                    .click(clickMeBtn)
                    .build()
                    .perform();

            boolean isDouble = !driver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
            boolean isRight = !driver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
            boolean isClickMe = !driver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();

            if (isDouble && isRight && isClickMe) {
                System.out.println("Тест пройден успешно");
            } else {
                System.out.println("Тест не пройден");
            }
        } catch (Exception e) {
            System.out.println("Что то пошло не так");
        }

    }
}
