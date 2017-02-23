package PageFactory;

import PageFactory.*;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertTrue;

/**
 * Created by solg on 20.02.2017.
 */
public class SeleniumHQTest {
    private WebDriver driver;
    private MainPageObject mainPage;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = openSeleniumHqPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    private MainPageObject openSeleniumHqPage() {
        driver.get("http://www.seleniumhq.org/");
        return new MainPageObject(driver);
    }

    @Test
    public void projectLogoIsDisplayed() {
        ProjectsPageObject projectTab = mainPage.clickProjectTab();
        assertTrue(projectTab.isSeleniumLogoDisplay());
    }

    @Test
    public void projectTabTitleIsDisplayed(){
        ProjectsPageObject projectTab = mainPage.clickProjectTab();
        assertThat(projectTab.getProjectsTitle(), is("Selenium Projects"));
    }

    @Test
    public void downloadTabCurrentUrlIsTrue(){
       DownloadPageObject downloadTab = mainPage.clickDownloadTab();
        assertThat(downloadTab.getDownloadTabUrl(), is("http://www.seleniumhq.org/download/"));
    }

    @Test
    public void seleniumDownloadsMenuIsDisplayed() {
        DownloadPageObject downloadTab = mainPage.clickDownloadTab();
        assertTrue(downloadTab.isSeleniumDownloadsDisplayed());
    }

    @Test
    public void docTabLanguagesPreferenceIsDisplayed() {
        DocumentationPageObject docTab = mainPage.clickDocumentationTab();
        assertTrue(docTab.isCodeLanguagePreferencesDisplayed());
    }

    @Test
    public void docTabNextTopicTextByDefault() {
        DocumentationPageObject docTab = mainPage.clickDocumentationTab();
        assertThat(docTab.getNextTopicText(), is("Note to the Reader - Docs Being Revised for Selenium 2.0!"));
    }

    @Test
    public void supportTabGettingHelpIsDisplayed() {
        SupportPageObject supportTab = mainPage.clickSupportTab();
        assertTrue(supportTab.isGettingHelpLabelDisplayed());
    }

    @Test
    public void supportTabOfficialUserLinkIsDisplayed() {
        SupportPageObject supportTab = mainPage.clickSupportTab();
        assertTrue(supportTab.isOfficialUserGroupLinkDisplayed());
    }

    @Test
    public void supportTabOfficialUserLinkIsCorrect() {
        SupportPageObject supportTab = mainPage.clickSupportTab();
        MatcherAssert.assertThat(supportTab.getOfficialUserGroupLink(), is("http://groups.google.com/group/selenium-users"));
    }

    @Test
    public void aboutTabAboutSelLeftMenuIsDisplayed() {
        AboutPageObject aboutTab = mainPage.clickAboutTab();
        assertTrue(aboutTab.isAboutSelLeftMenuDisplayed());
    }
    @Test
    public void aboutTabSponsorsLinkIsDisplayed() {
        AboutPageObject aboutTab = mainPage.clickAboutTab();
        assertTrue(aboutTab.isSponsorsLinkDisplayed());
    }

    @Test
    public void aboutTabGoToSponsorsPage() {
        AboutPageObject aboutTab = mainPage.clickAboutTab();
        assertThat(aboutTab.clickSponsorsLink(), is("http://www.seleniumhq.org/sponsors/"));
    }

}