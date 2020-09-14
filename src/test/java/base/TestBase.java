package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;


    public void WaitTillElementClickable(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void SwitchToFrame(WebElement element)
    {
        driver.switchTo().frame(element);
    }

    public void SwitchToDefault()
    {
        driver.switchTo().defaultContent();
    }

    public void TimeOutWait()
    {
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
    }

    public void SelectDropdown(String option, WebElement element)
    {
        Select slctdropdown = new Select(element);
        slctdropdown.selectByVisibleText(option);

    }

    public void WaitToLoad()
    {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    public void WaitTillElementVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void pause()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.getMessage();
        }
    }

    public void HoverToElement(WebElement element)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click(element);
        builder.pause(5);
        builder.perform();
    }
    public void AcceptAlert()
    {
        driver.switchTo().alert().accept();
        pause();
    }

    public Boolean isPresent(WebElement element)
    {
        try
        {
            element.isDisplayed();
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
    }

    public Boolean isPresentDynamic(By locator)
    {
        try
        {
            driver.findElement(locator);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }
    }

    public void ValidatePresenceOfElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void HoverOver(WebElement element)
    {
        Actions builder = new Actions(driver);
        builder.moveToElement(element);
    }

    public void WaitTillFrameLoad(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
}
