package StepLibs;

import Pages.PersonalisedLoanRatesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.io.IOException;


public class WhenOnLoansPage extends ScenarioSteps {

    private PersonalisedLoanRatesPage personalisedLoanRatesPage;

    @Step("Validating the form fields")
    public void ValidateFields() {
        personalisedLoanRatesPage.ValidateEmailID();
        personalisedLoanRatesPage.ValidateFirstName();
        personalisedLoanRatesPage.ValidateLastName();
    }

    @Step("Validating the postcode field")
    public void ValidatePostCodeField() {
        personalisedLoanRatesPage.ValidatePostCodeField();
    }

    @Step("Verifying Page title")
    public void PageTitleVerification() {
        //personalisedLoanRatesPage.VerifyPagetitle();
    }

    @Step("Validating the phone number field")
    public void ValidatePhoneNumberField() {
        personalisedLoanRatesPage.ValidatePhoneNumberField();
    }

    public void FilltheFormFields(String loanFor)
    {
        personalisedLoanRatesPage.SelectLoanitem(loanFor);
        personalisedLoanRatesPage.EnterEmailID();
        personalisedLoanRatesPage.EnterPostCode();
        personalisedLoanRatesPage.EnterPhoneNumber();
    }
}
