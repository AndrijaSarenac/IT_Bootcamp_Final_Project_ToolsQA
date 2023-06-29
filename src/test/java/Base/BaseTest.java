package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class BaseTest {

    public static WebDriver driver;
    public static Actions actions;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
        homeURL = excelReader.getStringData("URL", 1, 0);
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForURL(String URL) {
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean elementIsPresent(WebElement element) {
        boolean nonExistingElement = false;
        try {
            nonExistingElement = element.isDisplayed();
        } catch (Exception ignored) {
        }
        return nonExistingElement;
    }

    public boolean alertIsPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public boolean newTabIsPresent() {
        try {
            ArrayList<String> listOfTabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(listOfTabs.get(1));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean newWindowIsPresent() {
        Point currentPosition = driver.manage().window().getPosition();
        try {
            ArrayList<String> listOfWindows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(listOfWindows.get(1));
            Point newPosition = driver.manage().window().getPosition();
            if (!newPosition.equals(currentPosition)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void openNewTab() {
        js.executeScript("window.open()");
    }

    public void doubleClickOnElement(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClickOnElement(WebElement element) {
        actions.contextClick(element).perform();
    }

    public void javaScriptClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    @FindBy(className = "main-header")
    public static WebElement pageName;

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
