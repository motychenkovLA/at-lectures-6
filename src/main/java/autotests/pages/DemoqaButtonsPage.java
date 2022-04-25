package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DemoqaButtonsPage {

    private WebDriver webDriver;
    private static By doubleClickMeLocator = By.xpath("//button[text()=\"Double Click Me\"]");
    private static By rightClickMeLocator = By.xpath("//button[text()=\"Right Click Me\"]");
    private static By clickMeLocator = By.xpath("//button[text()=\"Click Me\"]");

    public DemoqaButtonsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
        boolean isHaveDoubleClickText = !webDriver.findElements(By.id("doubleClickMessage")).isEmpty();
        boolean isHaveRightClickText = !webDriver.findElements(By.id("rightClickMessage")).isEmpty();
        boolean isHaveDynamicClickText = !webDriver.findElements(By.id("dynamicClickMessage")).isEmpty();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveDynamicClickText) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }


}
