package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void checkBoxSetUp() {
        sideBar.elementsSubMenuOption("Check Box").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanCheckAllTheBoxes() {
        checkBoxPage.checkAllBoxes();
        for (int i = 1; i < excelReader.getLastRow("Check Boxes"); i++) {
            Assert.assertTrue(checkBoxPage.resultText.getText().contains(excelReader.getStringData("Check Boxes", i, 0)));
        }
    }


}
