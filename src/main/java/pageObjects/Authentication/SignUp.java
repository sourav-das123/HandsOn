package pageObjects.Authentication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[1]/input[1]")
    public WebElement FirstNameField;

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[2]/input[1]")
    public WebElement LastNameField;

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[3]/input[1]")
    public WebElement MobileNumber;

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[4]/input[1]")
    public WebElement EmailField;

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[5]/input[1]")
    public WebElement PassowrdField;

    @FindBy(xpath = "(//label[contains(@class,'textfield')])[6]/input[1]")
    public WebElement ConfirmPassword;

    //@FindBy(xpath = "//[@class='fa fa-check-square-o']")
    //public WebElement SignUpBtn; //i[@class='fa fa-check-square-o']

    @FindBy(xpath = "//button[text()=' Sign Up']")
    public WebElement SignUpBtn;

    public static SignUp initiate(WebDriver driver)
    {
        return PageFactory.initElements(driver, SignUp.class);
    }

}
