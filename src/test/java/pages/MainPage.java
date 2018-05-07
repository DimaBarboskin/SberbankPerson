package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='region-list__arrow']")
    private WebElement selectRegion;
    @FindBy(xpath = "//span[contains(@class,'region-list__name')]")
    private WebElement mainNameRegion;
    @FindBy(xpath = "//*[@class='social__wrapper']")
    private WebElement footer;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    public WebElement getSelectRegion() {
        return selectRegion;
    }
    public WebElement getMainNameRegion() {
        return mainNameRegion;
    }
    public WebElement getFooter() {
        return footer;
    }
    public void clickSelectRegion(){
        selectRegion.click();
    }

    public void checkMainRegionName(){
        Assert.assertEquals("Проверяем область","Нижегородская область",mainNameRegion.getText());
    }
    public void checkFooter(){
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
