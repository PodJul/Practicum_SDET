package tests.api.tests;

import pages.elements.EntityMethods;
import pages.elements.TestDataAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

@Epic("Create entity test")
public class CreateEntityTest extends SetupTest {

    EntityMethods entityMethod = new EntityMethods();
    String entityId;

    @Test
    @DisplayName("Create new entity and check body of response")
    public void createNewEntity() {

        entityId = entityMethod.createNewEntity(TestDataAPI.entity);
        Assert.assertTrue(notNullValue().matches(entityId));
    }

    @After
    public void deleteEntity() {
        entityMethod.deleteEntityById(entityId);
    }
}
