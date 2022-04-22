package autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaButtonsPage {

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
