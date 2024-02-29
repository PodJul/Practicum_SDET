package api.tests;

import api.helpers.TestData;
import api.pogo.EntityResponse;
import api.requests.CreateEntityRequest;
import api.requests.DeleteEntityRequest;
import api.requests.ReadEntityRequest;
import api.requests.UpdateEntityRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Test;

import static java.lang.Integer.parseInt;

/**
 * Класс теста обновления сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
@Epic("Update entity test")
public class UpdateEntityTest extends BaseApiTest {


    /**
     * Экземпляр класса CreateEntityRequest
     */

    CreateEntityRequest createEntityRequest = new CreateEntityRequest();
    /**
     * Экземпляр класса DeleteEntityRequest
     */

    DeleteEntityRequest deleteEntityRequest = new DeleteEntityRequest();
    /**
     * Экземпляр класса ReadEntityRequest
     */

    UpdateEntityRequest updateEntityRequest = new UpdateEntityRequest();
    /**
     * Экземпляр класса ReadEntityRequest
     */

    ReadEntityRequest readEntityRequest = new ReadEntityRequest();
    /**
     * id созданной сущности
     */
    String entityId;
    /**
     * Экземпляр класса мягких ассертов
     */
    SoftAssertions softAssertion = new SoftAssertions();

    /**
     * Тестирует корректное обновление сущности: код ответа 204, пустое тело ответа.
     * Запрашивает обновленную сущность по id
     * Сущность в теле ответа содержит все изменения
     *
     * @see UpdateEntityRequest#updateEntityById(CreateEntityRequest newEntity, String entityId)
     */

    @Test
    @DisplayName("Update entity and check body of response")
    public void updateEntity() {

        entityId = createEntityRequest.createNewEntity(TestData.entity);
        /**
         * Тело ответа после обновления сущности
         */
        String updateResponse = updateEntityRequest.updateEntityById(TestData.newEntity, entityId);
        softAssertion.assertThat(updateResponse.isBlank());
        /**
         * Тело ответа после запроса сущности по ее id
         */
        EntityResponse getResponse = readEntityRequest.getEntityById(entityId);

        softAssertion.assertThat(getResponse.getId().equals(parseInt(entityId)));
        softAssertion.assertThat(getResponse.getAddition().getAdditionalInfo().equals(TestData.newFakeEntityAddInfo));
        softAssertion.assertThat(getResponse.getAddition().getAdditionalNumber()==TestData.newFakeEntityAddNumber);
        softAssertion.assertThat(getResponse.getImportantNumbers().equals(TestData.newFakeImportantNumbers));
        softAssertion.assertThat(getResponse.getTitle().equals(TestData.newFakeTitle));
        softAssertion.assertThat(Boolean.compare(getResponse.isVerified(), TestData.newFakeVerified) == 0);

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
