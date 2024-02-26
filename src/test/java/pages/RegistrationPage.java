package pages;

import pages.elements.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.elements.Wait;

public class RegistrationPage extends Wait {
    WebDriver driver;

    @FindBy(xpath = ".//*[@ng-model='fName']")
    private WebElement firstNameField;

    @FindBy(xpath = ".//*[@ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(xpath = ".//*[@ng-model='postCd']")
    private WebElement postCodeField;

    @FindBy(xpath = ".//*[text()='Add Customer']")
    private WebElement addButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Step("Wait for load registration page")
    public RegistrationPage waitForLoadRegPage() {
        waitUntilClickable(driver, firstNameField);
        return this;
    }

    @Step("Set first name")
    public RegistrationPage setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Set last name")
    public RegistrationPage setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Set post code")
    public RegistrationPage setPostCode(String postCode) {
        postCodeField.sendKeys(postCode);
        return this;
    }

    @Step("Click add customer button")
    public RegistrationPage clickAddButton() {
        addButton.click();
        return this;
    }

    @Step("Create customer")
    public RegistrationPage createCustomer(String lastName, String postCode) {
        waitForLoadRegPage()
                .setFirstName(TestData.createFirstName(postCode))
                .setLastName(lastName)
                .setPostCode(postCode)
                .clickAddButton();
        return this;
    }

    @Step("Create customer")
    public void createCustomer2(String firstName, String lastName, String postCode) {
        waitForLoadRegPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPostCode(postCode)
                .clickAddButton();
    }

    @Step("Create double customer")
    public void createDoubleCustomer(String firstName, String lastName, String postCode) {
        String doubleFirstName = firstName;
        String doubleLastName = lastName;
        String doublePostCode = postCode;
        waitForLoadRegPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPostCode(postCode)
                .clickAddButton()
                .acceptAlert()
                .setFirstName(doubleFirstName)
                .setLastName(doubleLastName)
                .setPostCode(doublePostCode)
                .clickAddButton();
    }

    @Step("Switch to alert and get text")
    public String getTextFromAlert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Step("Accept the alert")
    public RegistrationPage acceptAlert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}
