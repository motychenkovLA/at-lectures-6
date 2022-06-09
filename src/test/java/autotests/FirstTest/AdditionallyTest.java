package autotests.FirstTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


public class AdditionallyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/browser-window");
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        String windowDescriptor = webDriver.getWindowHandle();
        ((ChromeDriver) webDriver).executeScript("window.open('about:blank')");

        Set<String> handles = webDriver.getWindowHandles();
        handles.remove(windowDescriptor);

        Iterator<String> iterator = handles.iterator();
        String googleWindowDescriptor = iterator.next();

        webDriver.switchTo()
                .window(googleWindowDescriptor);
        webDriver.get("https://www.google.com/");

        webDriver.switchTo()
                .window(windowDescriptor);
    }
}