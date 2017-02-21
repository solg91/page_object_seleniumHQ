import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by solg on 20.02.2017.
 */
public class MainPageObject {

    private WebDriver driver;

    By projectsTab = By.xpath("//li[@id='menu_projects']/a");
    By downloadTab = By.id("menu_download");
    By documentTab = By.xpath("//*[@title='Technical references and guides']");
    By supportTab = By.linkText("Support");
    By aboutTab = By.linkText("About");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public ProjectsPageObject clickProjectTab() {
        driver.findElement(projectsTab).click();
        return new ProjectsPageObject(driver);
    }

    public DownloadPageObject clickDownloadTab() {
        driver.findElement(downloadTab).click();
        return new DownloadPageObject(driver);
    }
    public DocumentationPageObject clickDocumentationTab() {
        driver.findElement(documentTab).click();
        return new DocumentationPageObject(driver);
    }
    public SupportPageObject clickSupportTab() {
        driver.findElement(supportTab).click();
        return new SupportPageObject(driver);
    }
    public AboutPageObject clickAboutTab() {
        driver.findElement(aboutTab).click();
        return new AboutPageObject(driver);
    }
}
