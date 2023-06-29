package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public WebElement cardOption;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".card.mt-4.top-card")
    public List<WebElement> cards;

    @FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
    public WebElement logo;

    @FindBy(className = "banner-image")
    public WebElement banner;

    @FindBy(xpath = "//*[@id=\"app\"]/footer/span")
    public WebElement footer;

    public WebElement oneCard(String cardName) {
        for (WebElement card : cards) {
            if (card.getText().equals(cardName)) {
                cardOption = card;
                break;
            }
        }
        return cardOption;
    }
}
