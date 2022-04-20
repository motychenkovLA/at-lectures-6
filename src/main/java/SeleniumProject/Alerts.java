package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        //хром находится по другому пути
        //вот как нужно было тогда объявить System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        //Исправь
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        //Вот тут установил неявное ожидание (в 1 задании нет)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));

        /*
        Actions подходит для цепочки действий и сложных действий. Клик не сложной действие

        Вот пример как нужно.
        alertButton.click();

        UPD. Твой код работать будет - но обычный клик так не нужно делать.
        Исправь все последующие тоже.
         */
        Actions action = new Actions(driver);
        action.click(alertButton).build().perform();

        //Ремарка. так и дебажить удобнее и структурировано выглядит код.
        driver.switchTo()
                .alert()
                .accept();

        action.click(timerAlertButton).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        //Ремарка. так и дебажить удобнее и структурировано выглядит код.
        driver.switchTo()
                .alert()
                .accept();

        action.click(confirmButton).build().perform();
        driver.switchTo()
                .alert()
                .dismiss();

        //Тут тоже проверка не правильная. Посмотри как реализована у меня.
        //Нам нужно посмотреть какой появился текст после отмены алерта.
        System.out.println(!driver.findElements(By.id("confirmResult")).isEmpty());
    }
}
