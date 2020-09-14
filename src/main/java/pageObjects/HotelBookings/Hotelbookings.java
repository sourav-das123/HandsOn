package pageObjects.HotelBookings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotelbookings {

    @FindBy(linkText = "Hotels")
    public WebElement Hotelslink;

    @FindBy(xpath = "((//label[text()='Destination'])[1]//following::input)[1] ")
    public WebElement DestinationField;

    @FindBy(id = "checkin")
    public WebElement CheckIn;

    @FindBy(id = "checkout")
    public WebElement CheckOut;

    @FindBy(xpath = "((//input[contains(@class,'control')])[4]//following::button)[1]")
    public WebElement AdultFieldPlus;

    @FindBy(xpath = "((//input[contains(@class,'control')])[4]//following::button)[2]")
    public WebElement AdultFieldMinus;

    @FindBy(xpath = "((//input[contains(@class,'control')])[4]//following::button)[3]")
    public WebElement ChildFieldPlus;

    @FindBy(xpath = "((//input[contains(@class,'control')])[4]//following::button)[4]")
    public WebElement ChildFieldMinus;

    @FindBy(xpath = "(//input[contains(@class,'control')])[4]//following::button[5]")
    public WebElement SearchButton;



    public static Hotelbookings initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Hotelbookings.class);
    }
}