package Tests.ElementsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTests extends ElementsTestsSetUp {

    @BeforeMethod
    public void webTablesSetUp() {
        scrollIntoView(sideBar.elementsSubMenuOption("Web Tables"));
        sideBar.elementsSubMenuOption("Web Tables").click();
    }

    @Test(priority = 10)
    public void verifyThatUserCanAddPersonToTable() {
        webTablesPage.addPerson.click();
        webTablesPage.insertFirstName(excelReader.getStringData("Web Table", 0, 1));
        webTablesPage.insertLastName(excelReader.getStringData("Web Table", 1, 1));
        webTablesPage.insertEmail(excelReader.getStringData("Web Table", 2, 1));
        webTablesPage.insertAge(excelReader.getStringData("Web Table", 3, 1));
        webTablesPage.insertSalary(excelReader.getStringData("Web Table", 4, 1));
        webTablesPage.insertDepartment(excelReader.getStringData("Web Table", 5, 1));
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.getPersonalData("Andrija").isDisplayed());
        Assert.assertTrue(webTablesPage.getPersonalData("Sarenac").isDisplayed());
        Assert.assertTrue(webTablesPage.getPersonalData("28").isDisplayed());
    }

    @Test(priority = 20)
    public void verifyThatUserCanDeleteAPersonFromTable() {
        verifyThatUserCanAddPersonToTable();
        webTablesPage.clickOnDeleteUser4Symbol();
        Assert.assertFalse(elementIsPresent(webTablesPage.getPersonalData("Andrija")));
        Assert.assertFalse(elementIsPresent(webTablesPage.getPersonalData("Sarenac")));
        Assert.assertFalse(elementIsPresent(webTablesPage.getPersonalData("28")));
    }

    @Test(priority = 30)
    public void verifyThatUserCanEditPerson1Data() {
        webTablesPage.editFirsPerson.click();
        webTablesPage.insertFirstName("Andrija");
        webTablesPage.clickOnSubmitButton();
        Assert.assertTrue(webTablesPage.getPersonalData("Andrija").isDisplayed());
    }
}
