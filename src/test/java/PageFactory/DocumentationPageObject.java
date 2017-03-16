package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 20.02.2017.
 */
public class DocumentationPageObject {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id='side']//li[1]/a")
    private WebElement seleniumDocLink;

    @FindBy(xpath = "//*[@id='codeLanguagePreference']")
    private WebElement codeLanPreferenceBlock;

    @FindBy(xpath = "//p[@class='topless']/a")
    private WebElement nextTopic;


    public DocumentationPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @Step("Check if Code Language Preferences are displayed")
    public boolean isCodeLanguagePreferencesDisplayed() {
        return codeLanPreferenceBlock.isDisplayed();
    }

    @Step("Get Next Topic Text")
    public String getNextTopicText() {
        return nextTopic.getText();
    }


}
