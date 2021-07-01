package test_case_2;

/*
 * The test case verify_menu_languages is a test case for testing all the available options from the visual selector
 * languages and countries and to verify these changes from the url's and shipping informations
 */


import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class verify_menu_languages {
	public static void main(String[] args) {

	//setting the driver executable
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

	//Initiating your chromedriver
	WebDriver driver=new ChromeDriver();
	
	//Applied wait time
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//maximize window
	driver.manage().window().maximize();

	//open browser with the desired URL
	driver.get("https://www.alza.cz");
	
	//find the selector
	WebElement selector = driver.findElement(By.className("selector"));

	//click on selector
	selector.click();
	
	//find the link for the english language
    WebElement language_EN = driver.findElement(By.className("langEN"));
	
    //click on the link to switch the language to english
    language_EN.click();
    
    // Verify the actual url is the expected url for language EN
    String actualUrl="https://www.alza.cz/EN/";
    String expectedUrl= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl);

    //find the selector
	WebElement selector2 = driver.findElement(By.className("selector"));
	
	//click on the selector
	selector2.click();
	
	//find the link for language SK
    WebElement languageSK = driver.findElement(By.className("langSK"));

    //click to change to language
    languageSK.click();

    // Verify the actual url is the expected url for language SK
    String actualUrl2="https://www.alza.sk/";
    String expectedUrl2= driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl2, actualUrl2);
    
    //find the selector
    WebElement country_selector_2 = driver.findElement(By.className("selector"));
    
    //click to expand the options
    country_selector_2.click();
    
    // Get the link for Croatia
    WebElement country_selection2 = driver.findElement(By.linkText("Croatia"));
    
    // click on the country link for Croatia
    country_selection2.click();
    
    //compare the the actual url is the expected url for country equals to Croatia
    String actualUrl_HR="https://www.alzashop.com/?";
    String expectedUr_HR= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_HR, expectedUr_HR);
    
    //compare the text for shipping to thats its equal to Croatia
    String expected_shipping_country_HR="Croatia";
    String actual_shipping_country_HR= driver.findElement(By.className("shiptoTxt")).getText();
    Assert.assertEquals(expected_shipping_country_HR, actual_shipping_country_HR);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector
    WebElement country_selector_3 = driver.findElement(By.className("selector"));
    
    //click on the selector to expand the options
    country_selector_3.click();
    
    //find the link for the country France
    WebElement country_selection3 = driver.findElement(By.linkText("France"));
    
    //click on the link to switch to the french web site
    country_selection3.click();
    
    //test that the expected url is the defined url
    String actualUrl_FR = "https://www.alzashop.com/?";
    String expectedUr_FR =  driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_FR, expectedUr_FR);
    
    //compare the text for shipping to thats its equal to France
    String expected_shipping_country_FR = "France";
    String actual_shipping_country_FR = driver.findElement(By.className("shiptoTxt")).getText();
    Assert.assertEquals(expected_shipping_country_FR, actual_shipping_country_FR);
    
    //redirect to alza.cz    
    driver.get("https://www.alza.cz");
    
    //find the selector 
	driver.findElement(By.className("selector")).click();
    
	//click on the link for the country Austria
    driver.findElement(By.linkText("Austria")).click();
    
    //test that the expected url is the defined url
    String actualUrl_AT="https://www.alza.at/";
    String expectedUr_AT= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_AT,expectedUr_AT);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector 
	driver.findElement(By.className("selector")).click();
	
    //click on the country link for Germany
    driver.findElement(By.linkText("Germany")).click();

    //test that the expected url is the defined url
    String actualUrl_DE="https://www.alza.de/";
    String expectedUr_DE= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_DE, expectedUr_DE);

    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector 
	driver.findElement(By.className("selector")).click();

    //click on the country link for Hungary
    driver.findElement(By.linkText("Hungary")).click();

    //test that the expected url is the defined url
    String actualUrl_HU="https://www.alza.hu/";
    String expectedUr_HU= driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_HU, expectedUr_HU);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector 
	driver.findElement(By.className("selector")).click();

    // click on the country link for Poland
    driver.findElement(By.linkText("Poland")).click();

    //test that the expected url is the defined url
    String actualUrl_PL = "https://www.alzashop.com/?";
    String expectedUr_PL = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_PL, expectedUr_PL);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector
	driver.findElement(By.className("selector")).click();

	//click on the country link for Romania
    driver.findElement(By.linkText("Romania")).click();

    //test that the expected url is the defined url
    String actualUrl_RO ="https://www.alzashop.com/?";
    String expectedUr_RO = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_RO, expectedUr_RO);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector 
	driver.findElement(By.className("selector")).click();
	
    //click on the country link for Slovenia
    driver.findElement(By.linkText("Slovenia")).click();

    //test that the expected url is the defined url
    String actualUrl_SLO ="https://www.alzashop.com/?";
    String expectedUr_SLO = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_SLO, expectedUr_SLO);
    
    //redirect to alza.cz
    driver.get("https://www.alza.cz");
    
    //find the selector
	driver.findElement(By.className("selector")).click();

    //click on the country link for United Kingdom
    driver.findElement(By.linkText("United Kingdom")).click();

    //test that the expected url is the defined url
    String actualUrl_UK ="https://www.alza.co.uk/";
    String expectedUr_UK = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl_UK, expectedUr_UK);
    
    //close the driver
    driver.close();
    
	}

}
