package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageTests {

    public static void main(String[] args) {

        buttonPageTest();
//        alertPageTest();

    }

    public static void buttonPageTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get("https://demoqa.com/buttons");

        PageWithButtons pageWithButtons = new PageWithButtons(webDriver);
        pageWithButtons.clickPageButtons();
        pageWithButtons.assertTestText
                ("You have done a double click", pageWithButtons.getDoubleClickMeText());
        pageWithButtons.assertTestText
                ("You have done a right click", pageWithButtons.getRightClickMeText());
        pageWithButtons.assertTestText
                ("You have done a dynamic click", pageWithButtons.getClickMeText());
        webDriver.close();


//        webDriver.get(PageWithButtons.getUrl());
//        WebElement doubleClickMe = webDriver.findElement(PageWithButtons.getDoubleClickMeId());
//        WebElement rightClickMe = webDriver.findElement(PageWithButtons.getRightClickMeId());
//        WebElement clickMe = webDriver.findElement(PageWithButtons.getClickMeXpath());
//
//        new Actions(webDriver)
//                .doubleClick(doubleClickMe)
//                .contextClick(rightClickMe)
//                .click(clickMe)
//                .build()
//                .perform();
//
//        boolean isHaveDoubleClickMeText = webDriver.findElement
//                (PageWithButtons.getDoubleClickMeText()).isDisplayed();
//        boolean isHaveRightClickMeText = webDriver.findElement
//                (PageWithButtons.getRightClickMeText()).isDisplayed();
//        boolean isHaveClickMeText = webDriver.findElement
//                (PageWithButtons.getClickMeText()).isDisplayed();
//        webDriver.quit();
//        if (isHaveDoubleClickMeText && isHaveRightClickMeText && isHaveClickMeText) {
//            System.out.println("Тест с кнопками пройден успешно");
//        } else {
//            System.out.println("Тест с кнопками не пройден");
//        }
    }

    public static void alertPageTest() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.get(PageWithAlerts.getUrl());
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        WebElement alertButton = webDriver.findElement(PageWithAlerts.getAlertButtonId());
        WebElement timerAlertButton = webDriver.findElement(PageWithAlerts.getTimerAlertButtonId());
        WebElement confirmButton = webDriver.findElement(PageWithAlerts.getConfirmButtonId());

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();

        boolean isHaveText = webDriver.findElement
                (PageWithAlerts.getTextAlertCancelXpath()).isDisplayed();
        webDriver.quit();
        if(isHaveText) {
            System.out.println("Тест с алертами пройден успешно");
        } else {
            System.out.println("Тест с алертами не пройден");
        }

    }
}
