package Pages.Widgets;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BaseTest {

    public SliderPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/input")
    public WebElement slider;

    public void moveSliderUp (int slideValue) {
        for (int i = 1; i <= slideValue ; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public void moveSliderDown (int slideValue) {
        for (int i = 1; i <= slideValue; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
    }
}


