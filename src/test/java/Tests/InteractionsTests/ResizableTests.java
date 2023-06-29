package Tests.InteractionsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Interactions.ResizablePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResizableTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public ResizablePage resizablePage;

    @BeforeMethod
    public void sortableSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        resizablePage = new ResizablePage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Resizable"));
        sideBar.elementsSubMenuOption("Resizable").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanResizeTheFirstBox() throws InterruptedException {
        Thread.sleep(500);
        resizablePage.resizeTheBox(0, 100, 100);
        Assert.assertEquals(resizablePage.firstBox.getAttribute("style"), "width: 300px; height: 300px;");
    }

    @Test(priority = 20)
    public void verifyThatUserCanResizeTheSecondBox() throws InterruptedException {
        Thread.sleep(500);
        scrollIntoView(resizablePage.secondBox);
        Thread.sleep(500);
        resizablePage.resizeTheBox(1, 120, 120);
        Assert.assertEquals(resizablePage.secondBox.getAttribute("style"), "width: 320px; height: 320px;");
    }
}
