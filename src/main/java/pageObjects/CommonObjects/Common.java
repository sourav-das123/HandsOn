package pageObjects.CommonObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Authentication.Login;

public class Common {

    @FindBy(xpath = "(//a[@id='dropdownCurrency'])[2]")
    public WebElement AccountField;

    @FindBy(xpath = "//a[@title='home']")
    public WebElement HomeField;

    @FindBy(linkText = "Bookings")
    public WebElement BookingBtn;

    @FindBy(linkText = "Sign Up")
    public WebElement SignUpField;

    @FindBy(linkText = "Login")
    public WebElement LoginField;

    public static Common initiate(WebDriver driver) {
        return PageFactory.initElements(driver, Common.class);
    }
}