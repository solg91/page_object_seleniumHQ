package LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by solg on 23.02.2017.
 */
public class SeleniumEventsPageObject {

    private WebDriver driver;
    @FindBy(id ="todayButton1")
    private WebElement todayButton1;
    @FindBy(xpath ="//*[@id='mainContent']/h2[1]")
    private WebElement seleniumLabel;


    public SeleniumEventsPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isTodayButtonDisplayed() {

        driver.switchTo().frame(0);
        boolean result = todayButton1.isDisplayed();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isSeleniumLabelDisplayed() {
        return seleniumLabel.isDisplayed();
    }

}
