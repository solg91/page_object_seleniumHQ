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
public class AboutPageObject extends LoadableComponent<AboutPageObject> {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='news.jsp']")
    private WebElement newsBlog;

    @FindBy(xpath = "//a[text()='Selenium Events']")
    private WebElement events;

    @FindBy(xpath = "//a[text()='Get involved']")
    private WebElement getInvolved;

    public AboutPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NewsBlogPageObject clickNewsBlogLink() {
        newsBlog.click();
        return new NewsBlogPageObject(driver);
    }

    public SeleniumEventsPageObject clickSeleniumEventsLink() {
        events.click();
        return new SeleniumEventsPageObject(driver);
    }
    @Override
    protected void load() {
        driver.get("http://www.seleniumhq.org/about/");

    }
    @Override
    protected void isLoaded() throws Error {
       assertThat(driver.getCurrentUrl(), is("http://www.seleniumhq.org/about/"));
    }
}
