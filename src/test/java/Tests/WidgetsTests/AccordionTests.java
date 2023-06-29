package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.AccordionPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordionTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public AccordionPage accordionPage;

    @BeforeMethod
    public void accordionSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        accordionPage = new AccordionPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Accordian"));
        sideBar.elementsSubMenuOption("Accordian").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanCloseTheFirstCard() throws InterruptedException {
        accordionPage.clickOnFirstCard();
        wait.until(ExpectedConditions.invisibilityOf(accordionPage.sectionOneContent));
        Assert.assertFalse(accordionPage.sectionOneContent.isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatOpeningTheSecondCardClosesTheFirst() {
        accordionPage.clickOnSecondCard();
        wait.until(ExpectedConditions.invisibilityOf(accordionPage.sectionOneContent));
        Assert.assertFalse(accordionPage.sectionOneContent.isDisplayed());
        Assert.assertTrue(accordionPage.sectionTwoContent.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatOpeningTheThirdCardClosesTheFirst() {
        accordionPage.clickOnThirdCard();
        wait.until(ExpectedConditions.invisibilityOf(accordionPage.sectionOneContent));
        Assert.assertFalse(accordionPage.sectionOneContent.isDisplayed());
        Assert.assertTrue(accordionPage.sectionThreeContent.isDisplayed());
    }
}
