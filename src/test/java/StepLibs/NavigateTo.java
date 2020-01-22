package StepLibs;

import Pages.HomePage;
import net.thucydides.core.annotations.Step;

public class NavigateTo {

    private ZopaHomePage zopaHomePage;
    private HomePage homePage;

    @Step("Open the Zopa Loans page")
    public void ZopaLoansHomePage() {
        homePage.open();
    }

    @Step("Navigate to Personalised loan rates page")
    public void PersonalisedLoanRatesPage() {
        homePage.goToPersonalLoanRatePage();
    }

}
