package Tests.BookStoreApplicationTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.BookStoreApplication.LoginPage;
import Pages.BookStoreApplication.ProfilePage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public SideBar sideBar;
    public ProfilePage profilePage;

    @BeforeMethod
    public void loginSetUp() throws InterruptedException {
        homePage = new HomePage();
        sideBar = new SideBar();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.get(homeURL);
        scrollIntoView(homePage.oneCard("Book Store Application"));
        homePage.oneCard("Book Store Application").click();
        scrollIntoView(sideBar.elementsSubMenuOption("Login"));
        sideBar.elementsSubMenuOption("Login").click();
        Thread.sleep(1000);
    }

    @Test(priority = 10)
    public void verifyThatUserCanLogInUsingValidCredentials() {
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 0));
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 1));
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), excelReader.getStringData("URL", 3, 1));
        waitForVisibility(profilePage.usernameConfirmation);
        Assert.assertEquals(profilePage.usernameConfirmation.getText(), excelReader.getStringData("Credentials", 1, 0));
        Assert.assertTrue(profilePage.getButton("Log out").isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatUserCannotLoginWithInvalidUsername() {
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 2));
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 1));
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.failureMessage);
        scrollIntoView(loginPage.failureMessage);
        Assert.assertEquals(loginPage.failureMessage.getText(), "Invalid username or password!");
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @Test(priority = 30)
    public void verifyThatUserCannotLoginWithInvalidPassword() {
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 0));
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 3));
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.failureMessage);
        scrollIntoView(loginPage.failureMessage);
        Assert.assertEquals(loginPage.failureMessage.getText(), "Invalid username or password!");
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @Test(priority = 40)
    public void verifyThatUserCannotLoginWithInvalidPasswordAndInvalidUsername() {
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 2));
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 3));
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.failureMessage);
        scrollIntoView(loginPage.failureMessage);
        Assert.assertEquals(loginPage.failureMessage.getText(), "Invalid username or password!");
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @Test(priority = 50)
    public void verifyThatUserCannotLoginWithoutUsername() {
        loginPage.insertUsername("");
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 1));
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @Test(priority = 60)
    public void verifyThatUserCannotLoginWithoutPassword() {
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 0));
        loginPage.insertPassword("");
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @Test(priority = 70)
    public void verifyThatUserCannotLoginWithoutPasswordAndWithoutUsername() {
        loginPage.insertUsername("");
        loginPage.insertPassword("");
        loginPage.clickOnLoginButton();
        waitForVisibility(loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        Assert.assertFalse(elementIsPresent(profilePage.getButton("Log out")));
    }

    @AfterMethod
    public void logOutWithCookies() {
        //driver.manage().deleteAllCookies();
        //driver.navigate().refresh();
    }
}
