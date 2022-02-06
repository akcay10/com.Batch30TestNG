package day07new;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C03_DependsOn {

    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Test
    public  void test1(){

        driver.get("https://www.amazon.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/","url amazon degil");
    }
    @Test(dependsOnMethods = "test1")
    public  void test2(){

        WebElement arama= driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("Nutella"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"),"Nutella icin arama yapilamiyor");

    }
    @Test(dependsOnMethods = "test2")


    public  void test3(){

        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
      WebElement fiyat= driver.findElement(By.className("a-size-base a-color-price"));
        System.out.println((fiyat.getText()));




    }



    @AfterClass
    public void tearDown(){
       // driver.close();


    }
}
