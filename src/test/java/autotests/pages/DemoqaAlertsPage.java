package autotests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class DemoqaAlertsPage {

    private WebDriver webDriver;
    private static By alertButtonLocator = By.id("alertButton");
    private static By timerAlertButtonLocator = By.id("timerAlertButton");
    private static By confirmButtonLocator = By.id("confirmButton");
    private static By isHaveCancelLocator = By.xpath("//span[text()='Cancel']");

    public DemoqaAlertsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Проверка текста об отмене аллерта")
    public static String checkResult(WebDriver webDriver) {
        boolean isHaveCancel = !webDriver.findElements(isHaveCancelLocator).isEmpty();

        if (isHaveCancel) {
            return "Тест пройден!";
        } else {
            return "Тест не пройден!";
        }
    }

    @Step("Получение текста об отмене аллерта")
    public String getHaveCancelText(WebDriver webDriver) {
        return webDriver.findElement(isHaveCancelLocator).getText();
    }

    @Step("Нажатие на кнопку и принятие аллерта")
    public void clickAndAcceptAlert() {
        webDriver.findElement(alertButtonLocator).click();
        webDriver.switchTo()
                .alert()
                .accept();
    }

    @Step("Нажатие на кнопку и ожидание аллерта")
    public void clickAndWaitAlert() {
        webDriver.findElement(timerAlertButtonLocator).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        webDriver.switchTo()
                .alert()
                .accept();
    }

    @Step("Нажатие на кнопку и отмена аллерта")
    public void clickAndDismiss() {
        webDriver.findElement(confirmButtonLocator).click();
        webDriver.switchTo()
                .alert()
                .dismiss();
    }
}
