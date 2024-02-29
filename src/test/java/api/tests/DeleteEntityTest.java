package api.tests;

import api.helpers.TestData;
import api.requests.CreateEntityRequest;
import api.requests.DeleteEntityRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

/**
 * Класс теста удаления сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
@Epic("Delete entity test")
public class DeleteEntityTest extends BaseApiTest {
    /**
     * Экземпляр класса CreateEntityRequest
     */

    CreateEntityRequest createEntityRequest = new CreateEntityRequest();

    /**
     * Экземпляр класса DeleteEntityRequest
     */

    DeleteEntityRequest deleteEntityRequest = new DeleteEntityRequest();
    /**
     * id созданной сущности
     */
    String entityId;
    /**
     * тело ответа после удаления
     */
    String removalResponse;

    /**
     * Тестирует корректное удаление сущности: код ответа 204, пустое тело ответа.
     *
     * @see DeleteEntityRequest#deleteEntityById(String entityId)
     */

    @Test
    @DisplayName("Delete entity and check body of response")
    public void deleteEntity() {

        entityId = createEntityRequest.createNewEntity(TestData.entity);
        removalResponse = deleteEntityRequest.deleteEntityById(entityId);
        Assert.assertTrue(removalResponse.isBlank());
    }
}
