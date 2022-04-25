package autotests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//        Доп.задание
//        1. Зайти по адресу https://demoqa.com/browser-windows
//        2. Нажать New Tab кнопочку.
//        3. Переключить драйвер на новое окно.
//        4. В этом новом окне открыть google.com
//        5. вернуться на предыдущее окно.

public class AdditionallyTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/browser-window");
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