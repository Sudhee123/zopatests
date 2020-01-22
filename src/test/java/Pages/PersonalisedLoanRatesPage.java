package Pages;

import com.Zopa.DataGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;


public class PersonalisedLoanRatesPage extends BasePage {
    DataGenerator dataGenerator = new DataGenerator();
    String ExpectedTitle = "Get your personalised loan rates in 3 minutes";
    @FindBy(xpath = "//div[@class='optanon-alert-box-bg']//button[@title='Accept All']")
    WebElement AcceptCookie;
    @FindBy(xpath = "//div[@data-automation='ZA.email']//input[@type='email']")
    WebElement emailField;
    @FindBy(css = "#address-history .wgrxee-2 div.kLltIV input#text-id-postCode")
    WebElement postCodeField;
    @FindBy(id = "text-id-phone")
    WebElement phoneNumberField;


   //Creating a file to write the test data
   //File file = CreateAFile();

    public PersonalisedLoanRatesPage() {
    }

    public  void SelectLoanitem(String loanFor)
    {
        waitABit(3000);
        String LoanItem = "//label[@for='radio-id-" + loanFor + "']";
        getDriver().findElement(By.xpath(LoanItem)).click();
    }


    public void VerifyPagetitle()
    {
        String ActualTitle = getDriver().getTitle();
        waitForTitleToAppear(ActualTitle);
        Assert.assertEquals("Page is not navigated to Personalised Loan rates page", ActualTitle, ExpectedTitle);
    }

    public void AcceptCookie()
    {
        waitABit(2000);
        List<WebElement> Cookies = getDriver().findElements(By.xpath("//div[@class='optanon-alert-box-bg']//button[@title='Accept All']"));
        if(Cookies.size()>0)
        {
            AcceptCookie.click();
        }
    }

    public void EnterEmailID()
    {
        emailField.sendKeys(dataGenerator.EmailId());
        //TypeInElement((By) emailField, dataGenerator.EmailId());
    }

    public void ValidateEmailID(){
        String regex = "^(.+)@(.+)$";
        String emailText = emailField.getAttribute("value");
        ValidateField(emailField, emailText, regex);
       // WriteOntoFile(file, emailText);
    }

    public void EnterPostCode()
    {
        //WaitUntilElementDisplayed(postCodeField, 20);
        //TypeInElement(postCodeField, dataGenerator.PostCode());
        postCodeField.sendKeys(dataGenerator.PostCode());
    }

    public void EnterPhoneNumber()
    {
       phoneNumberField.sendKeys(dataGenerator.PhoneNumber().toString());
    }

    public void ValidatePhoneNumberField(){
        //Validating the phone number field
        String phonenumber = phoneNumberField.getAttribute("value");
       // WriteOntoFile(file, phonenumber);
       // CloseTheFile(file);
        Pattern ukPattern = Pattern.compile(
                "^(\\+44\\s?7\\d{3}|\\(?07\\d{3}\\)?)\\s?\\d{3}\\s?\\d{3}$");
        Matcher ukMatcher = ukPattern.matcher(phonenumber);
        assertTrue(ukMatcher.find());
   }
    public void ValidatePostCodeField() {
        //Validating the postcode field
        //WebElement postcodeField = Find(postCodeField);
        String postCodeText = postCodeField.getAttribute("value");
         //WriteOntoFile(file, postCodeText);
        Pattern ukPattern = Pattern.compile(
                "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|"
                        + "(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y]"
                        + "[0-9]?[A-Za-z]))))\\s?[0-9][A-Za-z]{2})");
        Matcher ukMatcher = ukPattern.matcher(postCodeText);
        assertTrue(ukMatcher.find());
    }

    public void CloseTheFile(File file) throws IOException {
        CloseFile(file);
    }

    public void ValidateLastName()
    {
    }

    public void ValidateFirstName()
    {
    }
}
