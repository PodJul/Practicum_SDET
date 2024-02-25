package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.CustomersPages;
import pages.HomePage;
import pages.RegistrationPage;
import pages.elements.BaseData;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Epic("Delete customer tests")
public class DeleteCustomerTests extends BaseData {
    HomePage objHomePage;
    RegistrationPage objRegPage;
    CustomersPages objCustPage;

    @Before
    public void setUp() {
        objHomePage = new HomePage(driver);
        objRegPage = new RegistrationPage(driver);
        objCustPage = new CustomersPages(driver);
    }

    @Test
    @DisplayName("Delete customer by first name length")
    public void deleteCustomersByFirstNameLength() {
        objHomePage.clickCustomersButton();
        objCustPage.waitForLoadCustomersPage();
        List<String> customerFirstName = objCustPage.getCustomersNames();
        objCustPage.isCustomerDelete(customerFirstName);
        assertEquals(false, objCustPage.isCustomerDelete(customerFirstName));
    }
}