package Tests.InteractionsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Interactions.DragabblePage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragabbleTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public DragabblePage dragabblePage;

    @BeforeMethod
    public void sortableSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        dragabblePage = new DragabblePage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Dragabble"));
        sideBar.elementsSubMenuOption("Dragabble").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanMoveTheBoxToDifferentLocation() throws InterruptedException {
        Thread.sleep(1000);
        Point p1 = dragabblePage.dragBox.getLocation();
        actions.dragAndDrop(dragabblePage.dragBox, dragabblePage.cursorTab).perform();
        Assert.assertNotEquals(p1, dragabblePage.dragBox.getLocation());
    }

    @Test(priority = 20)
    public void verifyThatOnlyXCanBeMoved() throws InterruptedException {
        Thread.sleep(1000);
        dragabblePage.axisRestrictedTab.click();
        int firstLocation = dragabblePage.xAxis.getLocation().getX();
        actions.dragAndDropBy(dragabblePage.xAxis, 80, 0).perform();
        Assert.assertNotEquals(dragabblePage.xAxis.getLocation().getX(), firstLocation);
    }

    @Test(priority = 30)
    public void verifyThatOnlyYCanBeMoved() throws  InterruptedException {
        Thread.sleep(1000);
        dragabblePage.axisRestrictedTab.click();
        int firstLocation = dragabblePage.yAxis.getLocation().getY();
        actions.dragAndDropBy(dragabblePage.yAxis, 0, 80).perform();
        Assert.assertNotEquals(dragabblePage.yAxis.getLocation().getX(), firstLocation);
    }


}
