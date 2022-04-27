package seleniumProject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Buttons {
    private static final String site = "https://demoqa.com/buttons";
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

    public void isTestSuccess() {
        boolean isDouble = !driver.findElements(By.xpath("//p[text()='You have done a double click']")).isEmpty();
        boolean isRight = !driver.findElements(By.xpath("//p[text()='You have done a right click']")).isEmpty();
        boolean isClickMe = !driver.findElements(By.xpath("//p[text()='You have done a dynamic click']")).isEmpty();
        System.out.println(isDouble && isRight && isClickMe ? "Тест пройден успешно" : "Тест не пройден");
    }
}
