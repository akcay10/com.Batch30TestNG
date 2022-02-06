package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //    Making this abstract, because we just want to implement the methods without showing the details
//    We also do not want to create an object on TestBase, just want to use the method inside it.
//    TestBase will have only two methods
//    1. Before
//    2. After
//    Why TestBase?
//    We use TestBase for REPEATED PRE CONDITION AND AFTER CONDITION
//    TestBase is reusable
//    This will make actual test class shorter.
//    access modifier must be protected or public
//    cause they are in different packages
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        //driver.close();
    }
}