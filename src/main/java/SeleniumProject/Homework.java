package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Homework {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            //хром находится по другому пути
            //вот как нужно было тогда объявить System.setProperty("webdriver.chrome.driver", "src/main/java/seleniumProject/chromedriver.exe");
            //Исправь
            WebDriver driver = new ChromeDriver();

            /*
            Не указал неявное ожидание.
            Представь кейс. get команда выполнилась - сайт сейчас в процессе загрузки.
            Но код то быстрее работает у тебя driver.findElement попробует найти элемент (а его нет)
            Т.к ожидания нет - то упадет с NoSuchElementException
            Исправь
             */
            driver.get("https://demoqa.com/buttons");

            WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
            WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
            WebElement clickMeBtn = driver.findElement(By.xpath("//button[text() = 'Click Me']"));

            Actions action = new Actions(driver);

            //Ремарка. так и дебажить удобнее и структурировано выглядит код.
            action.doubleClick(doubleClickBtn)
                    .contextClick(rightClickBtn)
                    .click(clickMeBtn)
                    .build()
                    .perform();

            //findElements - возвращает лист - никогда не может вернуть ошибку. Не правильно.
            //Посмотри как я организовал проверки или подумай - перепеши по своему.
            //Исправь
            System.out.println(!driver.findElements(By.id("doubleClickMessage")).isEmpty());
            System.out.println(!driver.findElements(By.id("rightClickMessage")).isEmpty());
            System.out.println(!driver.findElements(By.id("dynamicClickMessage")).isEmpty());
        } catch (Exception e) {
            System.out.println("Что то пошло не так");
        }

    }
}
