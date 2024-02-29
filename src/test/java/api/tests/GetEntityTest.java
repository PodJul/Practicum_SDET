package api.tests;

import api.helpers.TestData;
import api.pogo.EntityResponse;
import api.requests.CreateEntityRequest;
import api.requests.DeleteEntityRequest;
import api.requests.ReadEntityRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Test;

import static java.lang.Integer.parseInt;

/**
 * Класс теста получения сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
@Epic("Get entity test")
public class GetEntityTest extends BaseApiTest {

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

    ReadEntityRequest readEntityRequest = new ReadEntityRequest();
    /**
     * /**
     * Экземпляр класса мягких ассертов
     */
    SoftAssertions softAssertion = new SoftAssertions();
    /**
     * id созданной сущности
     */
        String entityId;

    /**
     * Тестирует корректное получение сущности: код ответа 200,
     * сущность в теле ответа соответствует переданной сущности при создании
     *
     * @see ReadEntityRequest#getEntityById(String entityId)
     */
    @Test
    @DisplayName("Get entity and check body of response")
    public void getEntity() {

        entityId = createEntityRequest.createNewEntity(TestData.entity);
        /**
         * Тело ответа после запроса сущности по ее id
         */
        EntityResponse getResponse = readEntityRequest.getEntityById(entityId);
        softAssertion.assertThat(getResponse.getId().equals(parseInt(entityId)));
        softAssertion.assertThat(getResponse.getAddition().getAdditionalInfo().equals(TestData.fakeEntityAddInfo));
        softAssertion.assertThat(getResponse.getAddition().getAdditionalNumber()==TestData.fakeEntityAddNumber);
        softAssertion.assertThat(getResponse.getImportantNumbers().equals(TestData.fakeImportantNumbers));
        softAssertion.assertThat(getResponse.getTitle().equals(TestData.fakeTitle));
        softAssertion.assertThat(Boolean.compare(getResponse.isVerified(), TestData.fakeVerified) == 0);

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
