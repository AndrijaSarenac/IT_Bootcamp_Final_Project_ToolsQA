package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simpleLink")
    public WebElement homePageLink1;

    @FindBy(id = "dynamicLink")
    public WebElement homePageLink2;

    @FindBy(id = "created")
    public WebElement createdLink;

    @FindBy(id = "no-content")
    public WebElement noContentLink;

    @FindBy(id = "moved")
    public WebElement movedLink;

    @FindBy(id = "bad-request")
    public WebElement badRequestLink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedLink;

    @FindBy(id = "forbidden")
    public WebElement forbiddenLink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundLink;

    @FindBy(id = "linkResponse")
    public WebElement responseMessage;

    public void clickOnHomePageLink1() {
        homePageLink1.click();
    }

    public void clickOnHomePageLink2() {
        homePageLink2.click();
    }

    public void clickOnCreatedLink() {
        createdLink.click();
    }

    public void clickOnNoContentLink() {
        noContentLink.click();
    }

    public void clickOnMovedLink() {
        movedLink.click();
    }

    public void clickOnBadRequestLink() {
        badRequestLink.click();
    }

    public void clickOnUnauthorizedLink() {
        unauthorizedLink.click();
    }

    public void clickOnForbiddenLink() {
        forbiddenLink.click();
    }

    public void clickOnNotFoundLink() {
        notFoundLink.click();
    }
}
