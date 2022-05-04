package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class PageButtons {
    private WebDriver webDriver;

    private By doubleClickxpath = By.xpath("//button[text()='Double Click Me']");
    private By rightClickxpath = By.xpath("//button[text()='Right Click Me']");
    private By clickxpath = By.xpath("//button[text()='Click Me']");
    private By doubleClickTextXpath = By.xpath("//p[text()='You have done a double click']");
    private By rightClickTextXpath = By.xpath("//p[text()='You have done a right click']");
    private By clickTextXpath = By.xpath("//p[text()='You have done a dynamic click']");

    public PageButtons(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickDoubleButton() {
        WebElement doubleClick = webDriver.findElement(doubleClickxpath);
        new Actions(webDriver)
                .doubleClick(doubleClick)
                .build()
                .perform();
    }
    public void clickRightButton() {
        WebElement rightClick = webDriver.findElement(rightClickxpath);
        new Actions(webDriver)
                .contextClick(rightClick)
                .build()
                .perform();
    }
    public void clickButton() {
        WebElement click = webDriver.findElement(clickxpath);
        new Actions(webDriver)
                .click(click)
                .build()
                .perform();
    }

    public boolean isHaveDoubleClickText() {
        return !webDriver.findElements(doubleClickTextXpath).isEmpty();
    }

    public boolean isHaveRightClickText() {
        return !webDriver.findElements(rightClickTextXpath).isEmpty();
    }

    public boolean isHaveClickText() {
        return !webDriver.findElements(clickTextXpath).isEmpty();
    }

}
