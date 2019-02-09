package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;



public class CustomSeleniumLibrary {

    /** The driver. */
    private static WebDriver driver = null;

    static Logger LOG = Logger.getLogger(CustomSeleniumLibrary.class);

    public static void openURL(String url){
        String path = "artifacts/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }


    public static void populateWebElement(String locator, String text,String suggestion){
        driver.findElement(By.id(locator)).sendKeys(text);
        try {
            Thread.sleep(3000);
        }
        catch (Exception e){

        }
        driver.findElement(By.id(suggestion)).click();
    }

    public static void clickGo(String locator){
        driver.findElement(By.id(locator)).click();
    }

    public static int getTripCount(String locator){

        return
        driver.findElements(By.xpath(locator)).size();
    }


    public static void quit(){
        driver.quit();
    }

}
