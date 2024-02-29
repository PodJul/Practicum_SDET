package tests;

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

@Epic("Sort by first name tests")
public class SortFirstNameTests extends BaseTest {
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
    @DisplayName("Sort customers by first name")
    public void sortCustomersNames() {
        homePage.clickCustomersButton();
        List<String> customerFirstName = custPage
                .waitForLoadCustomersPage()
                .getCustomersNames();
        assertFalse(custPage.isSorted(customerFirstName));
    }
}