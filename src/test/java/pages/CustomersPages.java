package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersPages {
    WebDriver driver;

    @FindBy(xpath = ".//tr[contains (@ng-repeat,'cust in Customers ')]/td[1]")
    private List<WebElement> firstNames;

    @FindBy(xpath = ".//tr[contains (@ng-repeat,'cust in Customers ')]/td[2]")
    private List<WebElement> lastNames;

    @FindBy(xpath = ".//tr[contains (@ng-repeat,'cust in Customers ')]/td[3]")
    private List<WebElement> postCodes;

    @FindBy(xpath = ".//a[contains (@ng-click,'fName')]")
    private WebElement firstNameButton;

    public CustomersPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Wait for load customers page")
    public void waitForLoadCustomersPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(firstNameButton));
    }

    List<String> customersNames = new ArrayList<>();

    @Step("Get customers names")
    public List<String> getCustomersNames() {

        for (int i = 0; i < firstNames.size(); i++) {
            customersNames.add(firstNames.get(i).getText());
        }
        return customersNames;
    }

    @Step("Check null first name")
    public boolean checkNullFirstName() {
        return firstNames.contains(null) || firstNames.contains("");
    }

    @Step("Check null last name")
    public boolean checkNullLastName() {
        return lastNames.contains(null) || lastNames.contains("");
    }

    @Step("Check null post code")
    public boolean checkNullPostCode() {
        return postCodes.contains(null) || postCodes.contains("");
    }

    @Step("Check customer names were sorted ")
    public boolean isSorted(List<String> customersNames) {
        return customersNames.stream().sorted().collect(Collectors.toList()).equals(customersNames);
    }

    @Step("Check customer was deleted")
    public boolean isCustomerDelete(List<String> customersNames) {
        double avrLength = customersNames
                .stream()
                .mapToInt(p -> p.length())
                .average().getAsDouble();

        return customersNames
                .stream()
                .filter(p -> p.length() != (Math.round(avrLength) - 1))
                .filter(p -> p.length() != (Math.round(avrLength) + 1))
                .collect(Collectors.toList())
                .equals(customersNames);
    }
}

