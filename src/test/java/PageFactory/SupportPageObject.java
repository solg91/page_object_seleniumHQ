package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 21.02.2017.
 */
public class SupportPageObject {
    private WebDriver driver;
    @FindBy(xpath = "//*[@class='note']/preceding-sibling::p/a")
    private WebElement officialUserGroupLink;
    @FindBy(xpath = "//*[@id='mainContent']/h1")
    private WebElement gettingHelp;

    public SupportPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Check if Getting Help Label is displayed")
    public boolean isGettingHelpLabelDisplayed() {
        return gettingHelp.isDisplayed();
    }
    @Step("Check if Official User Group is displayed")
    public boolean isOfficialUserGroupLinkDisplayed() {
        return officialUserGroupLink.isDisplayed();
    }
    @Step("Get official User Group Link")
    public String getOfficialUserGroupLink() {
        return officialUserGroupLink.getAttribute("href");
    }

}
