package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class PageClass1 {
    private WebDriver webDriver;

    private By doubleClickxpath = By.xpath("//button[text()='Double Click Me']");
    private By rightClickxpath = By.xpath("//button[text()='Right Click Me']");
    private By clickxpath = By.xpath("//button[text()='Click Me']");

    public PageClass1(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void findEndClick() {
        WebElement doubleClick = webDriver.findElement(doubleClickxpath);
        WebElement rightClick = webDriver.findElement(rightClickxpath);
        WebElement click = webDriver.findElement(clickxpath);
        new Actions(webDriver)
                .doubleClick(doubleClick)
                .contextClick(rightClick)
                .click(click)
                .build()
                .perform();
    }

    public boolean doubleClickText() {
        return !webDriver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
    }

    public boolean rightClickText() {
        return !webDriver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
    }

    public boolean clickText() {
        return !webDriver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
    }

}
