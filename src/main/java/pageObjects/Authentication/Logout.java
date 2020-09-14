package pageObjects.Authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CommonObjects.Common;

public class Logout {

    @FindBy(id = "checkin")
    public WebElement CheckIn;

    @FindBy(linkText = "Logout")
    public WebElement LogOut;

    public static Logout initiate(WebDriver driver) {
        return PageFactory.initElements(driver, Logout.class);
    }
}
