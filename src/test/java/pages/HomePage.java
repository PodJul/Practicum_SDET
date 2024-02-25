package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;


    @FindBy(xpath = ".//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;
    @FindBy(xpath = ".//button[contains(text(),'Customers')]")
    private WebElement customersButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Wait for load home page")
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(addCustomerButton));
    }

    @Step("Click add customer button")
    public void clickAddCustomerButton() {
        waitForLoadHomePage();
        addCustomerButton.click();
    }

    @Step("Click customers button")
    public void clickCustomersButton() {
        waitForLoadHomePage();
        customersButton.click();
    }

}
