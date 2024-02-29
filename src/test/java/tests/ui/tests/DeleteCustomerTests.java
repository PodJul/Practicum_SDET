package tests.ui.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.CustomersPages;
import pages.HomePage;
import pages.RegistrationPage;
import pages.elements.BaseTest;

import java.util.List;

import static org.junit.Assert.assertFalse;

@Epic("Delete customer tests")
public class DeleteCustomerTests extends BaseTest {
    HomePage homePage;
    RegistrationPage regPage;
    CustomersPages custPage;

    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        regPage = new RegistrationPage(driver);
        custPage = new CustomersPages(driver);
    }

    @Test
    @DisplayName("Delete customer by first name length")
    public void deleteCustomersByFirstNameLength() {
        homePage.clickCustomersButton();
        List<String> customerFirstName = custPage
                .waitForLoadCustomersPage()
                .getCustomersNames();
        assertFalse(custPage.isCustomerDelete(customerFirstName));
    }
}