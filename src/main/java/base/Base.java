package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Home;
import pages.StudLoanEducation;
import pages.StudLoanFinancial;
import pages.StudLoanProfile;

//Base class with initial driver setup
//I used google chrome for this scenario
public class Base {

    protected WebDriver driver;
    protected Home home;
    protected StudLoanProfile studLoanProfile;
    protected StudLoanFinancial studLoanFinancial;
    protected StudLoanEducation studLoanEducation;

    @BeforeSuite
    public void setup() {
        if (System.getProperty("os.name").toUpperCase().contains("MAC"))
            System.setProperty("webdriver.chrome.driver", "resources/webdriver/mac/chromedriver");
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
            System.setProperty("webdriver.chrome.driver", "resources/webdriver/pc/chromedriver.exe");
        else throw new IllegalArgumentException("Unknown OS");

        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions setoption = new ChromeOptions();
        setoption.addArguments("disable-infobars");
        setoption.addArguments("--disable-notifications");
        setoption.addArguments("--disable-annotations");

        if (System.getProperty("os.name").toUpperCase().contains("MAC"))
            setoption.addArguments("--start-fullscreen");
        else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
            setoption.addArguments("--start-maximized");
        else throw new IllegalArgumentException("Unknown OS");
        driver = new ChromeDriver(setoption);

    }


//No need to shut browser after scenario is complete
//    @AfterSuite
//    public void stop() {
//        driver.quit();
//    }

}