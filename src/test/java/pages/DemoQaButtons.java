package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class DemoQaButtons {
    private static WebDriver webDriver;

    public DemoQaButtons(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    private static final By doubleClickButton = By.xpath("//button[text()='Double Click Me']");
    private static final By rightClickButton = By.xpath("//button[text()='Right Click Me']");
    private static final By clickButton = By.xpath("//button[text()='Click Me']");

    private static final By doubleClickMessage = By.xpath("//p [@Id = 'doubleClickMessage']");
    private static final By rightClickMessage = By.xpath("//p [@Id = 'rightClickMessage']");
    private static final By clickMessage = By.xpath("//p [@Id = 'dynamicClickMessage']");


    public  void findAndClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickButton))
                .contextClick(webDriver.findElement(rightClickButton))
                .build()
                .perform();
        webDriver.findElement(clickButton).click();
    }

    public String getDoubleClickMessageText() {
        return webDriver.findElement(doubleClickMessage).getText();
    }

    public String getRightClickMessageText() {
        return webDriver.findElement(rightClickMessage).getText();
    }

    public String getClickMessageText() {
        return webDriver.findElement(clickMessage).getText();
    }


}
