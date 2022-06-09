package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StartPage {

    private static By doubleClick = By.id("doubleClickBtn");
    private static By rightClick = By.id("rightClickBtn");
    private static By click = By.xpath("//button[text()='Click Me']");
    private static By doubleClickText = By.xpath("//p[text()='You have done a double click']");
    private static By rightClickText = By.xpath("//p[text()='You have done a right click']");
    private static By clickmeClickText = By.xpath("//p[text()='You have done a dynamic click']");
    WebDriver driver;


    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public StartPage clickButton() {
        new Actions(driver)
                .doubleClick(driver.findElement(doubleClick))
                .contextClick(driver.findElement(rightClick))
                .click(driver.findElement(click))
                .build()
                .perform();
        return new StartPage(driver);
    }


    public boolean getText() {
        boolean isHaveDoubleClickText = !driver.findElements(doubleClickText).isEmpty();
        boolean isHaveRightClickText = !driver.findElements(rightClickText).isEmpty();
        boolean isHaveClickmeClickText = !driver.findElements(clickmeClickText).isEmpty();

        return isHaveDoubleClickText && isHaveRightClickText && isHaveClickmeClickText;
    }
}
