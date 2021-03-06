package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 20.02.2017.
 */
public class MainPageObject {

    private WebDriver driver;

    @FindBy(xpath = "//li[@id='menu_projects']/a")
    private WebElement projectsTab;

    @FindBy(id = "menu_download")
    private WebElement downloadTab;

    @FindBy(xpath = "//*[@title='Technical references and guides']")
    private WebElement documentTab;

    @FindBy(linkText = "Support")
    private WebElement supportTab;

    @FindBy(linkText = "About")
    private WebElement aboutTab;

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Click on Project tab")
    public ProjectsPageObject clickProjectTab() {
        projectsTab.click();
        return new ProjectsPageObject(driver);
    }
    @Step("Click on Downloads tab")
    public DownloadPageObject clickDownloadTab() {
        downloadTab.click();
        return new DownloadPageObject(driver);
    }
    @Step("Click on Documentation tab")
    public DocumentationPageObject clickDocumentationTab() {
        documentTab.click();
        return new DocumentationPageObject(driver);
    }
    @Step("Click on Support tab")
    public SupportPageObject clickSupportTab() {
        supportTab.click();
        return new SupportPageObject(driver);
    }
    @Step("Click on About tab")
    public AboutPageObjectFactory clickAboutTab() {
        aboutTab.click();
        return new AboutPageObjectFactory(driver);
    }
}
