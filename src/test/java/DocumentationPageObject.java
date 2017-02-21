import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by solg on 20.02.2017.
 */
public class DocumentationPageObject {
    private WebDriver driver;
    By seleniumDocLink = By.xpath("//*[@id='side']//li[1]/a");
    By codeLanPreferenceBlock = By.xpath("//*[@id='codeLanguagePreference']");
    By nextTopic = By.xpath("//p[@class='topless']/a");


    public DocumentationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCodeLanguagePreferencesDisplayed(){
        return driver.findElement(codeLanPreferenceBlock).isDisplayed();
    }

    public void clickSeleniumDocumentationButton(){
      driver.findElement(seleniumDocLink);
    }

    public String getNextTopicText(){
        return driver.findElement(nextTopic).getText();
    }


}
