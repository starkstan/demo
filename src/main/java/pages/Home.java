package pages;

import base.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page class for Credible.com home page
public class Home extends Helper {
    String url = "https://www.credible.com/?vt_disabled=true";

    //Initial Button for Student Loans
    @FindBy(xpath = "(//button[@class='_2N9nSmyC dNUaMKar'])[1]")
    WebElement getMyLoanRatesStudent;

    //Option "I am the student" for Student Loan
    @FindBy(xpath = "//button[text()='I am the student']")
    WebElement iamTheStudent;

    public Home(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void proceed() throws InterruptedException {
        //Open Credible.com home page
        driver.get(url);

        //Clicks on button for Student Loan Options
        wait.until(ExpectedConditions.visibilityOf(getMyLoanRatesStudent)).click();

        //Needed wait for animation to complete
        Thread.sleep(500);

        //Clicks on option button "I am the Student"
        wait.until(ExpectedConditions.visibilityOf(iamTheStudent)).click();
    }
}
