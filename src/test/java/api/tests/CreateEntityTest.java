package api.tests;

import api.helpers.TestData;
import api.requests.CreateEntityRequest;
import api.requests.DeleteEntityRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Класс теста создания сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
@Epic("Create entity test")
public class CreateEntityTest extends BaseApiTest {

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
     * Тестирует корректное создание сущности: код ответа 200, непустое тело ответа.
     *
     * @see CreateEntityRequest#createNewEntity(CreateEntityRequest entity)
     */
    @Test
    @DisplayName("Create new entity and check body of response")
    public void createNewEntity() {

        entityId = createEntityRequest.createNewEntity(TestData.entity);
        Assert.assertTrue(notNullValue().matches(entityId));
    }

    /**
     * Удаление тестовых данных
     *
     * @see DeleteEntityRequest#deleteEntityById(String entityId)
     */
    @After
    public void deleteEntity() {
        deleteEntityRequest.deleteEntityById(entityId);
    }
}
