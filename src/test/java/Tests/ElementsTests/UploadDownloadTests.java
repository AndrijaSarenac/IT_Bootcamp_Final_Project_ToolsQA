package Tests.ElementsTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadDownloadTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void uploadDownloadSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Upload and Download"));
        sideBar.elementsSubMenuOption("Upload and Download").click();
    }

    @Test(priority = 10)
    public void verifyDownload() {
        uploadAndDownloadPage.clickOnDownloadButton();

    }
}
