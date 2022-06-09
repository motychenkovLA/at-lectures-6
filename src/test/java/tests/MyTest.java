package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.StartPage;

import java.time.Duration;

public class MyTest {

    static WebDriver webDriver;

    @BeforeClass
    public static void init(){
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public static void close(){
        webDriver.quit();
    }


    @Test(timeout = 180000)
    public void test1(){

        webDriver.get("https://demoqa.com/buttons");

        StartPage startPage = new StartPage(webDriver);
        startPage.clickButton();
        Assert.assertTrue("Тест не пройден",startPage.getText());

    }
}
