package stepdefinitions;

import base.TestBase;
import dataprovider.PropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GeneralHooks extends TestBase {

    private TestBase testBase;

    public GeneralHooks(TestBase testBase) {
        this.testBase = testBase;
    }

    @Before
    public void createSession() throws Throwable {
        try {
            String projectdirectory = System.getProperty("user.dir");
            String baseurl = PropertiesReader.ReadEnvironmentParameters("URL");
            String headlesscheck = PropertiesReader.ReadEnvironmentParameters("HEADLESS");
            if (headlesscheck.equalsIgnoreCase("yes"))
            {
                System.setProperty("webdriver.chrome.driver",
                        projectdirectory + "\\browserdependencies\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
//options.addArguments("--incognito");
//options.addArguments("--verbose");
//options.addArguments("headless");
//options.addArguments("--disable-gpu");
//options.addArguments("--window-size=1920,1080");
                testBase.driver = new ChromeDriver(options);
                testBase.driver.manage().window().maximize();
                testBase.driver.get(baseurl);
                testBase.driver.manage().deleteAllCookies();
                testBase.driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
            }
            else
            {
                System.setProperty("webdriver.chrome.driver",
                        projectdirectory + "\\browserdependencies\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
//options.addArguments("--window-size=1920,1080");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                testBase.driver = new ChromeDriver(options);
                testBase.driver.manage().window().maximize();
                testBase.driver.get(baseurl);
                testBase.driver.manage().deleteAllCookies();
                testBase.driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @After
    public void endSession() {
        testBase.driver.quit();
    }
}
