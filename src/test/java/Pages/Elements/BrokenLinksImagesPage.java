package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenLinksImagesPage extends BaseTest {

    public BrokenLinksImagesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[1]")
    public WebElement validImage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/img[2]")
    public WebElement brokenImage;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement validLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a[2]")
    public WebElement brokenLink;

    public void clickOnValidLink() {
        validLink.click();
    }

    public void clickOnBrokenLink() {
        brokenLink.click();
    }
}
