package pages;

import base.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;

//Page class for Credible.com Loan Profile info form
public class StudLoanProfile extends Helper {
        WebDriver driver;
        //String url = "https://www.credible.com/student-loans/prequal/step/profile";

        //First name field
        @FindBy(id = "c92_borrower_first_name")
        WebElement firstName;

        //Last name field
        @FindBy(id = "c92_borrower_last_name")
        WebElement lastName;

        //DOB field
        @FindBy(id = "c92_borrower_dob")
        WebElement borrowerDob;

        //Phone number field
        @FindBy(id = "c92_borrower_phone")
        WebElement phoneNum;

        //Button to switch to manual address insertion field
        @FindBy(xpath = "//*[@class='to-manual-mode']")
        WebElement toManualModeAddress;

        //Street address field
        @FindBy(xpath = "//*[@id='c92_current_address_street']")
        WebElement addressStreet;

        //Additional street address field
        @FindBy(xpath = "//*[@id='c92_current_address_unit']")
        WebElement addressUnit;

        //City address field
        @FindBy(xpath = "//*[@id='c92_current_address_city']")
        WebElement addressCity;

        //State address field
        @FindBy(xpath = "//*[@id='s2id_c92_current_address_state']")
        WebElement addressState;

        //Search box for State address filed
        @FindBy(xpath = "//*[@id='s2id_autogen9_search']")
        WebElement addressStateSearch;

        //Address zipcode field
        @FindBy(xpath = "//*[@id='c92_current_address_zipcode']")
        WebElement addressZipcode;

        //Email id filed
        @FindBy(id = "c240_email")
        WebElement emailId;

        //Password field
        @FindBy(id = "c240_password")
        WebElement passField;

        //Formatter and Date objects needed to capture date and time at any given moment
        //To format date and time for separation I used hyphen (-) sign as both colon (:) and forward slash (/) are not allowed in email
        SimpleDateFormat formatter= new SimpleDateFormat("MM-dd+HH-mm");
        Date date;


        public StudLoanProfile(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, 10);
        }

        /*
        Note: All data that is inserted to fields below is hardcoded.
        Initially I designed all data to be delivered from external sources but I had to make this decision based on short time frame
        */

        public void proceed() {

            //Insert first name in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys("Great");

            //Insert last name in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys("CredibleProd");

            //Insert date of birth in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(borrowerDob)).sendKeys("01011999");

            //Insert phone number in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(phoneNum)).sendKeys("4151234567");

            //Perform click on button to open manual insertion address form
            toManualModeAddress.click();

            //Insert address in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(addressStreet)).sendKeys("22 4th St");

            //Insert unit data in additional address filed
            wait.until(ExpectedConditions.visibilityOf(addressUnit)).sendKeys("8th floor");

            //Insert city address in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(addressCity)).sendKeys("San Francisco");

            //Initially opens search box for state address field, then does search in state address field and performs "Enter" key press
            addressState.click();
            wait.until(ExpectedConditions.visibilityOf(addressStateSearch)).sendKeys("California", Keys.ENTER);

            //Insert zipcode in corresponding filed
            wait.until(ExpectedConditions.visibilityOf(addressZipcode)).sendKeys("94103");

            //Next line is to capture current date and time for email generation, then based on captured data method inserts it in email field
            date = new Date(System.currentTimeMillis());
            wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys("Stan"+formatter.format(date)+"@credible.com");

            //Note: Usually for password open hardcoded data is not a good fit. As I had short time period I didn't handle it properly with cipher
            wait.until(ExpectedConditions.visibilityOf(passField)).sendKeys("Passw0rd");
        }

}
