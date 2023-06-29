package Pages.Interactions;

import Base.BaseTest;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SortablePage extends BaseTest {

    public WebElement oneSortableElement;
    public WebElement oneSortableGridElement;

    public SortablePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".list-group-item.list-group-item-action")
    public List<WebElement> sortableElements;

    public WebElement getOneSortableElement(String elementName) {
        for (WebElement element : sortableElements) {
            if (element.getText().equals(elementName)) {
                oneSortableElement = element;
                break;
            }
        }
        return oneSortableElement;
    }

    public List<Point> points;

    public void makeListOfPoints() {
        for (WebElement element : sortableElements) {
            points.add(element.getLocation());
        }
    }

    public Point getOneElementPoint(WebElement element) {
        Point point1 = new Point(1, 1);
        for (WebElement element1 : sortableElements) {
            if (element1.equals(element)) {
                point1 = element1.getLocation();
                break;
            }
        }
        return point1;
    }

    @FindBy(id = "demo-tab-grid")
    public WebElement gridTab;

    public void clickOnGridTab() {
        gridTab.click();
    }

    @FindBy(css = ".list-group-item.list-group-item-action")
    public List<WebElement> sortableGridElements;

    public WebElement getOneSortableGridElement(String elementName) {
        for (WebElement element : sortableGridElements) {
            if (element.getText().equals(elementName)) {
                oneSortableGridElement = element;
                break;
            }
        }
        return oneSortableGridElement;
    }

    public List<Point> gridPoints;

    public void makeListOfGridPoints() {
        for (WebElement element : sortableElements) {
            gridPoints.add(element.getLocation());
        }
    }

    public Point getOneGridElementPoint(WebElement element) {
        Point point1 = new Point(1, 1);
        for (WebElement element1 : sortableElements) {
            if (element1.equals(element)) {
                point1 = element1.getLocation();
                break;
            }
        }
        return point1;
    }
}
