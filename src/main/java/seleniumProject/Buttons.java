package seleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Buttons {
    private static final String site = "https://demoqa.com/buttons";
    private static final By doubleClickMeText = By.xpath("//p[text()='You have done a double click']");
    private static final By rightClickMeText = By.xpath("//p[text()='You have done a right click']");
    private static final By clickMeText = By.xpath("//p[text()='You have done a dynamic click']");
    private final By doubleClickBtnPath = By.id("doubleClickBtn");
    private final By rightClickBtnPath = By.id("rightClickBtn");
    private final By clickMeBtnPath = By.xpath("//button[text() = 'Click Me']");
    private final WebDriver driver;

    public Buttons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(site);
    }

    public void clickAllButtons() {
        WebElement doubleClickBtn = driver.findElement(doubleClickBtnPath);
        WebElement rightClickBtn = driver.findElement(rightClickBtnPath);
        WebElement clickMeBtn = driver.findElement(clickMeBtnPath);

        Actions action = new Actions(driver);

        action.doubleClick(doubleClickBtn)
                .contextClick(rightClickBtn)
                .click(clickMeBtn)
                .build()
                .perform();
    }

    public String getDoubleClickMeText() {
        return driver.findElement(doubleClickMeText).getText();
    }

    public String getRightClickMeText() {
        return driver.findElement(rightClickMeText).getText();
    }

    public String getClickMeText() {
        return driver.findElement(clickMeText).getText();
    }
}
