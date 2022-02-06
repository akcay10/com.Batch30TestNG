package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alerts {
    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void acceptAlert(){
     driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

     driver.switchTo().alert().accept();

        WebElement actualresult=driver.findElement(By.id("result"));
        String result1="You successfully clicked an alert";

        String actual=actualresult.getText();

        Assert.assertEquals(actual,result1);


    }
    @Test
    public void dismissAlert(){
   driver.findElement(By.xpath("//*[.='Click for JS Confirm']"));
    driver.switchTo().alert().dismiss();
    String istenmeyenkelime="succesfully";
        WebElement actualresult=driver.findElement(By.id("result"));
        String actual=actualresult.getText();
        Assert.assertFalse(actual.contains(istenmeyenkelime));


    }


    @Test
    public void sendKeysAlert(){

        driver.findElement(By.xpath("//*[.='Click for JS Prompt']"));
        String isim="Mehmet";
         driver.switchTo().alert().sendKeys(isim);
       WebElement resultyazi=driver.findElement(By.id("result"));
        String actualRes=resultyazi.getText();

        SoftAssert softAssert=new SoftAssert();
softAssert.assertTrue(actualRes.contains(isim));




        softAssert.assertAll();




    }


    @AfterClass
    public void tearDown(){
        // driver.close();


    }
}
