package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //taskOne();
        //taskTwo();
        taskThree();
    }

    public static void taskOne(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        webDriver.get("https://demoqa.com/buttons");

        WebElement doubleClickMe = webDriver.findElement(By.xpath("//button[text()=\"Double Click Me\"]"));
        WebElement rightClickMe = webDriver.findElement(By.xpath("//button[text()=\"Right Click Me\"]"));
        WebElement clickMe = webDriver.findElement(By.xpath("//button[text()=\"Click Me\"]"));

        Actions actions = new Actions(webDriver);
        actions.doubleClick(doubleClickMe)
                .contextClick(rightClickMe)
                .click(clickMe)
                .build()
                .perform();

        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.id("rightClickMessage")).isEmpty();
        boolean isHaveDynamicClickText = !webDriver.findElements(By.id("dynamicClickMessage")).isEmpty();
        webDriver.quit();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveDynamicClickText) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }
    }

    public static void taskTwo(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        webDriver.get("https://demoqa.com/alerts");


        WebElement alertButton = webDriver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = webDriver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));

        //Первая кнопка
        alertButton.click();
        webDriver.switchTo()
                .alert()
                .accept();

        //Вторая кнопка
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        webDriver.switchTo()
                .alert()
                .accept();

        //Третья кнопка
        confirmButton.click();
        webDriver.switchTo()
                .alert()
                .dismiss();

        boolean isHaveCancel = !webDriver.findElements(By.xpath("//span[text()='Cancel']")).isEmpty();

        if (isHaveCancel) {
            System.out.println("Тест пройден!");
        } else {
            System.out.println("Тест не пройден!");
        }
        webDriver.quit();
    }

    public static void taskThree(){
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
        webDriver.get("https://demoqa.com/browser-windows");

        String demoqaWindowDesc = webDriver.getWindowHandle();

        WebElement tabButton = webDriver.findElement(By.id("tabButton"));
        tabButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        webDriver.switchTo()
                .window(demoqaWindowDesc);

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(demoqaWindowDesc);
        Iterator<String> iterator = handles.iterator();
        String secondWindow = iterator.next();

        webDriver.switchTo()
                .window(secondWindow);

        webDriver.get("https://google.com");

        webDriver.switchTo()
                .window(demoqaWindowDesc);
        webDriver.quit();
    }
}
