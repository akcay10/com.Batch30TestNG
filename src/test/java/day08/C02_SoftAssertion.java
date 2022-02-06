package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;////no need static like JUnit
import org.testng.annotations.BeforeClass;//no need static like JUnit
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {
    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
@Test
public void test() {
        SoftAssert softAssert = new SoftAssert();//hard assertden farli object olusduruluor.
    driver.get("https://www.amazon.com");

    softAssert.assertTrue(driver.getCurrentUrl().contains("amazon"),"title amazon icermiyor");//basa softAssert yaziliyor

    softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");

    WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramakutusu.sendKeys("java"+ Keys.ENTER);

    WebElement ilkUrun= driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
    softAssert.assertTrue(ilkUrun.getText().contains("java"),"ilk urun java icermiyor");

    //softAssert.assertAll();//3. adim mutlaka once yazilmali,butun satirlar buraya kadar calisir.//bu olmaz yada kapali kalirsa testde hata olmasina ragmen test gecer.
    softAssert.assertAll();//3. adim mutlaka once yazilmali,butun satirlar buraya kadar calisir.


        }

    @AfterClass
    public void tearDown(){
        // driver.close();


    }
}
