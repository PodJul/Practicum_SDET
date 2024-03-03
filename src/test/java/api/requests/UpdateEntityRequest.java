package api.requests;

import api.helpers.Addition;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.qameta.allure.Step;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Класс сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class UpdateEntityRequest {
    /**
     * Поле "Дополнительная информация о событии"
     */
    private Addition addition;
    /**
     * Поле "Коллекция важных чисел"
     */
    @JsonProperty("important_numbers")
    private List<Integer> importantNumbers;
    /**
     * Поле "Заголовок"
     */
    private String title;
    /**
     * Поле "Статус верификации"
     */
    private boolean verified;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param addition         {@link UpdateEntityRequest#addition}
     * @param importantNumbers {@link UpdateEntityRequest#importantNumbers}
     * @param title            {@link UpdateEntityRequest#title}
     * @param verified         {@link UpdateEntityRequest#verified}
     */
    public UpdateEntityRequest(Addition addition, List<Integer> importantNumbers, String title, boolean verified) {
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }

    /**
     * Дефолтный конструктор
     */
    public UpdateEntityRequest() {
    }

    /**
     * Функция получения значения поля {@link UpdateEntityRequest#addition}
     *
     * @return возвращает дополнительную информацию о событии
     */
    public Addition getAddition() {
        return addition;
    }

    /**
     * Функция установления значения поля {@link UpdateEntityRequest#addition}
     *
     * @param addition дополнительная информация о событии
     * @return возвращает сущность с дополнительной информацией о событии
     */
    public UpdateEntityRequest setAddition(Addition addition) {
        this.addition = addition;
        return this;
    }

    /**
     * Функция получения значения поля {@link UpdateEntityRequest#importantNumbers}
     *
     * @return возвращает коллекцию важных чисел
     */
    public List<Integer> getImportantNumbers() {
        return importantNumbers;
    }

    /**
     * Функция установления значения поля {@link UpdateEntityRequest#importantNumbers}
     *
     * @param importantNumbers коллекция важных чисел
     * @return возвращает сущность с коллекцией важных чисел
     */
    public UpdateEntityRequest setImportantNumbers(List<Integer> importantNumbers) {
        this.importantNumbers = importantNumbers;
        return this;
    }

    /**
     * Функция получения значения поля {@link UpdateEntityRequest#title}
     *
     * @return возвращает заголовок
     */
    public String getTitle() {
        return title;
    }

    /**
     * Функция установления значения поля {@link UpdateEntityRequest#title}
     *
     * @param title заголовок
     * @return возвращает сущность с заголовком
     */
    public UpdateEntityRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Функция получения значения поля {@link UpdateEntityRequest#verified}
     *
     * @return возвращает статус верификации
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Функция установления значения поля {@link UpdateEntityRequest#verified}
     *
     * @param verified статус верификации
     * @return возвращает сущность со статусом верификации
     */
    public UpdateEntityRequest setVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    /**
     * Метод изменения сущности по id
     *
     * @param entityId  id изменяемой сущности
     * @param newEntity передаваемые изменения сущности
     * @return возвращает измененную сущность
     */
    @Step("Send PATCH request to /api/patch/{id} and check statusCode")
    public String updateEntityById(CreateEntityRequest newEntity, String entityId) {
        return given()
                .body(newEntity)
                .when()
                .patch("/patch/" + entityId)
                .then()
                .statusCode(204)
                .extract().asString();
    }
}
