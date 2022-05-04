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
    private static final By doubleClickText = By.id("doubleClickMessage");
    private static final By rightClickText = By.id("rightClickMessage");
    private static final By dynamicClickText  = By.id("dynamicClickMessage");

    public  void findAndClick(){
        Actions actions = new Actions(webDriver);
        actions.doubleClick(webDriver.findElement(doubleClickButton))
                .contextClick(webDriver.findElement(rightClickButton))
                .build()
                .perform();
        webDriver.findElement(clickButton).click();
    }

    public  void checkTest(){
        boolean isHaveDoubleClickText = webDriver.findElement(doubleClickText).isDisplayed();
        boolean isHaveRightClickText = webDriver.findElement(rightClickText).isDisplayed();
        boolean isHaveDynamicClickText= webDriver.findElement(dynamicClickText).isDisplayed();

        if (isHaveDoubleClickText && isHaveRightClickText && isHaveDynamicClickText){
            System.out.println("Тест пройден успешно!");
        }
        else System.out.println("Тест не пройден");
    }

}
