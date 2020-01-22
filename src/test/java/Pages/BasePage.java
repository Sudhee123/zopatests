package Pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage extends PageObject {
    WebDriver Driver = getDriver();

    /// <summary>
    /// Navigates to the desired url
    /// </summary>
    /// <param name="url"></param>
    protected void NavigateTo(String url)
    {
        Driver.navigate().to(url);
    }


    /// <summary>
    /// Finds element by locator
    /// </summary>
    /// <param name="locator"></param>
    /// <returns>The WebElement</returns>
    protected WebElement Find(By locator)
    {
        return Driver.findElement(locator);
    }

    /// <summary>
    /// Selects a dropdown menu item using the value of the menu item
    /// by webElement
    /// </summary>
    /// <param name="webElement"></param>
    /// <param name="value"></param>
    protected void SelectDropDownItemByValue(WebElement webElement, String value)
    {
        WaitUntilElementClickable(webElement, 10);

        Select select = new Select(webElement);
        select.selectByValue(value);
    }


    /// <summary>
    /// Finds all elements by locator
    /// </summary>
    /// <param name="locator"></param>
    /// <returns>ReadOnlyCollection of WebElements</returns>
    protected List<WebElement> FindElements(By locator)
    {
        return Driver.findElements(locator);
    }

    /// <summary>
    /// Clicks element by locator
    /// </summary>
    /// <param name="locator"></param>
    protected void Click(By locator)
    {
        WaitUntilElementClickable(locator, 10);
        Find(locator).click();
    }


    /// <summary>
    /// Clicks element by webElement
    /// </summary>
    /// <param name="webElement"></param>
    protected void Click(WebElement webElement)
    {
        WaitUntilElementClickable(webElement, 10);
        webElement.click();
    }

    /// <summary>
    /// Clicks on element by index using locator
    /// </summary>
    /// <param name="locator"></param>
    /// <param name="index"></param>
    protected void ClickElementByIndex(By locator, int index)
    {
        WaitUntilElementClickable(locator, 10);
        FindElements(locator).get(index).click();
    }

    /// <summary>
    /// Enters text by locator
    /// </summary>
    /// <param name="locator"></param>
    /// <param name="inputText"></param>
    protected void TypeInElement(By locator, String inputText)
    {
        WaitUntilElementDisplayed(locator, 10);
        Find(locator).sendKeys(inputText);
    }


    /// <summary>
    /// Checks whether element is displayed by locator
    /// </summary>
    /// <param name="locator"></param>
    /// <returns>True if the element is displayed, else false</returns>
    protected Boolean IsElementDisplayed(By locator)
    {
        return Find(locator).isDisplayed();
    }

    /// <summary>
    /// Checks whether element is displayed until the given
    /// max wait time
    /// </summary>
    /// <param name="locator"></param>
    /// <param name="maxWaitTime"></param>
    /// <returns>True if the element is displayed, else false</returns>
    protected <WebDriverTimeoutException> Boolean WaitUntilElementDisplayed(By locator, int maxWaitTime)
    {
        WebDriverWait wait = new WebDriverWait(Driver, (maxWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }
    protected <WebDriverTimeoutException> Boolean WaitUntilElementClickable(By locator, int maxWaitTime)
    {
        WebDriverWait wait = new WebDriverWait(Driver, (maxWaitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return true;
    }

    protected <WebDriverTimeoutException> Boolean WaitUntilElementClickable(WebElement webElement, int maxWaitTime)
    {
        WebDriverWait wait = new WebDriverWait(Driver, (maxWaitTime));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return true;
    }

    protected void ValidateField(WebElement field,String text, String Regex){

        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(text);
        Assert.assertTrue("Invalid Value in: "+text , matcher.matches());
    }

    public void clickOnElementUsingJavaScript(WebElement element) {


        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    //Creating file and writing to it
    public File CreateAFile() throws IOException {
        File file = new File("c://temp//testFile1.txt");

        //Create the file
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        return file;
    }

    public void WriteOntoFile(File file, String text) throws IOException {
        //Write Content
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.write("\n");
        writer.close();
    }

    public void CloseFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.close();
    }
}

