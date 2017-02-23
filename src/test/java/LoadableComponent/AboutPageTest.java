package LoadableComponent;

import PageFactory.ProjectsPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertTrue;

/**
 * Created by solg on 23.02.2017.
 */
public class AboutPageTest {
    private WebDriver driver;
    AboutPageObject aboutPageObject;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

  private AboutPageObject openAboutPage() {
       return new AboutPageObject(driver).get();
   }

    @Test
    public void newsBlogSeleniumBlogLinkIsCorrect() {
        aboutPageObject = openAboutPage();
        NewsBlogPageObject newsBlogPageObject = aboutPageObject.clickNewsBlogLink();
        assertThat(newsBlogPageObject.getBlogLink(),is("http://seleniumhq.wordpress.com/"));
    }

    @Test
    public void seleniumEventTodayButtonIsDisplayed() {
        aboutPageObject = openAboutPage();
        SeleniumEventsPageObject seleniumEvents = aboutPageObject.clickSeleniumEventsLink();
        assertTrue(seleniumEvents.isTodayButtonDisplayed());
    }

    @Test
    public void seleniumEventSeleniumLabelIsDisplayed() {
        aboutPageObject = openAboutPage();
        SeleniumEventsPageObject seleniumEvents = aboutPageObject.clickSeleniumEventsLink();
        assertTrue(seleniumEvents.isSeleniumLabelDisplayed());
    }

}

