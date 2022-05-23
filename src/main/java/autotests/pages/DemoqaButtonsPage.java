package autotests.pages;

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
    public String expectedHaveDoubleClickText = "You have done a double click";
    public String expectedHaveRightClickText = "You have done a right click";
    public String expectedHaveDynamicClickText = "You have done a dynamic click";

    public DemoqaButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getHaveDoubleClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveDoubleClickTextLocator).getText();
    }

    public String getHaveRightClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveRightClickTextLocator).getText();
    }

    public String getHaveDynamicClickText(WebDriver webDriver) {
        return webDriver.findElement(isHaveDynamicClickTextLocator).getText();
    }

    public void doubleClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickMeLocator))
                .build()
                .perform();
    }

    public void rightClick(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(webDriver.findElement(rightClickMeLocator))
                .build()
                .perform();
    }

    public void click(){
        webDriver.findElement(clickMeLocator).click();
    }

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
