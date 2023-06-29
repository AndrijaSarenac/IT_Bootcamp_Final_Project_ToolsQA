package Pages.BookStoreApplication;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookStorePage extends BaseTest {

    public BookStorePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"addNewRecordButton\"]")
    public WebElement backToBookStoreButton;

    @FindBy(css = ".text-right.fullButton")
    public WebElement addToCollectionButton;

    @FindBy(id = "see-book-Git Pocket Guide")
    public WebElement gitPocketGuide;

    @FindBy(id = "see-book-Learning JavaScript Design Patterns")
    public WebElement javaScriptDesignPatterns;

    @FindBy(id = "see-book-Designing Evolvable Web APIs with ASP.NET")
    public WebElement designingEvolvableWebApIsWithAspNet
            ;

    @FindBy(id = "see-book-Speaking JavaScript")
    public WebElement speakingJavaScript;

    @FindBy(id = "see-book-You Don't Know JS")
    public WebElement youDonTKnowJs;

    @FindBy(id = "see-book-Programming JavaScript Applications")
    public WebElement programmingJavaScriptApplications;

    @FindBy(id = "see-book-Eloquent JavaScript, Second Edition")
    public WebElement eloquentJavaScriptSecondEdition;

    @FindBy(id = "see-book-Understanding ECMAScript 6")
    public WebElement understandingEcmaScript6;

    public void addFirstBook() {
        waitForClickability(gitPocketGuide);
        gitPocketGuide.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addSecondBook() {
        waitForClickability(javaScriptDesignPatterns);
        javaScriptDesignPatterns.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addThirdBook() {
        waitForClickability(designingEvolvableWebApIsWithAspNet);
        scrollIntoView(designingEvolvableWebApIsWithAspNet);
        designingEvolvableWebApIsWithAspNet.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addFourthBook() {
        waitForClickability(speakingJavaScript);
        scrollIntoView(speakingJavaScript);
        speakingJavaScript.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addFifthBook() {
        waitForClickability(youDonTKnowJs);
        scrollIntoView(youDonTKnowJs);
        youDonTKnowJs.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addSixthBook() {
        waitForClickability(programmingJavaScriptApplications);
        scrollIntoView(programmingJavaScriptApplications);
        programmingJavaScriptApplications.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addSeventhBook() {
        waitForClickability(eloquentJavaScriptSecondEdition);
        scrollIntoView(eloquentJavaScriptSecondEdition);
        eloquentJavaScriptSecondEdition.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void addEightBook() {
        waitForClickability(understandingEcmaScript6);
        scrollIntoView(understandingEcmaScript6);
        understandingEcmaScript6.click();
        scrollIntoView(addToCollectionButton);
        waitForClickability(addToCollectionButton);
        addToCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void backToBookStore() throws InterruptedException {
        Thread.sleep(3000);
        waitForClickability(backToBookStoreButton);
        backToBookStoreButton.click();
    }

    public void clickOnFirstBook() {
        waitForClickability(gitPocketGuide);
        gitPocketGuide.click();
    }

    public void clickOnSecondBook() {
        waitForClickability(javaScriptDesignPatterns);
        javaScriptDesignPatterns.click();
    }

    public void clickOnThirdBook() {
        waitForClickability(designingEvolvableWebApIsWithAspNet);
        designingEvolvableWebApIsWithAspNet.click();
    }

    public void clickOnFourthBook() {
        waitForClickability(speakingJavaScript);
        speakingJavaScript.click();
    }

    public void clickOnFifthBook() {
        waitForClickability(youDonTKnowJs);
        youDonTKnowJs.click();
    }

    public void clickOnSixthBook() {
        waitForClickability(programmingJavaScriptApplications);
        programmingJavaScriptApplications.click();
    }

    public void clickOnSeventhBook() {
        waitForClickability(eloquentJavaScriptSecondEdition);
        eloquentJavaScriptSecondEdition.click();
    }

    public void clickOnEightBook() {
        waitForClickability(understandingEcmaScript6);
        understandingEcmaScript6.click();
    }
}
