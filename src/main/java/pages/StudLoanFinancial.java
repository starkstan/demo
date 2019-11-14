package pages;

import base.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page class for Credible.com Loan Financial info form
public class StudLoanFinancial extends Helper {
    WebDriver driver;
    //String url = "https://www.credible.com/student-loans/prequal/step/financial";

    //Borrower Annual income field
    @FindBy(id = "c92_borrower_income_yearly")
    WebElement borrowerIncome;

    //Borrower Housing payment field
    @FindBy(id = "c92_borrower_housing_payment")
    WebElement borrowerRent;

    //Continue button
    @FindBy(xpath = "(//button[@class='cta cta-primary'])[2]")
    WebElement continueButton;

    public StudLoanFinancial(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    /*
    Note: All data that is inserted to fields below is hardcoded.
    Initially I designed all data to be delivered from external sources but I had to make this decision based on short time frame
    */

    public void proceed() {

        //Insert annual income in field
        wait.until(ExpectedConditions.visibilityOf(borrowerIncome)).sendKeys("40000");

        //insert housing payment in field
        wait.until(ExpectedConditions.visibilityOf(borrowerRent)).sendKeys("700");

        //Click on Continue button to proceed to next page
        continueButton.click();
    }

}
