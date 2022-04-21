package seleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Buttons {
    private static final String site = "https://demoqa.com/buttons";
    private static final By doubleClickBtnPath = By.id("doubleClickBtn");
    private static final By rightClickBtnPath = By.id("rightClickBtn");
    private static final By clickMeBtnPath = By.xpath("//button[text() = 'Click Me']");


    public static String getSite() {
        return site;
    }

    public static By getDoubleClickBtnPath() {
        return doubleClickBtnPath;
    }

    public static By getRightClickBtnPath() {
        return rightClickBtnPath;
    }

    public static By getClickMeBtnPath() {
        return clickMeBtnPath;
    }

    public static boolean isTestSuccess(WebDriver driver) {
        boolean isDouble = !driver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
        boolean isRight = !driver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
        boolean isClickMe = !driver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
        return isDouble && isRight && isClickMe;
    }
}
