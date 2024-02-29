package tests;

import pages.elements.EntityMethods;
import pages.elements.TestDataAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.equalTo;

@Epic("Get entity test")
public class GetEntityTest extends SetupTest {
    EntityMethods entityMethod = new EntityMethods();
    String entityId;

    @Test
    @DisplayName("Get entity and check body of response")
    public void getEntity() {

        entityId = entityMethod.createNewEntity(TestDataAPI.entity);
        ValidatableResponse getResponse = entityMethod.getEntityById(entityId);
        getResponse.assertThat().body("id", equalTo(parseInt(entityId)), "addition.additional_info", equalTo(TestDataAPI.fakeEntityAddInfo),
                "addition.additional_number", equalTo(TestDataAPI.fakeEntityAddNumber), "important_numbers", equalTo(TestDataAPI.fakeImportantNumbers),
                "title", equalTo(TestDataAPI.fakeTitle), "verified", equalTo(TestDataAPI.fakeVerified));
    }

    @After
    public void deleteEntity() {
        entityMethod.deleteEntityById(entityId);
    }
}
