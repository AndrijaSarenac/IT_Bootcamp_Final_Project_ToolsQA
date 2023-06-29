package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LinksTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void linksSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Links"));
        sideBar.elementsSubMenuOption("Links").click();
    }

    @Test(priority = 10)
    public void verifyThatHomeLink1Works() {
        linksPage.clickOnHomePageLink1();
        ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        Assert.assertTrue(homePage.banner.isDisplayed());
        driver.switchTo().window(listOfTabs.get(0));
    }

    @Test(priority = 20)
    public void verifyThatHomeLink2Works() {
        linksPage.clickOnHomePageLink2();
        ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listOfTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        Assert.assertTrue(homePage.banner.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatCreatedLinkWorks() {
        waitForVisibility(linksPage.createdLink);
        linksPage.clickOnCreatedLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 201 and status text Created");
    }

    @Test(priority = 40)
    public void verifyThatNoContentLinkWorks() {
        waitForVisibility(linksPage.noContentLink);
        linksPage.clickOnNoContentLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 204 and status text No Content");
    }

    @Test(priority = 50)
    public void verifyThatMovedLinkWorks() {
        waitForVisibility(linksPage.movedLink);
        linksPage.clickOnMovedLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 301 and status text Moved Permanently");
    }

    @Test(priority = 60)
    public void verifyThatBadRequestLinkWorks() {
        waitForVisibility(linksPage.badRequestLink);
        linksPage.clickOnBadRequestLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 400 and status text Bad Request");
    }

    @Test(priority = 70)
    public void verifyThatUnauthorizedLinkWorks() {
        waitForVisibility(linksPage.unauthorizedLink);
        linksPage.clickOnUnauthorizedLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 401 and status text Unauthorized");
    }

    @Test(priority = 80)
    public void verifyThatForbiddenLinkWorks() {
        waitForVisibility(linksPage.forbiddenLink);
        linksPage.clickOnForbiddenLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 403 and status text Forbidden");
    }

    @Test(priority = 90)
    public void verifyThatNotFoundLinkWorks() {
        waitForVisibility(linksPage.notFoundLink);
        linksPage.clickOnNotFoundLink();
        waitForVisibility(linksPage.responseMessage);
        Assert.assertTrue(linksPage.responseMessage.isDisplayed());
        Assert.assertEquals(linksPage.responseMessage.getText(), "Link has responded with staus 404 and status text Not Found");
    }

    @AfterMethod
    public void waitALittleBit() throws InterruptedException {
        Thread.sleep(1500);
    }
}
