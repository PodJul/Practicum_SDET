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

public class RegistrationPage {
    WebDriver driver;

    @FindBy(xpath = ".//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = ".//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = ".//input[@placeholder='Post Code']")
    private WebElement postCodeField;

    @FindBy(xpath = ".//div[@class='marTop']//button[contains(text(),'Add Customer')]")
    private WebElement addButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @Step("Wait for load registration page")
    public void waitForLoadRegPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(firstNameField));
    }

    @Step("Set first name")
    public void setFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    @Step("Set last name")
    public void setLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    @Step("Set post code")
    public void setPostCode(String postCode) {
        postCodeField.sendKeys(postCode);
    }

    @Step("Click add customer button")
    public void clickAddButton() {
        addButton.click();
    }

    @Step("Create customer")
    public void createCustomer(String lastName, String postCode) {
        waitForLoadRegPage();
        setFirstName(TestData.createFirstName(postCode));
        setLastName(lastName);
        setPostCode(postCode);
        clickAddButton();
    }

    @Step("Create customer")
    public void createCustomer2(String firstName, String lastName, String postCode) {
        waitForLoadRegPage();
        setFirstName(firstName);
        setLastName(lastName);
        setPostCode(postCode);
        clickAddButton();
    }
    @Step("Create double customer")
    public void createDoubleCustomer(String firstName, String lastName, String postCode) {
        waitForLoadRegPage();
        setFirstName(firstName);
        setLastName(lastName);
        setPostCode(postCode);
        clickAddButton();
        String doubleFirstName=firstName;
        String doubleLastName=lastName;
        String doublePostCode=postCode;
        acceptAlert();
        setFirstName(doubleFirstName);
        setLastName(doubleLastName);
        setPostCode(doublePostCode);
        clickAddButton();
    }

    @Step("Switch to alert and get text")
    public String getTextFromAlert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Step("Accept the alert")
    public void acceptAlert() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
