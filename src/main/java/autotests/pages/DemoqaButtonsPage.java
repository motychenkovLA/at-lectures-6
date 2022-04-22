package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaButtonsPage {

    private static By doubleClickMeLocator = By.xpath("//button[text()=\"Double Click Me\"]");
    private static By rightClickMeLocator = By.xpath("//button[text()=\"Right Click Me\"]");
    private static By clickMeLocator = By.xpath("//button[text()=\"Click Me\"]");

    public static By getDoubleClickMeLocator() {
        return doubleClickMeLocator;
    }

    public static By getRightClickMeLocator() {
        return rightClickMeLocator;
    }

    public static By getClickMeLocator() {
        return clickMeLocator;
    }

    public static String checkResult(WebDriver webDriver) {
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
