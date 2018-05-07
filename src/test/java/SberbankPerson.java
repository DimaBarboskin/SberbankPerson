import application.TestBase;

import org.junit.Test;
import pages.MainPage;
import pages.SelectorRegion;
/**
 * Created by Rogoza Dimity on 05.05.2018.
 */
public class SberbankPerson extends TestBase{
    @Test
    public void checkRegion() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSelectRegion();
        SelectorRegion selectorRegion = new SelectorRegion(driver);
        selectorRegion.inputRegionName("Нижегородская область");
        selectorRegion.selectRegionName();
        mainPage.checkMainRegionName();
        mainPage.checkFooter();
    }
}
