package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage extends BaseTest {

    public UploadAndDownloadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    @FindBy(id = "uploadFile")
    public WebElement uploadFileButton;

    public void clickOnDownloadButton() {
        downloadButton.click();
    }

    public void clickOnUploadButton() {
        uploadFileButton.click();
    }
}
