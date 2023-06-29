package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.SliderPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public SliderPage sliderPage;

    @BeforeMethod
    public void sliderSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        sliderPage = new SliderPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Slider"));
        sideBar.elementsSubMenuOption("Slider").click();
    }

    @Test(priority = 10)
    public void verifySliderCanBeMoved() throws InterruptedException {
        sliderPage.moveSliderUp(20);
        wait.until(ExpectedConditions.attributeToBe(sliderPage.slider, "value", "45"));
        Assert.assertEquals(sliderPage.slider.getAttribute("value"), "45");
    }

    @Test(priority = 20)
    public void verifySliderCannotBeMovedOverValue100() {
        sliderPage.moveSliderUp(80);
        Assert.assertEquals(sliderPage.slider.getAttribute("value"), "100");
    }

    @Test(priority = 30)
    public void verifySliderCannotMoveBelowValue0() {
        sliderPage.moveSliderDown(40);
        Assert.assertEquals(sliderPage.slider.getAttribute("value"), "0");
    }
}
