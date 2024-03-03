package api.tests;

import api.helpers.TestData;
import api.pogo.AllEntitiesResponse;
import api.requests.ReadEntityRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.junit4.DisplayName;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс теста получения всех сущностей
 *
 * @author Юлия Подычан
 * @version 1.0
 */
@Epic("Get all entities tests")
public class GetAllEntitiesTests extends BaseApiTest {
    //Экземпляр класса ReadEntityRequest
    ReadEntityRequest readEntityRequest = new ReadEntityRequest();
    //Экземпляр класса мягких ассертов
    SoftAssertions softAssertion = new SoftAssertions();
    //Тело ответа после запроса всех сущностей без применения фильтров
    AllEntitiesResponse getAllResponse;
    //Тело ответа после запроса всех сущностей с применением фильтров
    AllEntitiesResponse getAllResponseWithParam;

    /**
     * Тестирует корректное получение всех сущностей запросом без фильтров: код ответа 200,
     * в теле ответа- не пустой массив сущностей.
     *
     * @see ReadEntityRequest#getAllEntitiesWithoutParams()
     */
    @Test
    @DisplayName("Get all entity without parameters and check body of response")
    public void getAllEntitiesWithoutParameters() {
        getAllResponse = readEntityRequest.getAllEntitiesWithoutParams();
        assertThat(getAllResponse.getEntity().size() > 0);
    }

    /**
     * Тестирует корректное получение всех сущностей запросом с фильтрами: код ответа 200,
     * в теле ответа- номер страницы,количество сущностей на странице и в массиве соответствуют переданным параметрам
     *
     * @see ReadEntityRequest#getAllEntitiesWithParams(String title, boolean verified, int page, int perPage)
     */
    @Test
    @DisplayName("Get all entity with parameters and check body of response")
    public void getAllEntitiesWithParameters() {
        getAllResponse = readEntityRequest.getAllEntitiesWithoutParams();
        //Случайный заголовок из списка сущностей
        String testTitle = getAllResponse.getEntity().get(0).getTitle();
        //Случайный статус верификации из списка сущностей
        boolean testVerified = getAllResponse.getEntity().get(0).isVerified();
        getAllResponseWithParam = readEntityRequest
                .getAllEntitiesWithParams(testTitle, testVerified, TestData.testPage, TestData.testRerPage);
        readEntityRequest.checkTitlesAndVerified(getAllResponseWithParam, testTitle, testVerified);
        softAssertion.assertThat(getAllResponseWithParam.getPage() == TestData.testPage);
        softAssertion.assertThat(getAllResponseWithParam.getPerPage() == TestData.testRerPage);
        softAssertion.assertThat(getAllResponseWithParam.getEntity().size() == TestData.testRerPage);
    }
}
