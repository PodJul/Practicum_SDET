package api.pogo;

import api.helpers.Addition;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Класс ответа сущности
 *
 * @author Юлия Подычан
 * @version 1.0
 */

public class EntityResponse {
    /**
     * Поле "id сущности"
     */
    private String id;
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
     * @param id{@link         EntityResponse#id}
     * @param addition         {@link EntityResponse#addition}
     * @param importantNumbers {@link EntityResponse#importantNumbers}
     * @param title            {@link EntityResponse#title}
     * @param verified         {@link EntityResponse#verified}
     */
    public EntityResponse(String id, Addition addition, List<Integer> importantNumbers, String title, boolean verified) {
        this.id = id;
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }

    /**
     * Дефолтный конструктор
     */
    public EntityResponse() {
    }

    /**
     * Функция получения значения поля {@link EntityResponse#id}
     *
     * @return возвращает id сущности
     */
    public String getId() {
        return id;
    }

    /**
     * Функция установления значения поля {@link EntityResponse#id}
     *
     * @param id id сущности
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Функция получения значения поля {@link EntityResponse#addition}
     *
     * @return возвращает дополнительную информацию о событии
     */
    public Addition getAddition() {
        return addition;
    }

    /**
     * Функция установления значения поля {@link EntityResponse#addition}
     *
     * @param addition дополнительная информация о событии
     */
    public void setAddition(Addition addition) {
        this.addition = addition;
    }

    /**
     * Функция получения значения поля {@link EntityResponse#importantNumbers}
     *
     * @return возвращает коллекцию важных чисел
     */
    public List<Integer> getImportantNumbers() {
        return importantNumbers;
    }

    /**
     * Функция установления значения поля {@link EntityResponse#importantNumbers}
     *
     * @param importantNumbers коллекция важных чисел
     */
    public void setImportantNumbers(List<Integer> importantNumbers) {
        this.importantNumbers = importantNumbers;
    }

    /**
     * Функция получения значения поля {@link EntityResponse#title}
     *
     * @return возвращает заголовок
     */
    public String getTitle() {
        return title;
    }

    /**
     * Функция установления значения поля {@link EntityResponse#title}
     *
     * @param title заголовок
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Функция получения значения поля {@link EntityResponse#verified}
     *
     * @return возвращает статус верификации
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * Функция установления значения поля {@link EntityResponse#verified}
     *
     * @param verified статус верификации
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
