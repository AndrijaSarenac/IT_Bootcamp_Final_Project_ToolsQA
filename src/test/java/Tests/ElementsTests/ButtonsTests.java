package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void buttonsSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Buttons"));
        sideBar.elementsSubMenuOption("Buttons").click();
    }

    @Test(priority = 10)
    public void verifyThatDoubleClickButtonWorks() {
        doubleClickOnElement(buttonsPage.oneClickMeButton("Double Click Me"));
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(), "You have done a double click");
    }

    @Test(priority = 20)
    public void verifyThatRightClickButtonWorks() {
        rightClickOnElement(buttonsPage.oneClickMeButton("Right Click Me"));
        Assert.assertTrue(buttonsPage.rightClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.rightClickMessage.getText(), "You have done a right click");
    }

    @Test(priority = 30)
    public void verifyThatClickButtonWorks() {
        buttonsPage.oneClickMeButton("Click Me").click();
        Assert.assertTrue(buttonsPage.dynamicClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.dynamicClickMessage.getText(), "You have done a dynamic click");
    }
}
