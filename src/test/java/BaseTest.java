
import org.junit.Ignore;
import org.junit.Test;
import utilities.*;
import org.junit.Assert;



public class BaseTest {


  @Test
  public void testSiteTrip(){

      //CustomSeleniumLibrary widget = new CustomSeleniumLibrary();

      CustomSeleniumLibrary.openURL(Data.URL); //opens the site

      CustomSeleniumLibrary.populateWebElement(Data.from_Control,Data.From_Station,Data.suggestion_from_Control); //finds and populates from station and clicks the suggestion

      CustomSeleniumLibrary.populateWebElement(Data.to_Control,Data.To_Station,Data.suggestion_to_Control);  //finds and populates to station and clicks the suggestion

      CustomSeleniumLibrary.clickGo(Data.search_Control); //Clicks  the go button

      Assert.assertTrue("Trip list is empty",CustomSeleniumLibrary.getTripCount(Data.triplist_Control)>0);  //checks the trip count >0

      CustomSeleniumLibrary.quit(); //closes the webdriver

    }

    @Test
    public void testAPIStop(){

         Client.performGet(Data.endpoint); // Creates the httpclient and excutes the Get request

         Assert.assertEquals("Invalid Response Code",200,Client.getStatusCode()); // Asserts  the response code is 200

         Assert.assertTrue("Station metadata is missing",Client.getStation().length()>0); // Asserts that station name is not an empty string

        Assert.assertEquals("Not the Right Station",Data.stopName,Client.getStation());  //Check that station has right name

        Assert.assertTrue("Multiple modes are not available",Client.getModesCount()>1 ); // Checks that it has multiple modes
    }



}






























































































