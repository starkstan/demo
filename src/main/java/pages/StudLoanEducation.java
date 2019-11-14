package pages;

import base.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page class for Credible.com Loan Education info form
public class StudLoanEducation extends Helper {
    WebDriver driver;
    //String url = "https://www.credible.com/student-loans/prequal/step/education";

    //Radio option "No" on first block
    @FindBy(xpath = "(//span[@class='radio-icon'])[2]")
    WebElement checkedCrebibleBeforeNo;

    //Radio option "No" on second block
    @FindBy(xpath = "(//span[@class='radio-icon'])[5]")
    WebElement cosignerNo;

    //Education center title field
    @FindBy(id = "c92_education_name")
    WebElement educationName;

    //Current degree field
    @FindBy(id = "s2id_c92_education_degree_type")
    WebElement degreeType;

    //"Bachelors" option from dropdown
    @FindBy(xpath = "(//*[text()='Bachelors'])[2]")
    WebElement bachelorsOption;

    //Current study year field
    @FindBy(id = "s2id_c92_education_current_year")
    WebElement currentYear;

    //3rd option from dropdown Note: comparable for multiple dropdown menus on this page
    @FindBy(xpath = "(//*[@class='select2-result-label'])[3]")
    WebElement select3rdOption;

    //Estimated completion date field
    @FindBy(id = "c92_education_completion_date")
    WebElement completionDate;

    //Academic period loan field
    @FindBy(id = "s2id_c92_education_academic_period_loan")
    WebElement periodLoan;

    //Requested loan amount field
    @FindBy(id = "c92_education_requested_loan_amount")
    WebElement loanAmount;

    //Continue button
    @FindBy(xpath = "(//button[@class='cta cta-primary'])[1]")
    WebElement continueButton;

    public StudLoanEducation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    /*
    Note: All data that is inserted to fields below is hardcoded.
    Initially I designed all data to be delivered from external sources but I had to make this decision based on short time frame
    */

    //Explicit method to perform all needed actions on page
    public void proceed() throws InterruptedException {

        //Performs click on radio button in first block
        wait.until(ExpectedConditions.visibilityOf(checkedCrebibleBeforeNo)).click();

        //Performs click on radio button in second block
        wait.until(ExpectedConditions.visibilityOf(cosignerNo)).click();

        //Perform data inception followed by "ENTER" key click. Due to page design Thread.sleep is needed to assure Enter key is pressed correctly
        wait.until(ExpectedConditions.visibilityOf(educationName)).sendKeys("University of San Francisco");
        Thread.sleep(1000);
        educationName.sendKeys(Keys.ENTER);

        //Performing selection in Degree type dropdown field
        wait.until(ExpectedConditions.visibilityOf(degreeType)).click();
        wait.until(ExpectedConditions.visibilityOf(bachelorsOption)).click();

        //Performing selection in Current year of study dropdown field
        wait.until(ExpectedConditions.visibilityOf(currentYear)).click();
        wait.until(ExpectedConditions.visibilityOf(select3rdOption)).click();

        //Populating Expected completion field with date
        wait.until(ExpectedConditions.visibilityOf(completionDate)).sendKeys("012020");

        //Performing selection in Loan Period dropdown field
        wait.until(ExpectedConditions.visibilityOf(periodLoan)).click();
        wait.until(ExpectedConditions.visibilityOf(select3rdOption)).click();

        //Inserting Requested Loan amount
        wait.until(ExpectedConditions.visibilityOf(loanAmount)).sendKeys("40000");

        //Click on Continue button to proceed to next page
        continueButton.click();
    }
}
