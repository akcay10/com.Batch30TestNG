package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C03_SoftAssert {

    WebDriver driver;

    @BeforeClass //no need static like JUnit

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void tets(){
driver.get("http://zero.webappsecurity.com/");
driver.findElement(By.id("signin_button")).click();
driver.findElement(By.id("user_login")).sendKeys("username");
driver.findElement(By.id("user_password")).sendKeys("password");
driver.findElement(By.name("submit")).click();
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
driver.findElement(By.id("pay_bills_link")).click();
driver.findElement(By.linkText("Purchase Foreign Currency")).click();

WebElement currency=driver.findElement(By.id("pc_currency"));
        Select select=new Select(currency);
select.selectByValue("EUR");

String actualdata=select.getFirstSelectedOption().getText();

String expectedValue="Eurozone (euro)";


        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualdata,expectedValue,"secilen option euro zone degil");

List<WebElement> tumOpsiyonlar=select.getOptions();

List<String> tumOpsiyonlarString=new ArrayList<>();

        for (WebElement each:tumOpsiyonlar
             ) {
            tumOpsiyonlarString.add(each.getText());

        }

List<String> expectedOptionsList= Arrays.asList("Select One","Australia (dollar)");
//expectedOptionsList.contains("Select One");


        softAssert.assertEquals(tumOpsiyonlarString,expectedOptionsList,"liste farkli");


        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown(){
        // driver.close();


    }
}
