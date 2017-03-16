package LoadableComponent;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

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
    public WebDriver getDriver(){
        return driver;
    }
    @Step  ("News Blog link click")
    public NewsBlogPageObject clickNewsBlogLink() {
        newsBlog.click();
        return new NewsBlogPageObject(driver).get();
    }
    @Step  ("Selenium Events link click")
    public SeleniumEventsPageObject clickSeleniumEventsLink() {
        events.click();
        return new SeleniumEventsPageObject(driver).get();
    }
    @Override
    protected void load() {
        driver.get("http://www.seleniumhq.org/about/");

    }
    @Override
    protected void isLoaded() throws Error {
       assertThat(driver.getCurrentUrl(), is("http://www.seleniumhq.org/about/"));
    }

    @Attachment
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
