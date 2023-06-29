package Tests.InteractionsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Interactions.SelectablePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectableTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public SelectablePage selectablePage;

    @BeforeMethod
    public void sortableSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        selectablePage = new SelectablePage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 5, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Selectable"));
        sideBar.elementsSubMenuOption("Selectable").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanSelectOneItemFromList() throws InterruptedException {
        Thread.sleep(400);
        selectablePage.selectOneItem("Cras justo odio");
        Assert.assertEquals(selectablePage.getOneSelectableItem("Cras justo odio").getCssValue("background-color"), "rgba(0, 123, 255, 1)");
        Assert.assertTrue(selectablePage.getOneSelectableItem("Cras justo odio").getAttribute("class").contains("active"));
    }

    @Test(priority = 20)
    public void verifyThatUserCanSelectMultipleItemsFromList() throws InterruptedException {
        Thread.sleep(400);
        for (int i = 1; i <= excelReader.getLastRow("Selectable2"); i++) {
            selectablePage.selectOneItem(excelReader.getStringData("Selectable2", i, 0));
        }
        for (int i = 1; i <= excelReader.getLastRow("Selectable2"); i++) {
            Assert.assertEquals(selectablePage.getOneSelectableItem(excelReader.getStringData("Selectable2", i, 0)).getCssValue("background-color"), "rgba(0, 123, 255, 1)");
            Assert.assertTrue(selectablePage.getOneSelectableItem(excelReader.getStringData("Selectable2", i, 0)).getAttribute("class").contains("active"));
        }
    }

    @Test(priority = 30)
    public void verifyThatUserCanSelectMultipleItemsOnTheGrid() throws InterruptedException {
        selectablePage.clickOnGridTab();
        Thread.sleep(1000);
        for (int i = 1; i <= excelReader.getLastRow("Selectable"); i++) {
            selectablePage.selectOneGridItem(excelReader.getStringData("Selectable", i, 1));
        }
        for (int i = 1; i <= excelReader.getLastRow("Selectable"); i++) {
            Assert.assertEquals(selectablePage.getOneGridItem(excelReader.getStringData("Selectable", i, 1)).getCssValue("background-color"), "rgba(0, 123, 255, 1)");
            Assert.assertTrue(selectablePage.getOneGridItem(excelReader.getStringData("Selectable", i, 1)).getAttribute("class").contains("active"));
        }
    }
}
