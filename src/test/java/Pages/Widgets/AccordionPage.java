package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccordionPage extends BaseTest {

    public AccordionPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "section1Heading")
    public WebElement firstCard;

    @FindBy(id = "section2Heading")
    public WebElement secondCard;

    @FindBy(id = "section3Heading")
    public WebElement thirdCard;

    @FindBy(id = "section1Content")
    public WebElement sectionOneContent;

    @FindBy(id = "section2Content")
    public WebElement sectionTwoContent;

    @FindBy(id = "section3Content")
    public WebElement sectionThreeContent;

    public void clickOnFirstCard() {
        firstCard.click();
    }

    public void clickOnSecondCard() {
        secondCard.click();
    }

    public void clickOnThirdCard() {
        thirdCard.click();
    }
}
