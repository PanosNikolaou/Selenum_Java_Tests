package test_case_1;

/*
 * The test case filter_verify_hitachi is a test case, that in first i do a search in the main search bar with the keyword HITACHI
 * then i verify that all the products that have been filtered contain the word HITACHI in their texts
 * and then i verify the size of the elements that is equal to the number of the elements that is returned from the filtering
 */

import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class filter_verify_hitachi {

    //definition of the pause function
    public static void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        //Initiating your chromedriver
        WebDriver driver = new ChromeDriver();

        //Applied wait time
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //maximize window
        driver.manage().window().maximize();

        //open browser with the desired URL
        driver.get("https://www.alza.cz");

        //find the language selector
        WebElement selector = driver.findElement(By.className("selector"));

        //click on the selector for the options
        selector.click();

        //get the link for the english language
        WebElement language = driver.findElement(By.className("langEN"));

        //click on the link
        language.click();

        //store to a variable the search element
        WebElement searchBar = driver.findElement(By.id("edtSearch"));

        //find the button to submit the search
        WebElement hledat = driver.findElement(By.id("btnSearch"));

        //type Hitahci in the search bar
        searchBar.sendKeys("Hitachi");

        //click on the search button
        hledat.click();

        // Filter by Hitachi
        WebElement producer = driver.findElement(By.id("producer-1422"));
        producer.findElement(By.className("valueInputContainer")).click();

        //use of the function pause until to get the results for the filtering
        pause(3000);

        //store in a list all the leements that contain the text HITACHI in their texts
        List < WebElement > allProduct = driver.findElements(By.xpath("//*[contains(text(),'HITACHI ')]"));

        //print out the text of the elements in the list
        for (WebElement product: allProduct) {
            System.out.println(product.getText());
        }

        //verify that the number of the filtered elements equals to the number of the list elements 
        String resultsNumber = driver.findElement(By.id("lblNumberItem")).getText();
        Assert.assertEquals(allProduct.size(), Integer.parseInt(resultsNumber));

        //close the driver
        driver.close();

    }
}