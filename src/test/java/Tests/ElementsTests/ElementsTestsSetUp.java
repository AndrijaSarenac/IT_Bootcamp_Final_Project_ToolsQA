package Tests.ElementsTests;

import Base.BaseTest;
import Base.SideBar;
import Pages.Elements.*;
import Pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ElementsTestsSetUp extends BaseTest {

    public HomePage homePage;
    public ElementsPage elementsPage;
    public SideBar sideBar;
    public TextBoxPage textBoxPage;
    public RadioButtonPage radioButtonPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksImagesPage brokenLinksImagesPage;
    public UploadAndDownloadPage uploadAndDownloadPage;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public WebTablesPage webTablesPage;
    public CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        sideBar = new SideBar();
        textBoxPage = new TextBoxPage();
        radioButtonPage = new RadioButtonPage();
        buttonsPage = new ButtonsPage();
        linksPage = new LinksPage();
        checkBoxPage = new CheckBoxPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
        webTablesPage = new WebTablesPage();
        driver.get(homeURL);
        homePage.oneCard(excelReader.getStringData("Cards", 1, 0)).click();
    }

    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }
}
