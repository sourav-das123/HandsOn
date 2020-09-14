package pageObjects.Authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(xpath = "(//input[@type='email'])[1]")
    public WebElement Username;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement Password;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement LoginBtn;

    public static Login initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, Login.class);
    }

}
