package Tests.ElementsTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void brokenLinksSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Broken Links - Images"));
        sideBar.elementsSubMenuOption("Broken Links - Images").click();
    }

    @Test(priority = 10)
    public void verifyImages() {
        Assert.assertTrue(brokenLinksImagesPage.validImage.isDisplayed());
        Assert.assertTrue(brokenLinksImagesPage.brokenImage.isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatValidLinkRedirectsProperly() {
        brokenLinksImagesPage.clickOnValidLink();
        waitForURL(excelReader.getStringData("URL", 1, 0));
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 0));
        Assert.assertTrue(homePage.banner.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatBrokenLinkRedirectsProperly() {
        brokenLinksImagesPage.clickOnBrokenLink();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 1, 8));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).isDisplayed());
    }
}
