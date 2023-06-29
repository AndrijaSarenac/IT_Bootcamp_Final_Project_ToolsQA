package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void textBoxSetUp() {
        sideBar.elementsSubMenuOption("Text Box").click();
    }

    @Test(priority = 10)
    public void verifyTextBoxSubmission() {
        textBoxPage.insertFullName(excelReader.getStringData("Text Box", 1, 0));
        textBoxPage.insertEmail(excelReader.getStringData("Text Box", 1, 1));
        textBoxPage.insertCurrentAddress(excelReader.getStringData("Text Box", 1, 2));
        textBoxPage.insertPermanentAddress(excelReader.getStringData("Text Box", 1, 3));
        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();
        Assert.assertEquals(textBoxPage.nameConfirm.getText(), "Name:" + excelReader.getStringData("Text Box", 1, 0));
        Assert.assertEquals(textBoxPage.emailConfirm.getText(), "Email:" + excelReader.getStringData("Text Box", 1, 1));
        Assert.assertEquals(textBoxPage.currentAddressConfirm.getText(), "Current Address :" + excelReader.getStringData("Text Box", 1, 2));
        Assert.assertEquals(textBoxPage.permanentAddressConfirm.getText(), "Permananet Address :" + excelReader.getStringData("Text Box", 1, 3));
    }

    @Test(priority = 20)
    public void verifyThatUserCannotSubmitZeroData() {
        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();
        Assert.assertFalse(elementIsPresent(textBoxPage.nameConfirm));
        Assert.assertFalse(elementIsPresent(textBoxPage.emailConfirm));
        Assert.assertFalse(elementIsPresent(textBoxPage.currentAddressConfirm));
        Assert.assertFalse(elementIsPresent(textBoxPage.permanentAddressConfirm));
    }

    @Test(priority = 30)
    public void verifyThatUserCanSubmitJustFullName() {
        textBoxPage.insertFullName(excelReader.getStringData("Text Box", 1, 0));
        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();
        Assert.assertEquals(textBoxPage.nameConfirm.getText(), "Name:" + excelReader.getStringData("Text Box", 1, 0));
        Assert.assertFalse(elementIsPresent(textBoxPage.emailConfirm));
        Assert.assertFalse(elementIsPresent(textBoxPage.currentAddressConfirm));
        Assert.assertFalse(elementIsPresent(textBoxPage.permanentAddressConfirm));
    }

    @Test(priority = 40)
    public void verifyThatUserCanSubmitJustNameAndEmail() {
        textBoxPage.insertFullName(excelReader.getStringData("Text Box", 1, 0));
        textBoxPage.insertEmail(excelReader.getStringData("Text Box", 1, 1));
        scrollIntoView(textBoxPage.submitButton);
        textBoxPage.clickSubmitButton();
        Assert.assertEquals(textBoxPage.nameConfirm.getText(), "Name:" + excelReader.getStringData("Text Box", 1, 0));
        Assert.assertEquals(textBoxPage.emailConfirm.getText(), "Email:" + excelReader.getStringData("Text Box", 1, 1));

    }
}
