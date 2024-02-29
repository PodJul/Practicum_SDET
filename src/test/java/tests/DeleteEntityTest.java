package tests;

import pages.elements.EntityMethods;
import pages.elements.TestDataAPI;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Epic("Delete entity test")
public class DeleteEntityTest extends SetupTest {
    EntityMethods entityMethod = new EntityMethods();
    String entityId;
    String removalResponse;

    @Test
    @DisplayName("Delete entity and check body of response")
    public void deleteEntity() {

        entityId = entityMethod.createNewEntity(TestDataAPI.entity);
        removalResponse = entityMethod.deleteEntityById(entityId);
        Assert.assertTrue(removalResponse.isBlank());
    }
}
