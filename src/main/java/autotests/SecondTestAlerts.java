package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//
//        1. Зайти по адресу https://demoqa.com/alerts
//        2. Кликнуть по первой кнопке и принять алерт.
//        3. Кликнуть по второй кнопке и принять алерт (вспоминайте об явном ожидании)
//        4. Кликнуть по третьей кнопке - отклонить.
//        Проверить появился ли текст:
//        You selected Cancel

public class SecondTestAlerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        WebElement webElement = webDriver.findElement(By.xpath("//button[@Id = 'alertButton']"));
        webElement.click();
        webDriver.switchTo()
                .alert()
                .accept();

        webElement = webDriver.findElement(By.xpath("//button[@Id = 'timerAlertButton']"));
        webElement.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo()
                .alert()
                .accept();

        webElement = webDriver.findElement(By.xpath("//button[@Id = 'confirmButton']"));
        webElement.click();
        webDriver.switchTo()
                .alert()
                .dismiss();


        boolean cancelText = !webDriver.findElements(By.id("confirmResult")).isEmpty();
        if (cancelText){
            System.out.println("Тест пройден успешно!");
        }
    }
}
