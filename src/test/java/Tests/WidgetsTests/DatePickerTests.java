package Tests.WidgetsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.HomePage;
import Pages.Widgets.DatePickerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public DatePickerPage datePickerPage;

    @BeforeMethod
    public void datePickerSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        datePickerPage = new DatePickerPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 4, 0)).click();
        scrollIntoView(sideBar.elementsSubMenuOption("Date Picker"));
        sideBar.elementsSubMenuOption("Date Picker").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanChooseADate() {
        datePickerPage.clickOnDateSelection();

    }
}
