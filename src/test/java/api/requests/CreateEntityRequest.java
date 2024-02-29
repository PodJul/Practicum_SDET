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
public class CreateEntityRequest {

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
     * @param addition         {@link CreateEntityRequest#addition}
     * @param importantNumbers {@link CreateEntityRequest#importantNumbers}
     * @param title            {@link CreateEntityRequest#title}
     * @param verified         {@link CreateEntityRequest#verified}
     */
    public CreateEntityRequest(Addition addition, List<Integer> importantNumbers, String title, boolean verified) {

        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }

    /**
     * Дефолтный конструктор
     */
    public CreateEntityRequest() {

    }

    /**
     * Функция получения значения поля {@link CreateEntityRequest#addition}
     *
     * @return возвращает дополнительную информацию о событии
     */
    public Addition getAddition() {
        return addition;
    }

    /**
     * Функция установления значения поля {@link CreateEntityRequest#addition}
     *
     * @param addition дополнительная информация о событии
     * @return возвращает сущность с дополнительной информацией о событии
     */
    public CreateEntityRequest setAddition(Addition addition) {
        this.addition = addition;
        return this;
    }

    /**
     * Функция получения значения поля {@link CreateEntityRequest#importantNumbers}
     *
     * @return возвращает коллекцию важных чисел
     */
    public List<Integer> getImportantNumbers() {
        return importantNumbers;
    }

    /**
     * Функция установления значения поля {@link CreateEntityRequest#importantNumbers}
     *
     * @param importantNumbers коллекция важных чисел
     * @return возвращает сущность с коллекцией важных чисел
     */
    public CreateEntityRequest setImportantNumbers(List<Integer> importantNumbers) {
        this.importantNumbers = importantNumbers;
        return this;
    }

    /**
     * Функция получения значения поля {@link CreateEntityRequest#title}
     *
     * @return возвращает заголовок
     */
    public String getTitle() {
        return title;
    }

    /**
     * Функция установления значения поля {@link CreateEntityRequest#title}
     *
     * @param title заголовок
     * @return возвращает сущность с заголовком
     */

    public CreateEntityRequest setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Функция получения значения поля {@link CreateEntityRequest#verified}
     *
     * @return возвращает статус верификации
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Функция установления значения поля {@link CreateEntityRequest#verified}
     *
     * @param verified статус верификации
     * @return возвращает сущность со статусом верификации
     */
    public CreateEntityRequest setVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    /**
     * Метод создания сущности
     *
     * @param entity передаваемая сущность
     * @return возвращает id созданной сущности в формате String
     */
    @Step("Send POST request to /api/create and check statusCode")
    public String createNewEntity(CreateEntityRequest entity) {
        return given()
                .body(entity)
                .when()
                .post("/create")
                .then()
                .statusCode(200)
                .extract().body().asString();

    }
}
