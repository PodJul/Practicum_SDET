package api.requests;

import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

/**
 * Класс сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class DeleteEntityRequest {
    /**
     * Поле "id"
     */
    private String id;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param id {@link DeleteEntityRequest#id}
     */
    public DeleteEntityRequest(String id) {
        this.id = id;
    }

    /**
     * Дефолтный конструктор
     */
    public DeleteEntityRequest() {
    }

    /**
     * Функция получения значения поля {@link DeleteEntityRequest#id}
     *
     * @return возвращает id сущности
     */
    public String getId() {
        return id;
    }

    /**
     * Функция установления значения поля {@link DeleteEntityRequest#id}
     *
     * @param id id сущности
     * @return возвращает сущность с id
     */
    public DeleteEntityRequest setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Метод удаления сущности
     *
     * @param entityId id удаляемой сущности
     * @return возвращает ответ от сервера в формате String
     */
    @Step("Send DELETE request to /api/delete/{id} and check statusCode")
    public String deleteEntityById(String entityId) {
        return given()
                .when()
                .delete("/delete/" + entityId)
                .then()
                .statusCode(204)
                .extract().body().asString();
    }
}
