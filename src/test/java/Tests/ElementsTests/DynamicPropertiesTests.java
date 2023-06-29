package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void dynamicPropertiesSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Dynamic Properties"));
        sideBar.elementsSubMenuOption("Dynamic Properties").click();
    }

    @Test(priority = 10)
    public void verifyThatButtonIsEnabled() {
        waitForClickability(dynamicPropertiesPage.enableButton);
        Assert.assertTrue(dynamicPropertiesPage.enableButton.isEnabled());
    }

    @Test(priority = 20)
    public void verifyThatColorChangesOnButton() {
        String color = dynamicPropertiesPage.colorButton.getCssValue("color");
        waitForClickability(dynamicPropertiesPage.enableButton);
        Assert.assertNotEquals(dynamicPropertiesPage.colorButton.getCssValue("color"), color);
    }

    @Test(priority = 30)
    public void verifyThatButtonIsVisible() {
        waitForVisibility(dynamicPropertiesPage.visibleButton);
        Assert.assertTrue(dynamicPropertiesPage.visibleButton.isDisplayed());
    }
}
