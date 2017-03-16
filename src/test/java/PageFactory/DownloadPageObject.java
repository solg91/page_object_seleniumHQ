package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 20.02.2017.
 */
public class DownloadPageObject {
    private WebDriver driver;
    @FindBy(id = "menu_download")
    private WebElement downloadTab;
    @FindBy(xpath = "//*[@id='nav']/li/a")
    private WebElement seleniumDownloadsMenu;


    public DownloadPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Get Download Tab link")
    public String getDownloadTabUrl() {
        downloadTab.click();
        return driver.getCurrentUrl();
    }
    @Step("Check if Selenium Downloads Menu is displayed")
    public boolean isSeleniumDownloadsDisplayed() {
        return seleniumDownloadsMenu.isDisplayed();
    }

}
