package api.requests;

import api.pogo.AllEntitiesResponse;
import api.pogo.EntityResponse;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static io.restassured.RestAssured.given;

/**
 * Класс сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class ReadEntityRequest {
    /**
     * Поле "id"
     */
    private String id;

    /**
     * Тело ответа после запроса всех сущностей с применением фильтров
     */
    AllEntitiesResponse getAllResponseWithParam;
    /**
     * Экземпляр класса мягких ассертов
     */
    SoftAssertions softAssertion = new SoftAssertions();

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param id {@link ReadEntityRequest#id}
     */
    public ReadEntityRequest(String id) {

        this.id = id;
    }

    /**
     * Дефолтный конструктор
     */
    public ReadEntityRequest() {

    }

    /**
     * Функция получения значения поля {@link ReadEntityRequest#id}
     *
     * @return возвращает id сущности
     */
    public String getId() {
        return id;
    }

    /**
     * Функция установления значения поля {@link ReadEntityRequest#id}
     *
     * @param id id сущности
     * @return возвращает сущность с id
     */
    public ReadEntityRequest setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Метод получения сущности по id
     *
     * @param entityId id запрашиваемой сущности
     * @return возвращает сущность с заданным id
     */
    @Step("Send GET request to /api/get/{id} and check statusCode")
    public EntityResponse getEntityById(String entityId) {
        return given()
                .when()
                .get("/get/" + entityId)
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(EntityResponse.class);
    }

    /**
     * Метод получения всего перечня сущностей без применения фильтров
     *
     * @return возвращает массив всех сущностей
     */
    @Step("Send GET request to /api/getAll without parameters and check statusCode")
    public AllEntitiesResponse getAllEntitiesWithoutParams() {
        return given()
                .when()
                .get("/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(AllEntitiesResponse.class);

    }

    /**
     * Метод получения всего перечня сущностей с применением фильтров
     *
     * @param title    фильтр по заголовку
     * @param verified фильтр по статусу верификации
     * @param page     фильтр по странице
     * @param perPage  количество сущностей на странице
     * @return возвращает массив всех сущностей на определенной странице в заданном количестве (шт. на стр.)
     */
    @Step("Send GET request to /api/getAll with parameters and check statusCode")

    public AllEntitiesResponse getAllEntitiesWithParams(String title, boolean verified, int page, int perPage) {
        return given()
                .queryParams("title", title, "verified", verified, "page", page, "perPage", perPage)
                .when()
                .get("/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(AllEntitiesResponse.class);

    }

    @Step("Check title and verified fields")

    public void checkTitlesAndVerified(AllEntitiesResponse getAllResponseWithParam,String testTitle,boolean testVerified) {

        for (int i = 0; i < getAllResponseWithParam.getEntity().size(); i++) {
            softAssertion.assertThat(getAllResponseWithParam.getEntity().get(i).getTitle().equals(testTitle));
            softAssertion.assertThat(Boolean.compare(getAllResponseWithParam.getEntity().get(i).isVerified(),
                    testVerified) == 0);
        }
    }
}
