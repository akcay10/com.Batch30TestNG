package day07new;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/dropdown");

    Thread.sleep(2000);
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

Thread.sleep(2000);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);

        select.selectByVisibleText("Option 1");

        select.selectByVisibleText("Option 2");
        System.out.println("1 cikarsa yanlis,2 cikarsa dogru"+select.getFirstSelectedOption().getText());

        List<WebElement> tumopsiyonlar=select.getOptions();

        for(WebElement each:tumopsiyonlar){

            System.out.println(each.getText());


        }
        System.out.println(tumopsiyonlar.size());
        if(tumopsiyonlar.size()==4){
            System.out.println("True");
        }else{

            System.out.println("False");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();


    }
}
