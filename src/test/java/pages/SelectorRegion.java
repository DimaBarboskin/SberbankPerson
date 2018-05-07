package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rogoza Dimity on 07.05.2018.
 */
public class SelectorRegion {
    WebDriver driver;

    @FindBy(xpath = "//input[contains(@placeholder,'Введите название региона')]")
    private WebElement nameRegion;
    @FindBy(xpath = "//span[contains(@class,'region-search-box__option')]")
    private WebElement selectedNameRegion;

    public SelectorRegion(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getNameRegion() {
        return nameRegion;
    }
    public WebElement getSelectedNameRegion() {
        return selectedNameRegion;
    }

    public void inputRegionName(String name){
        nameRegion.sendKeys(name);
    }
    public void  selectRegionName(){
        selectedNameRegion.click();
    }
}
