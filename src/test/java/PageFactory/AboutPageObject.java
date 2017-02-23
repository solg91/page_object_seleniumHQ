package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by solg on 21.02.2017.
 */
public class AboutPageObject {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='nav']/li/a")
    private WebElement aboutSelLeftMenu;
    @FindBy(xpath = "//a[@href='/sponsors']/parent::h3/a[1]")
    private WebElement sponsorsLink;


    public AboutPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAboutSelLeftMenuDisplayed() {
        return aboutSelLeftMenu.isDisplayed();
    }

    public boolean isSponsorsLinkDisplayed() {
        return sponsorsLink.isDisplayed();
    }

    public String clickSponsorsLink() {
        sponsorsLink.click();
        return driver.getCurrentUrl();
    }
}
