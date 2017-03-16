package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 21.02.2017.
 */
public class AboutPageObjectFactory {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='nav']/li/a")
    private WebElement aboutSelLeftMenu;
    @FindBy(xpath = "//a[@href='/sponsors']/parent::h3/a[1]")
    private WebElement sponsorsLink;


    public AboutPageObjectFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step ("Check if About menu is displayed")
    public boolean isAboutSelLeftMenuDisplayed() {
        return aboutSelLeftMenu.isDisplayed();
    }
    @Step ("Check if Sponsors Link is displayed")
    public boolean isSponsorsLinkDisplayed() {
        return sponsorsLink.isDisplayed();
    }
    @Step ("Get Sponsors Link")
    public String clickSponsorsLink() {
        sponsorsLink.click();
        return driver.getCurrentUrl();
    }
}
