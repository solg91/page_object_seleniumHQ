import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by solg on 20.02.2017.
 */
public class ProjectsPageObject {
    private WebDriver driver;
    By seleniumLogo = By.xpath("//img[@src='/images/selenium-logo.png']");
    By projectsTitle = By.xpath("//*[@id='mainContent']/h2");

    public ProjectsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSeleniumLogoDisplay() {
        return driver.findElement(seleniumLogo).isDisplayed();
    }

    public String getProjectsTitle() {
        return driver.findElement(projectsTitle).getText();
    }

}
