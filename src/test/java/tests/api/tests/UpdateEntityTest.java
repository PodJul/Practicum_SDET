package tests.api.tests;

import pages.elements.EntityMethods;
import pages.elements.TestDataAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Test;
import tests.api.tests.SetupTest;

import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.equalTo;

@Epic("Update entity test")
public class UpdateEntityTest extends SetupTest {
    EntityMethods entityMethod = new EntityMethods();
    String entityId;
    SoftAssertions softAssertion = new SoftAssertions();


    @Test
    @DisplayName("Update entity and check body of response")
    public void updateEntity() {

        entityId = entityMethod.createNewEntity(TestDataAPI.entity);
        String updateResponse = entityMethod.updateEntityById(TestDataAPI.newEntity, entityId);
        softAssertion.assertThat(updateResponse.isBlank());
        ValidatableResponse getResponse = entityMethod.getEntityById(entityId);
        getResponse.assertThat().body("id", equalTo(parseInt(entityId)), "addition.additional_info", equalTo(TestDataAPI.newFakeEntityAddInfo),
                "addition.additional_number", equalTo(TestDataAPI.newFakeEntityAddNumber), "important_numbers", equalTo(TestDataAPI.newFakeImportantNumbers),
                "title", equalTo(TestDataAPI.newFakeTitle), "verified", equalTo(TestDataAPI.newFakeVerified));
    }

    @After
    public void deleteEntity() {
        entityMethod.deleteEntityById(entityId);
    }
}
