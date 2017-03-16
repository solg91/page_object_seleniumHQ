package LoadableComponent;


import PageFactory.SeleniumHQTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by solg on 16.03.2017.
 */

public class MyListener extends TestListenerAdapter {
    WebDriver driver;
    @Step("Make a screenshot MyListener")
    @Override
    public void onTestFailure(ITestResult result)
    {
        createAttachment(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] createAttachment(ITestResult result) {
        System.out.println("Create attachments");
        Object currentClass = result.getInstance();
               if ( currentClass.getClass().equals(AboutPageTest.class))
        {
            driver = ((AboutPageTest) currentClass).getDriver();}
        else {
                   driver = ((SeleniumHQTest) currentClass).getDriver();}
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

