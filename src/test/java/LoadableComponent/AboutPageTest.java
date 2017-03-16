package LoadableComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertTrue;

/**
 * Created by solg on 23.02.2017.
 */

@Listeners (MyListener.class)
@Description("In this cool suite we will test only cool features")
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
    public WebDriver getDriver(){
        return driver;
    }
    @Title("Selenium blog is opened")
    @Description("In this cool test we will test only blog open")
    @Test
    public void seleniumBlogLinkIsCorrect() {
        aboutPageObject = openAboutPage();
        NewsBlogPageObject newsBlogPageObject = aboutPageObject.clickNewsBlogLink();
     //   aboutPageObject.makeScreenshot();
        assertThat(newsBlogPageObject.getBlogLink(),is("http://seleniumhq.wordpress.com44/"));
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

