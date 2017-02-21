import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by solg on 21.02.2017.
 */
public class AboutPageObject {
    private WebDriver driver;
    By aboutSelLeftMenu = By.xpath("//*[@id='nav']/li/a");
    By sponsorsLink = By.xpath("//a[@href='/sponsors']/parent::h3/a[1]");



    public AboutPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAboutSelLeftMenuDisplayed(){
        return driver.findElement(aboutSelLeftMenu).isDisplayed();
    }
    public boolean isSponsorsLinkDisplayed(){
        return driver.findElement(sponsorsLink).isDisplayed();
    }

    public String clickSponsorsLink(){
        driver.findElement(sponsorsLink).click();
        return driver.getCurrentUrl();
    }
}
