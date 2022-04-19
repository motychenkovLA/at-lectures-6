package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumFirstTask {

    public static void main(String[] args) {

        firstTask();
        secondTask();
    }

    public static void firstTask() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClickMe = webDriver.findElement(By.id("doubleClickBtn"));
        WebElement rightClickMe = webDriver.findElement(By.id("rightClickBtn"));
        WebElement clickMe = webDriver.findElement(By.xpath("//button[text()='Click Me']"));

        new Actions(webDriver)
                .doubleClick(doubleClickMe)
                .contextClick(rightClickMe)
                .click(clickMe)
                .build()
                .perform();

        boolean isHaveDoubleClickMeText = webDriver.findElement
                (By.xpath("//p[text()='You have done a double click']")).isDisplayed();
        boolean isHaveRightClickMeText = webDriver.findElement
                (By.xpath("//p[text()='You have done a right click']")).isDisplayed();
        boolean isHaveClickMeText = webDriver.findElement
                (By.id("dynamicClickMessage")).isDisplayed();
        webDriver.quit();
        if (isHaveDoubleClickMeText && isHaveRightClickMeText && isHaveClickMeText) {
            System.out.println("Первый Тест пройден успешно");
        } else {
            System.out.println("Первый Тест не пройден");
        }
    }

    public static void secondTask() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/alerts");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        WebElement alertButton = webDriver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = webDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveText = webDriver.findElement
                (By.xpath("//span[text()='You selected ' and text()='Cancel'] ")).isDisplayed();
        webDriver.quit();
        if(isHaveText) {
            System.out.println("Второй Тест пройден успешно");
        } else {
            System.out.println("Второй Тест не пройден");
        }

    }
}
