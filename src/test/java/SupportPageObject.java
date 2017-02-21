import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by solg on 21.02.2017.
 */
public class SupportPageObject {
    private WebDriver driver;
    By officialUserGroupLink = By.xpath("//*[@class='note']/preceding-sibling::p/a");
    By gettingHelp = By.xpath("//*[@id='mainContent']/h1");

    public SupportPageObject (WebDriver driver) {
        this.driver = driver;
    }
    public boolean isGettingHelpLabelDisplayed(){
        return driver.findElement(gettingHelp).isDisplayed();
    }

    public boolean isOfficialUserGroupLinkDisplayed(){
        return driver.findElement(officialUserGroupLink).isDisplayed();
    }

    public String getOfficialUserGroupLink(){
        return driver.findElement(officialUserGroupLink).getAttribute("href");
    }

}
