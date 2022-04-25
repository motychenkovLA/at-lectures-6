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

    WebElement doubleClickMe = webDriver.findElement(doubleClickMeLocator);
    WebElement rightClickMe = webDriver.findElement(rightClickMeLocator);
    WebElement clickMe = webDriver.findElement(clickMeLocator);


    public void doubleClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(doubleClickMe)
                .build()
                .perform();
    }

    public void rightClick(){
        Actions actions = new Actions(webDriver);
        actions.contextClick(rightClickMe)
                .build()
                .perform();
    }

    public void click(){
        Actions actions = new Actions(webDriver);
        actions.click(clickMe)
                .build()
                .perform();
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
