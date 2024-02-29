package api.pogo;


import java.util.List;

/**
 * Класс коллекции всех сущностей
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class AllEntitiesResponse {

    /**
     * Поле "Коллекция сущностей"
     */
    private List<EntityResponse> entity;
    /**
     * Поле "Номер страницы"
     */
    int page;
    /**
     * Поле "Количество сущностей на странице"
     */
    int perPage;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param entity  {@link AllEntitiesResponse#entity}
     * @param page    {@link AllEntitiesResponse#page}
     * @param perPage {@link AllEntitiesResponse#perPage}
     */
    public AllEntitiesResponse(List<EntityResponse> entity, int page, int perPage) {
        this.entity = entity;
        this.page = page;
        this.perPage = perPage;
    }

    /**
     * Дефолтный конструктор
     */
    public AllEntitiesResponse() {
    }

    /**
     * Функция получения значения поля {@link AllEntitiesResponse#entity}
     *
     * @return возвращает коллекцию сущностей
     */
    public List<EntityResponse> getEntity() {
        return entity;
    }

    /**
     * Функция установления значения поля {@link AllEntitiesResponse#entity}
     *
     * @param entity коллекция сущностей
     */

    public void setEntity(List<EntityResponse> entity) {
        this.entity = entity;
    }

    /**
     * Функция получения значения поля {@link AllEntitiesResponse#page}
     *
     * @return возвращает страницу по номеру
     */
    public int getPage() {
        return page;
    }

    /**
     * Функция установления значения поля {@link AllEntitiesResponse#page}
     *
     * @param page номер страницы
     */

    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Функция получения значения поля {@link AllEntitiesResponse#perPage}
     *
     * @return возвращает заданное количество сущностей на странице
     */
    public int getPerPage() {
        return perPage;
    }

    /**
     * Функция установления значения поля {@link AllEntitiesResponse#perPage}
     *
     * @param perPage количество сущностей на странице
     */
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
