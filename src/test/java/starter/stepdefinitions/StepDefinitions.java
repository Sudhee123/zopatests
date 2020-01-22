package starter.stepdefinitions;


import Pages.PersonalisedLoanRatesPage;
import StepLibs.WhenOnLoansPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import StepLibs.NavigateTo;

import java.io.IOException;


public class StepDefinitions {

    @Steps
    NavigateTo navigateTo;

    @Steps
    PersonalisedLoanRatesPage personalisedLoanRatesPage;

    @Steps
    WhenOnLoansPage whenOnLoansPage;


    @Given("^User is on Zopa Loans Homepage$")
    public void userIsOnHomepage() {
        navigateTo.ZopaLoansHomePage();
    }

    @When("^I navigate to get my personal rates page$")
    public void iNavigateToGetMyPersonalRatesPage()
    {
        navigateTo.PersonalisedLoanRatesPage();
        whenOnLoansPage.PageTitleVerification();
    }

    //Email Field Validation
    @Then("^I have validated the fields on the form$")
    public void iHaveValidatedTheFieldsOnTheForm() {
        whenOnLoansPage.ValidateFields();
    }

   /* @And("^I have saved the test data on to a file$")
   // public void iHaveSavedTheTestDataOnToAFile()
    {
        whenOnLoansPage.SaveTheDataOntoFile();
    }*/

    @And("^I have filled the form with the valid details to apply the loan for \"([^\"]*)\"$")
    public void iHaveFilledTheFormWithTheValidDetailsToApplyTheLoanFor(String LoanFor)
    {
       // personalisedLoanRatesPage.AcceptCookie();
        whenOnLoansPage.FilltheFormFields(LoanFor);
    }

    //Postcode validation test
   @Then("^I have validated the postcode field on the form$")
    public void iHaveValidatedThePostcodeFieldsOnTheForm() throws IOException {
        whenOnLoansPage.ValidatePostCodeField();
    }

    //Phone number field validation
    @Then("^I have validated the phone number field on the form$")
    public void IHaveValidatedThePhoneNumberFieldOnTheForm() throws IOException {
        whenOnLoansPage.ValidatePhoneNumberField();
    }
}
