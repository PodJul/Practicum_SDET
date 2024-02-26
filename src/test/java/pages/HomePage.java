package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.elements.Wait;

public class HomePage extends Wait {
    WebDriver driver;

    @FindBy(xpath = ".//*[@ng-click='addCust()']")
    private WebElement addCustomerButton;
    @FindBy(xpath = ".//*[@ng-click='showCust()']")
    private WebElement customersButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Wait for load home page")
    public HomePage waitForLoadHomePage() {
        waitUntilClickable(driver, addCustomerButton);
        return this;
    }

    @Step("Click add customer button")
    public void clickAddCustomerButton() {
        waitForLoadHomePage()
                .addCustomerButton.click();

    }

    @Step("Click customers button")
    public void clickCustomersButton() {
        waitForLoadHomePage()
                .customersButton.click();
    }

}
