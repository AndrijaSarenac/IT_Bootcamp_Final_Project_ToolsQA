package Tests.InteractionsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Interactions.DroppablePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public DroppablePage droppablePage;

    @BeforeMethod
    public void sortableSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        droppablePage = new DroppablePage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Droppable"));
        sideBar.elementsSubMenuOption("Droppable").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanDragAndDropTheElementToRightPlace() throws InterruptedException {
        Thread.sleep(1000);
        actions.dragAndDrop(droppablePage.dragElement, droppablePage.dropElement).perform();
        Assert.assertEquals(droppablePage.dropElement.getText(), "Dropped!");
        Assert.assertEquals(droppablePage.dropElement.getCssValue("background-color"), "rgba(70, 130, 180, 1)");
    }

    @Test(priority = 20)
    public void verifyThatUserCanDragAndDropAcceptableElements() throws InterruptedException {
        droppablePage.getOneTab("Accept").click();
        Thread.sleep(1000);
        actions.dragAndDrop(droppablePage.acceptableElement, droppablePage.dropField).perform();
        Assert.assertEquals(droppablePage.dropField.getText(), "Dropped!");
        Assert.assertEquals(droppablePage.dropField.getCssValue("background-color"), "rgba(70, 130, 180, 1)");
    }

    @Test(priority = 30)
    public void verifyThatDroppingNotAcceptableDoesNotChangeTheColor() throws InterruptedException {
        droppablePage.getOneTab("Accept").click();
        Thread.sleep(1000);
        actions.dragAndDrop(droppablePage.notAcceptableElement, droppablePage.dropField).perform();
        Assert.assertNotEquals(droppablePage.dropField.getText(), "Dropped!");
        Assert.assertNotEquals(droppablePage.dropField.getCssValue("background-color"), "rgba(70, 130, 180, 1)");
    }

    @Test(priority = 40)
    public void verifyAnotherDragAndDrop() throws InterruptedException {
        waitForClickability(droppablePage.getOneTab("Prevent Propogation"));
        droppablePage.getOneTab("Prevent Propogation").click();
        Thread.sleep(1000);
        actions.dragAndDrop(droppablePage.dragBox, droppablePage.outerBox).perform();
        Assert.assertEquals(droppablePage.outerBox.getText(), "Dropped!");
    }
}
