package LoadableComponent;


import Common.AbstractTestClass;
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

    @Override
    public void onTestFailure(ITestResult result)
    {
        createAttachment(result);
        createHTML(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] createAttachment(ITestResult result) {

        Object currentClass = result.getInstance();
        driver = ((AbstractTestClass) currentClass).getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "Page html", type = "text/html")
    private String createHTML(ITestResult result) {

        Object currentClass = result.getInstance();
        driver = ((AbstractTestClass) currentClass).getDriver();
        return driver.getPageSource();
    }
}

