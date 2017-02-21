import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by solg on 20.02.2017.
 */
public class DownloadPageObject {
    private WebDriver driver;
    By downloadTab = By.id("menu_download");
    By seleniumDownloadsMenu = By.xpath("//*[@id='nav']/li/a");


    public DownloadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getDownloadTabUrl(){
        driver.findElement(downloadTab).click();
        return driver.getCurrentUrl();
    }

    public boolean isSeleniumDownloadsDisplayed(){
        return driver.findElement(seleniumDownloadsMenu).isDisplayed();
    }

}
