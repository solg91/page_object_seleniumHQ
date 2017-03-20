package Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by solg on 20.03.2017.
 */
public abstract class AbstractTestClass {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {}
    @AfterClass
    public void tearDown() {}
    public WebDriver getDriver(){return driver;}
}
