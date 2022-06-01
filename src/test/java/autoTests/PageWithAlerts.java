package autoTests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageWithAlerts {

    WebDriver webDriver;

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButton;

    @FindBy(xpath = "//span[text()='You selected ' and text()='Cancel'] ")
    private WebElement textAlertCancel;

    public PageWithAlerts(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

//    private static final By alertButtonId = By.id("alertButton");
//    private static final By timerAlertButtonId = By.id("timerAlertButton");
//    private static final By confirmButtonId = By.id("confirmButton");
//    private static final By textAlertCancelXpath = By.xpath("//span[text()='You selected ' and text()='Cancel'] ");

    @Step("Клики по кнопкам с алертами")
    public PageWithAlerts clickPageButtons() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

//        WebElement alertButton = webDriver.findElement(alertButtonId);
//        WebElement timerAlertButton = webDriver.findElement(timerAlertButtonId);
//        WebElement confirmButton = webDriver.findElement(confirmButtonId);

        alertButton.click();
        webDriver.switchTo().alert().accept();

        timerAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent()).accept();

        confirmButton.click();
        webDriver.switchTo().alert().dismiss();
        return new PageWithAlerts(webDriver);
    }

    @Step("Получить текст по отмене алерта")
    public String getAlertCancelText() {
//        return webDriver.findElement(textAlertCancelXpath).getText();
        return textAlertCancel.getText();
    }
}
