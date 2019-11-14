import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.Base;


public class Testing extends Base {

    @BeforeClass
    public void beforeClass() {
        home = new Home(driver);
        studLoanEducation = new StudLoanEducation(driver);
        studLoanFinancial = new StudLoanFinancial(driver);
        studLoanProfile = new StudLoanProfile(driver);
    }

    @Test
    public void test1() {
        try {
            home.proceed();
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {
        try {
            studLoanEducation.proceed();
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        try {
            studLoanFinancial.proceed();
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test(dependsOnMethods = "test3")
    public void test4() {
        try {
            studLoanProfile.proceed();
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }
}
