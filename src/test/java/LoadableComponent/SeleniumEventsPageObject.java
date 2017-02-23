package LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by solg on 23.02.2017.
 */
public class SeleniumEventsPageObject extends LoadableComponent<SeleniumEventsPageObject> {

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

    @Override
    protected void load() {


    }
    @Override
    protected void isLoaded() throws Error {
        assertThat(driver.getCurrentUrl(), is("http://www.seleniumhq.org/about/events.jsp"));
    }
}
