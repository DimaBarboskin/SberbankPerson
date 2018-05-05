import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rogoza Dimity on 05.05.2018.
 */
public class SberbankPerson {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.sberbank.ru/ru/person");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkRegion() {
        driver.findElement(By.xpath("//*[@class='region-list__arrow']")).click();

        driver.findElement(By.xpath("//input[contains(@placeholder,'Введите название региона')]"))
                .sendKeys("Нижегородская область");

        driver.findElement(By.xpath("//span[contains(@class,'region-search-box__option')]")).click();

        WebElement region = driver.findElement(By.xpath("//span[contains(@class,'region-list__name')]"));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(region));
        Assert.assertEquals("Проверяем область","Нижегородская область",region.getText());

        WebElement footer = driver.findElement(By.xpath("//*[@class='social__wrapper']"));
        new Actions(driver).moveToElement(footer).perform();
        checkIconsSocialNetworks(driver);
    }
    public static void checkIconsSocialNetworks(WebDriver driver){
        WebElement facebook = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Фейсбук')]"));
        WebElement twitter = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Твиттер')]"));
        WebElement youtube = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Ютьюб')]"));
        WebElement instragram = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Инстаграмм')]"));
        WebElement vk = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Вконтакте')]"));
        WebElement odnoClass = driver.findElement(By.xpath("//a[contains(@aria-label,'Поделиться в Одноклассниках')]"));
    }
}
