package Tests.BookStoreApplicationTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.BookStoreApplication.LoginPage;
import Pages.BookStoreApplication.ProfilePage;
import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsTwo extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public SideBar sideBar;
    public ProfilePage profilePage;

    @BeforeMethod
    public void loginSetUp() {
        homePage = new HomePage();
        sideBar = new SideBar();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.get(homeURL);
        scrollIntoView(homePage.oneCard("Book Store Application"));
        homePage.oneCard("Book Store Application").click();

    }

    @Test(priority = 10)
    public void verifyThatUserCanLogInUsingValidCredentials() {

    }
}
