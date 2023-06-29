package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    public HomePage homePage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        driver.get(homeURL);
    }

    @Test(priority = 10)
    public void verifyThePresenceOfElementsOfHomePage() {
        Assert.assertTrue(homePage.logo.isDisplayed());
        Assert.assertTrue(homePage.banner.isDisplayed());
        Assert.assertTrue(homePage.footer.isDisplayed());
        for (int i = 1; i <= 6; i++) {
            Assert.assertTrue(homePage.oneCard(excelReader.getStringData("Cards", i, 0)).isDisplayed());
        }
    }

    @Test(priority = 20)
    public void verifyThatLogoWorks() {
        homePage.logo.click();
        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(homePage.logo.isDisplayed());
        Assert.assertTrue(homePage.banner.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatSeleniumBannerRedirectsCorrectly() {
        homePage.banner.click();
        ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 1));
        Assert.assertTrue(driver.findElement(By.className("enroll__heading")).isDisplayed());
    }

    @Test(priority = 40)
    public void verifyThatElementsCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 1, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 2));
        Assert.assertEquals(pageName.getText(), "Elements");
    }

    @Test(priority = 50)
    public void verifyThatFormsCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 2, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 3));
        Assert.assertEquals(pageName.getText(), "Forms");
    }

    @Test(priority = 60)
    public void verifyThatAFWCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 3, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 4));
        Assert.assertEquals(pageName.getText(), "Alerts, Frame & Windows");
    }

    @Test(priority = 70)
    public void verifyThatWidgetsCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 5));
        Assert.assertEquals(pageName.getText(), "Widgets");
    }

    @Test(priority = 80)
    public void verifyThatInteractionsCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 6));
        Assert.assertEquals(pageName.getText(), "Interactions");
    }

    @Test(priority = 90)
    public void verifyThatBookStoreApplicationCardWorks() {
        homePage.oneCard(excelReader.getStringData("Cards", 6, 0)).click();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 7));
        Assert.assertEquals(pageName.getText(), "Book Store");
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}
