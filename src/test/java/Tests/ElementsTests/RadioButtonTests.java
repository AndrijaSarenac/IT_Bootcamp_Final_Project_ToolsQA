package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void radioButtonSetUp() {
        sideBar.elementsSubMenuOption("Radio Button").click();
    }

    @Test(priority = 20)
    public void verifyThatYesRadioButtonsWorks() {
        radioButtonPage.clickOnYesRadio();
        Assert.assertTrue(radioButtonPage.yesRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Yes");
    }

    @Test(priority = 30)
    public void verifyThatImpressiveRadioButtonsWorks() {
        radioButtonPage.clickOnImpressiveRadio();
        Assert.assertTrue(radioButtonPage.impressiveRadio.isSelected());
        Assert.assertTrue(radioButtonPage.message.isDisplayed());
        Assert.assertEquals(radioButtonPage.message.getText(), "Impressive");
    }

    @Test(priority = 40)
    public void verifyThatNoRadioButtonsWorks() {
        radioButtonPage.clickOnNoRadio();
        Assert.assertFalse(radioButtonPage.noRadio.isSelected());
        Assert.assertFalse(elementIsPresent(radioButtonPage.message));
    }
}
