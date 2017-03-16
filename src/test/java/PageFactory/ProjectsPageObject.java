package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 20.02.2017.
 */
public class ProjectsPageObject {
    private WebDriver driver;
    @FindBy(xpath = "//img[@src='/images/selenium-logo.png']")
    private WebElement seleniumLogo;
    @FindBy(xpath = "//*[@id='mainContent']/h2")
    private WebElement projectsTitle;

    public ProjectsPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Check if Selenium Logo is displayed")
    public boolean isSeleniumLogoDisplay() {
        return seleniumLogo.isDisplayed();
    }
    @Step("Get Project Title")
    public String getProjectsTitle() {
        return projectsTitle.getText();
    }

}
