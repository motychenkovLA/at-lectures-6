package autotests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoqaButtonsPage {

    private WebDriver webDriver;
    private static By doubleClickMeLocator = By.xpath("//button[text()=\"Double Click Me\"]");
    private static By rightClickMeLocator = By.xpath("//button[text()=\"Right Click Me\"]");
    private static By clickMeLocator = By.xpath("//button[text()=\"Click Me\"]");
    private static By isHaveDoubleClickTextLocator = By.id("doubleClickMessage");
    private static By isHaveRightClickTextLocator = By.id("rightClickMessage");
    private static By isHaveDynamicClickTextLocator = By.id("dynamicClickMessage");

    public DemoqaButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Получение текста о двойном клике")
    public String getHaveDoubleClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveDoubleClickTextLocator).getText();
    }

    @Step("Получение текста о нажатии правой кнопкой мыши")
    public String getHaveRightClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveRightClickTextLocator).getText();
    }

    @Step("Получение текста о нажатии левой кнопкой мыши")
    public String getHaveDynamicClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveDynamicClickTextLocator).getText();
    }

    @Step("Двойной клик")
    public void doubleClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickMeLocator))
                .build()
                .perform();
    }

    @Step("Клик правой кнопкой мыши")
    public void rightClick(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickMeLocator))
                .build()
                .perform();
    }

    @Step("Клик левой кнопкой мыши")
    public void click(){
        webDriver.findElement(clickMeLocator).click();
    }

    @Step("Проверка соответствия текста о нажатии кнопок")
    public String checkResult(WebDriver webDriver) {
        boolean isHaveDoubleClickText = !webDriver.findElements(isHaveDoubleClickTextLocator).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(isHaveRightClickTextLocator).isEmpty();
        boolean isHaveDynamicClickText = !webDriver.findElements(isHaveDynamicClickTextLocator).isEmpty();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveDynamicClickText) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }

}
