package day07new;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {
    WebDriver driver;

    @BeforeMethod

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

@Test(priority = 10)

    public void amazonTest(){
        driver.get("https://www.amazon.com");

    System.out.println(driver.getTitle());

}

    @Test(priority = 1)
    public void techproTest(){
        driver.get("https://www.techproeducation.com");

        System.out.println(driver.getTitle());

    }
    @Test
    public void facebookTest() throws InterruptedException {
        driver.get("https://www.facebook.com");

        System.out.println(driver.getTitle());

    }
@AfterMethod
    public void tearDown(){

        //driver.close();
}
}
