package autoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageWithButtons {

    WebDriver webDriver;

    public PageWithButtons(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private static final By doubleClickMeId = By.id("doubleClickBtn");
    private static final By rightClickMeId = By.id("rightClickBtn");
    private static final By clickMeXpath = By.xpath("//button[text()='Click Me']");

    private static final By doubleClickMeText = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickMeText = By.xpath("//p[text()='You have done a right click']");
    private static final By clickMeText = By.xpath("//p[text()='You have done a dynamic click']");

    public PageWithButtons clickPageButtons() {
        Actions actions = new Actions(webDriver);
        WebElement doubleClickMe = webDriver.findElement(doubleClickMeId);
        WebElement rightClickMe = webDriver.findElement(rightClickMeId);
        WebElement clickMe = webDriver.findElement(clickMeXpath);
        actions
                .doubleClick(doubleClickMe)
                .contextClick(rightClickMe)
                .click(clickMe)
                .build()
                .perform();
       return new PageWithButtons(webDriver);
    }

    public void assertTestText(String expectedText, String actualText) {
        if (expectedText.equals(actualText)) {
            System.out.println("Тестирование текста сообщения пройдено успешно");
        } else {
            System.out.println("Тест провалился");
        }
    }

    public String getDoubleClickMeText() {
       return webDriver.findElement(doubleClickMeText).getText();
    }

    public String getRightClickMeText() {
        return webDriver.findElement(rightClickMeText).getText();
    }

    public String getClickMeText() {
        return webDriver.findElement(clickMeText).getText();
    }
}
