package stepdefinitions;

import base.TestBase;
import dataprovider.ExcelReader;
import dataprovider.PropertiesReader;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObjects.Authentication.Login;
import pageObjects.Authentication.Logout;
import pageObjects.Authentication.SignUp;
import pageObjects.CommonObjects.Common;
import pageObjects.HotelBookings.Hotelbookings;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

public class BookingStepDefinition extends TestBase
{

    private TestBase testBase;

    public List<HashMap<String, String>> BookingHotels;
    public List<HashMap<String, String>> AssignContractData;
    public List<HashMap<String, String>> SortingAndFiltering;

    public BookingStepDefinition(TestBase testBase)
    {
        this.testBase=testBase;
        BookingHotels = ExcelReader.GetTestData("BookingHotels");
    }

    @Given("SignUp as a user \"(.*)\"$")
    public void signup(String Username) throws IOException
    {
        try
        {
            int index = Integer.parseInt(Username)-1;
            testBase.pause();
            testBase.WaitTillElementClickable(Common.initiate(testBase.driver).AccountField);
            Common.initiate(testBase.driver).AccountField.click();
            testBase.WaitTillElementClickable(Common.initiate(testBase.driver).SignUpField);
            Common.initiate(testBase.driver).SignUpField.click();
            testBase.WaitTillElementClickable(SignUp.initiate(testBase.driver).FirstNameField);
            SignUp.initiate(testBase.driver).FirstNameField.sendKeys(BookingHotels.get(index).get("FirstName"));
            SignUp.initiate(testBase.driver).LastNameField.sendKeys(BookingHotels.get(index).get("LastName"));
            SignUp.initiate(testBase.driver).MobileNumber.sendKeys(BookingHotels.get(index).get("Mobile"));
            SignUp.initiate(testBase.driver).EmailField.sendKeys(BookingHotels.get(index).get("Email"));

            SignUp.initiate(testBase.driver).PassowrdField.
                    sendKeys(PropertiesReader.ReadEnvironmentParameters("Pwd"));
            SignUp.initiate(testBase.driver).ConfirmPassword.
                    sendKeys(PropertiesReader.ReadEnvironmentParameters("Pwd"));
            testBase.pause();
            //SignUp.initiate(testBase.driver).SignUpBtn.click();
            JavascriptExecutor executor = (JavascriptExecutor)testBase.driver;
            executor.executeScript("arguments[0].click();", SignUp.initiate(testBase.driver).SignUpBtn);
            testBase.pause();
            Logout.initiate(testBase.driver).LogOut.click();
            testBase.pause();

        }

        catch (AssertionError | Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Given("Search For Bookings for Hotels \"(.*)\"$")
    public void SearchForBookings(String user)
    {
        try
        {

            int index = Integer.parseInt(user)-1;
            testBase.WaitTillElementClickable(Common.initiate(testBase.driver).HomeField);
            Common.initiate(testBase.driver).HomeField.click();
            testBase.WaitTillElementClickable(Hotelbookings.initiate(testBase.driver).DestinationField);
            Hotelbookings.initiate(testBase.driver).DestinationField.click();
            testBase.pause();
            Hotelbookings.initiate(testBase.driver).DestinationField.sendKeys(BookingHotels.get(index).get("Destination"));
            Actions builder = new Actions(testBase.driver);
            builder.sendKeys(Keys.ENTER);
            Hotelbookings.initiate(testBase.driver).SearchButton.click();

        }
        catch (AssertionError | Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
