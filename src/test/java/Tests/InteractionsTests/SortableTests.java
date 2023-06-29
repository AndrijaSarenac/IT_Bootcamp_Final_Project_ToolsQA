package Tests.InteractionsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Interactions.SortablePage;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortableTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public SortablePage sortablePage;

    @BeforeMethod
    public void sortableSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        sortablePage = new SortablePage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Sortable"));
        sideBar.elementsSubMenuOption("Sortable").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanMoveOneElementToDifferentPosition() throws InterruptedException {
        Thread.sleep(1000);
        Point p1 = sortablePage.getOneElementPoint(sortablePage.getOneSortableElement("One"));
        Point p2 = sortablePage.getOneElementPoint(sortablePage.getOneSortableElement("Two"));
        actions.dragAndDrop(sortablePage.getOneSortableElement("One"), sortablePage.getOneSortableElement("Two")).perform();
        Thread.sleep(1000);
        Assert.assertEquals(p1, sortablePage.getOneElementPoint(sortablePage.getOneSortableElement("Two")));
        Assert.assertEquals(p2, sortablePage.getOneElementPoint(sortablePage.getOneSortableElement("One")));
    }

    @Test(priority = 20)
    public void verifyThatUserCanMoveAnElementInTheGrid() throws InterruptedException {
        sortablePage.clickOnGridTab();
        Thread.sleep(1000);
        Point p1 = sortablePage.getOneGridElementPoint(sortablePage.getOneSortableGridElement("Eight"));
        Point p2 = sortablePage.getOneGridElementPoint(sortablePage.getOneSortableGridElement("Nine"));
        actions.dragAndDrop(sortablePage.getOneSortableGridElement("One"), sortablePage.getOneSortableGridElement("Nine")).perform();
        Assert.assertEquals(p2, sortablePage.getOneGridElementPoint(sortablePage.getOneSortableGridElement("One")));
        Assert.assertEquals(p1, sortablePage.getOneGridElementPoint(sortablePage.getOneSortableGridElement("Nine")));
    }
}
