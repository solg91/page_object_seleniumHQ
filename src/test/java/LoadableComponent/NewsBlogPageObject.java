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
public class NewsBlogPageObject{
    private WebDriver driver;

    @FindBy(xpath ="//*[@id='mainContent']/a[1]")
    private WebElement seleniumBlog;

    public NewsBlogPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getBlogLink() {
        return seleniumBlog.getAttribute("href");
    }



}
