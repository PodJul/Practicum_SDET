package tests.ui.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.CustomersPages;
import pages.HomePage;
import pages.RegistrationPage;
import pages.elements.BaseTest;
import pages.elements.TestData;

import static org.junit.Assert.*;

@Epic("Add customer tests")
public class NewCustomerTests extends BaseTest {
    HomePage homePage;
    RegistrationPage regPage;
    CustomersPages custPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        regPage = new RegistrationPage(driver);
        custPage = new CustomersPages(driver);
    }

    @Feature("Tests with filled fields")
    @Test
    @DisplayName("Create new customer")
    public void createNewCustomer() {
        homePage.clickAddCustomerButton();
        regPage.createCustomer(TestData.fakeLastName, TestData.fakePostCode);
        assertTrue(regPage.getTextFromAlert().contains("Customer added successfully with customer id :"));
    }

    @Feature("Tests with filled fields")
    @Test
    @DisplayName("Create double customer")
    public void createDoubleCustomer() {
        homePage.clickAddCustomerButton();
        regPage.createDoubleCustomer(TestData.fakeFirstName, TestData.fakeLastName, TestData.fakePostCode);
        assertEquals("Please check the details. Customer may be duplicate.", regPage.getTextFromAlert());
    }

    @Feature("Tests with empty fields")
    @Test
    @DisplayName("Create new customer with empty fields")
    public void createNewCustomerWithEmptyFields() {
        homePage.clickAddCustomerButton();
        regPage.createCustomer2("", "", "");
        homePage.clickCustomersButton();
        assertFalse(custPage.checkNullFirstName());
    }

    @Feature("Tests with empty fields")
    @Test
    @DisplayName("Create new customer with empty first name field")
    public void createNewCustomerWithEmptyFirstNameField() {
        homePage.clickAddCustomerButton();
        regPage.createCustomer2("", TestData.fakeLastName, TestData.fakePostCode);
        homePage.clickCustomersButton();
        assertFalse(custPage.checkNullFirstName());

    }

    @Feature("Tests with empty fields")
    @Test
    @DisplayName("Create new customer with empty last name field")
    public void createNewCustomerWithEmptyLastNameField() {
        homePage.clickAddCustomerButton();
        regPage.createCustomer2(TestData.fakeFirstName, "", TestData.fakePostCode);
        homePage.clickCustomersButton();
        assertFalse(custPage.checkNullLastName());
    }

    @Feature("Tests with empty fields")
    @Test
    @DisplayName("Create new customer with empty post code field")
    public void createNewCustomerWithEmptyPostCodeField() {
        homePage.clickAddCustomerButton();
        regPage.createCustomer2(TestData.fakeFirstName, TestData.fakeLastName, "");
        homePage.clickCustomersButton();
        assertFalse(custPage.checkNullPostCode());
    }
}
