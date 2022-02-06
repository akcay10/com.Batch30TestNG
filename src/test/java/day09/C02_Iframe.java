package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_Iframe {
    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/iframe");
    }

        @Test

public void test(){
            WebElement baslikyazi= driver.findElement(By.tagName("h3"));

            Assert.assertTrue(baslikyazi.isEnabled());
            System.out.println(baslikyazi.getText());

            WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));

            driver.switchTo().frame(iFrame);
            WebElement yazikutusu=driver.findElement(By.xpath("//*[@id='tinymce']"));

            yazikutusu.clear();
            yazikutusu.sendKeys("Merhaba Dunya");

            driver.switchTo().defaultContent();

      WebElement elementallinki=driver.findElement(By.linkText("Elemental Selenium"));

            SoftAssert softAssert=new SoftAssert();

            softAssert.assertTrue(elementallinki.isDisplayed());
            softAssert.assertAll();
            System.out.println(elementallinki.getText());





        }







    @AfterClass
    public void tearDown() {
        // driver.close();
    }
}