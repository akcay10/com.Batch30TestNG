package day09;

import org.junit.Test;
import utilities.TestBase;

public class C03_TestBaselikTest extends TestBase {

    @Test
    public void test(){

    driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());

}
}