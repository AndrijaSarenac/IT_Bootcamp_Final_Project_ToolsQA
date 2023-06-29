package Tests.BookStoreApplicationTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.BookStoreApplication.BookStorePage;
import Pages.BookStoreApplication.LoginPage;
import Pages.BookStoreApplication.ProfilePage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests extends BaseTest {

    public HomePage homePage;
    public SideBar sideBar;
    public BookStorePage bookStorePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void bookStoreSetUp() throws InterruptedException {
        homePage = new HomePage();
        sideBar = new SideBar();
        bookStorePage = new BookStorePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        driver.get(homeURL);
        scrollIntoView(homePage.oneCard("Book Store Application"));
        homePage.oneCard("Book Store Application").click();
        scrollIntoView(sideBar.elementsSubMenuOption("Login"));
        sideBar.elementsSubMenuOption("Login").click();
        loginPage.insertUsername(excelReader.getStringData("Credentials", 1, 0));
        loginPage.insertPassword(excelReader.getStringData("Credentials", 1, 1));
        loginPage.clickOnLoginButton();
        Thread.sleep(1000);
        scrollIntoView(sideBar.elementsSubMenuOption("Book Store"));
        sideBar.elementsSubMenuOption("Book Store").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanAddOneBook() {
        bookStorePage.addFirstBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatUserCanAddTwoBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
    }

    @Test(priority = 30)
    public void verifyThatUserCanAddThreeBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
    }

    @Test(priority = 40)
    public void verifyThatUserCanAddFourBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFourthBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
        Assert.assertTrue(bookStorePage.speakingJavaScript.isDisplayed());
    }

    @Test(priority = 50)
    public void verifyThatUserCanAddFiveBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFourthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFifthBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
        Assert.assertTrue(bookStorePage.speakingJavaScript.isDisplayed());
        Assert.assertTrue(bookStorePage.youDonTKnowJs.isDisplayed());
    }

    @Test(priority = 60)
    public void verifyThatUserCanAddSixBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFourthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFifthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSixthBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
        Assert.assertTrue(bookStorePage.speakingJavaScript.isDisplayed());
        Assert.assertTrue(bookStorePage.youDonTKnowJs.isDisplayed());
        scrollIntoView(profilePage.nexPage);
        profilePage.nexPage.click();
        Assert.assertTrue(bookStorePage.programmingJavaScriptApplications.isDisplayed());
    }

    @Test(priority = 70)
    public void verifyThatUserCanAddSevenBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFourthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFifthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSixthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSeventhBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
        Assert.assertTrue(bookStorePage.speakingJavaScript.isDisplayed());
        Assert.assertTrue(bookStorePage.youDonTKnowJs.isDisplayed());
        scrollIntoView(profilePage.nexPage);
        profilePage.nexPage.click();
        Assert.assertTrue(bookStorePage.programmingJavaScriptApplications.isDisplayed());
        Assert.assertTrue(bookStorePage.eloquentJavaScriptSecondEdition.isDisplayed());
    }

    @Test(priority = 80)
    public void verifyThatUserCanAddEightBooks() throws InterruptedException {
        bookStorePage.addFirstBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSecondBook();
        bookStorePage.backToBookStore();
        bookStorePage.addThirdBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFourthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addFifthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSixthBook();
        bookStorePage.backToBookStore();
        bookStorePage.addSeventhBook();
        bookStorePage.backToBookStore();
        bookStorePage.addEightBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        Assert.assertTrue(bookStorePage.gitPocketGuide.isDisplayed());
        Assert.assertTrue(profilePage.removeBookSymbol.isDisplayed());
        Assert.assertTrue(bookStorePage.javaScriptDesignPatterns.isDisplayed());
        Assert.assertTrue(bookStorePage.designingEvolvableWebApIsWithAspNet.isDisplayed());
        Assert.assertTrue(bookStorePage.speakingJavaScript.isDisplayed());
        Assert.assertTrue(bookStorePage.youDonTKnowJs.isDisplayed());
        scrollIntoView(profilePage.nexPage);
        profilePage.nexPage.click();
        Assert.assertTrue(bookStorePage.programmingJavaScriptApplications.isDisplayed());
        Assert.assertTrue(bookStorePage.eloquentJavaScriptSecondEdition.isDisplayed());
        Assert.assertTrue(bookStorePage.understandingEcmaScript6.isDisplayed());
    }

    @Test(priority = 90)
    public void verifyThatUserCanDeleteABookFromProfile() {
        bookStorePage.addFirstBook();
        sideBar.elementsSubMenuOption("Profile").click();
        waitForVisibility(bookStorePage.gitPocketGuide);
        profilePage.deleteOneBook();
        Assert.assertFalse(elementIsPresent(bookStorePage.gitPocketGuide));
        Assert.assertFalse(elementIsPresent(profilePage.removeBookSymbol));
    }

    @AfterMethod
    public void bookStoreTearDown() {
        //driver.manage().deleteAllCookies();
        //driver.navigate().refresh();
    }
}
