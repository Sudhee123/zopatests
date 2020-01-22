package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath="//a[@data-automation='ZA.button-personal-rate']")
    WebElement GetMyPersonalisedRatebtn;

    public void goToPersonalLoanRatePage() {
        getDriver().manage().window().maximize();
        clickOnElementUsingJavaScript(GetMyPersonalisedRatebtn);
    }
}
