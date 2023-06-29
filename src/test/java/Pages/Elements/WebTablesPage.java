package Pages.Elements;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebElement oneData;

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addPerson;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "delete-record-4")
    public WebElement deleteUser4;

    @FindBy(id = "edit-record-1")
    public WebElement editFirsPerson;

    @FindBy(className = "rt-td")
    public List<WebElement> personData;

    public WebElement getPersonalData(String data) {
        for (WebElement element : personData) {
            if (element.getText().equals(data)) {
                oneData = element;
                break;
            }
        }
        return oneData;
    }

    public void insertFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void insertEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void insertAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void insertSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void insertDepartment(String departmentName) {
        departmentField.clear();
        departmentField.sendKeys(departmentName);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public void clickOnDeleteUser4Symbol() {
        deleteUser4.click();
    }
}
