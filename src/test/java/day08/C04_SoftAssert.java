package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C04_SoftAssert {

    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
@Test
        public void test(){

        driver.get("https://www.hepsiburda.com/");

        SoftAssert softAssert=new SoftAssert();



            }





    @AfterClass
    public void tearDown(){
        // driver.close();


    }
}