package tests.api.tests;

import pages.elements.EntityMethods;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import pogo.AllEntitiesResponse;

@Epic("Get all entities tests")
public class GetAllEntitiesTests extends SetupTest {

    EntityMethods entityMethod = new EntityMethods();
    SoftAssertions softAssertion = new SoftAssertions();
    AllEntitiesResponse getAllResponse;
    AllEntitiesResponse getAllResponseWithParam;

    @Test
    @DisplayName("Get all entity without parameters and check body of response")
    public void getAllEntitiesWithoutParameters() {

        getAllResponse = entityMethod.getAllEntitiesWithoutParams();
        Assert.assertTrue(getAllResponse.getEntity().size() > 0);
    }


    @Test
    @DisplayName("Get all entity with parameters and check body of response")
    public void getAllEntitiesWithParameters() {

        getAllResponse = entityMethod.getAllEntitiesWithoutParams();
        String testTitle = getAllResponse.getEntity().get(0).getTitle();
        boolean testVerified = getAllResponse.getEntity().get(0).isVerified();
        int testPage = 2;
        int testRerPage = 3;
        getAllResponseWithParam = entityMethod.getAllEntitiesWithParams(testTitle, testVerified, testPage, testRerPage);

        for (int i = 0; i < getAllResponseWithParam.getEntity().size(); i++) {
            softAssertion.assertThat(getAllResponseWithParam.getEntity().get(i).getTitle().equals(testTitle));
            softAssertion.assertThat(Boolean.compare(getAllResponseWithParam.getEntity().get(i).isVerified(), testVerified) == 0);
        }

        softAssertion.assertThat(getAllResponseWithParam.getPage() == testPage);
        softAssertion.assertThat(getAllResponseWithParam.getPerPage() == testRerPage);
        softAssertion.assertThat(getAllResponseWithParam.getEntity().size() == testRerPage);
    }

}
