package autoTests;

import org.openqa.selenium.By;

public class PageWithButtons {

    private static final String url = "https://demoqa.com/buttons";

    private static final By doubleClickMeId = By.id("doubleClickBtn");
    private static final By rightClickMeId = By.id("rightClickBtn");
    private static final By clickMeXpath = By.xpath("//button[text()='Click Me']");

    private static final By doubleClickMeText = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickMeText = By.xpath("//p[text()='You have done a right click']");
    private static final By clickMeText = By.id("dynamicClickMessage");

    public static String getUrl() {
        return url;
    }

    public static By getDoubleClickMeId() {
        return doubleClickMeId;
    }

    public static By getRightClickMeId() {
        return rightClickMeId;
    }

    public static By getClickMeXpath() {
        return clickMeXpath;
    }

    public static By getDoubleClickMeText() {
        return doubleClickMeText;
    }

    public static By getRightClickMeText() {
        return rightClickMeText;
    }

    public static By getClickMeText() {
        return clickMeText;
    }
}
