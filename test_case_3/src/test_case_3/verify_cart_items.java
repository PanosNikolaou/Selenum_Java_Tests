package test_case_3;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class verify_cart_items {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //open browser with the desired URL
        driver.get("https://www.alza.cz/EN/");

        //find the element for summer sales
        WebElement summer_sale = driver.findElement(By.xpath("//a[contains(.,'Summer sale')]"));

        //click on this link
        summer_sale.click();

        //find the brand new link
        WebElement brand_new = driver.findElement(By.id("hlCommodityStatusNew"));

        //click on the checkbox for brand new
        brand_new.click();

        //filter by producer 1more
        driver.findElement(By.xpath("//div[@id='producer-13567']/div/label")).click();

        //find the 1st item 1more truly wireless headphones
        driver.findElement(By.xpath("//a[@onclick=\"showBoxOrderInfoBase(this, 6316336, false, false, 'Wireless Headphones');\"]")).click();

        //click on buy
        driver.findElement(By.linkText("Buy")).click();

        //click on extended warranty for 3 years
        driver.findElement(By.xpath("//div[@id='content0']/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/span[2]")).click();

        //click on add to basket
        driver.findElement(By.xpath("//a[@id='varBToBasketButton']/span")).click();

        //get the text for the price of the headphones
        String headphones_text = driver.findElement(By.xpath("//div[@id='o1basket']/table/tbody/tr/td[6]")).getText();

        //verify the price of the headphones
        Assert.assertEquals(headphones_text, "699 Kč");

        //verify extended warranty + 3 years
        Assert.assertEquals("180 Kč", driver.findElement(By.xpath("//div[@id='o1basket']/table/tbody/tr[2]/td[6]")).getText());

        //verify Total excl. VAT
        Assert.assertEquals("757,49 Kč", driver.findElement(By.xpath("//div[@id='sum']/div/table/tbody/tr/td[2]/span")).getText());

        //verify To Pay
        Assert.assertEquals("879 Kč", driver.findElement(By.xpath("//div[@id='sum']/div/table/tbody/tr[3]/td[2]/span")).getText());

        //close the driver
        driver.close();
    }
}