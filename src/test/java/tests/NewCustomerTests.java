package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.CustomersPages;
import pages.HomePage;
import pages.RegistrationPage;
import pages.elements.BaseData;
import pages.elements.TestData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Epic("Add customer tests")
public class NewCustomerTests extends BaseData {
    HomePage objHomePage;
    RegistrationPage objRegPage;
    CustomersPages objCustPage;

    @Before
    public void setUp() {
        objHomePage = new HomePage(driver);
        objRegPage = new RegistrationPage(driver);
        objCustPage = new CustomersPages(driver);
    }

    @Feature("Positive tests")
    @Test
    @DisplayName("Create new customer")
    public void createNewCustomer() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createCustomer(TestData.fakeLastName, TestData.fakePostCode);
        assertTrue(objRegPage.getTextFromAlert().contains("Customer added successfully with customer id :"));
    }

    @Feature("Positive tests")
    @Test
    @DisplayName("Create double customer")
    public void createDoubleCustomer() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createDoubleCustomer(TestData.fakeFirstName, TestData.fakeLastName, TestData.fakePostCode);
        assertEquals("Please check the details. Customer may be duplicate.", objRegPage.getTextFromAlert());
    }

    @Feature("Negative tests")
    @Test
    @DisplayName("Create new customer with empty fields")
    public void createNewCustomerWithEmptyFields() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createCustomer2("", "", "");
        objHomePage.clickCustomersButton();
        assertEquals(false, objCustPage.checkNullFirstName());
    }

    @Feature("Negative tests")
    @Test
    @DisplayName("Create new customer with empty first name field")
    public void createNewCustomerWithEmptyFirstNameField() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createCustomer2("", TestData.fakeLastName, TestData.fakePostCode);
        objHomePage.clickCustomersButton();
        assertEquals(false, objCustPage.checkNullFirstName());

    }

    @Feature("Negative tests")
    @Test
    @DisplayName("Create new customer with empty last name field")
    public void createNewCustomerWithEmptyLastNameField() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createCustomer2(TestData.fakeFirstName, "", TestData.fakePostCode);
        objHomePage.clickCustomersButton();
        assertEquals(false, objCustPage.checkNullLastName());
    }

    @Feature("Negative tests")
    @Test
    @DisplayName("Create new customer with empty post code field")
    public void createNewCustomerWithEmptyPostCodeField() {
        objHomePage.clickAddCustomerButton();
        objRegPage.createCustomer2(TestData.fakeFirstName, TestData.fakeLastName, "");
        objHomePage.clickCustomersButton();
        assertEquals(false, objCustPage.checkNullPostCode());
    }
}
