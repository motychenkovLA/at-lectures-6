package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        //���� ��������� �� ������� ����
        //��� ��� ����� ���� ����� �������� System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
        //�������
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");

        //��� ��� ��������� ������� �������� (� 1 ������� ���)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));

        /*
        Actions �������� ��� ������� �������� � ������� ��������. ���� �� ������� ��������

        ��� ������ ��� �����.
        alertButton.click();

        UPD. ���� ��� �������� ����� - �� ������� ���� ��� �� ����� ������.
        ������� ��� ����������� ����.
         */
        Actions action = new Actions(driver);
        action.click(alertButton).build().perform();

        //�������. ��� � �������� ������� � ��������������� �������� ���.
        driver.switchTo()
                .alert()
                .accept();

        action.click(timerAlertButton).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        //�������. ��� � �������� ������� � ��������������� �������� ���.
        driver.switchTo()
                .alert()
                .accept();

        action.click(confirmButton).build().perform();
        driver.switchTo()
                .alert()
                .dismiss();

        //��� ���� �������� �� ����������. �������� ��� ����������� � ����.
        //��� ����� ���������� ����� �������� ����� ����� ������ ������.
        System.out.println(!driver.findElements(By.id("confirmResult")).isEmpty());
    }
}
