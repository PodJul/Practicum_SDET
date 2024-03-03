package api.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Класс дополнительной информации о событии
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class Addition {
    /**
     * Поле "Дополнительные сведения о сущности"
     */
    @JsonProperty("additional_info")
    private String additionalInfo;
    /**
     * Поле "Дополнительное число для сущности"
     */
    @JsonProperty("additional_number")
    private int additionalNumber;
    /**
     * Поле "id дополнительной информации"
     */
    private int id;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param additionalInfo   {@link Addition#additionalInfo}
     * @param additionalNumber {@link Addition#additionalNumber}
     */
    public Addition(String additionalInfo, int additionalNumber) {
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
    }

    /**
     * Дефолтный конструктор
     */
    public Addition() {
    }

    /**
     * Функция получения значения поля {@link Addition#additionalInfo}
     *
     * @return возвращает дополнительные сведения о сущности
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Функция установления значения поля {@link Addition#additionalInfo}
     *
     * @param additionalInfo дополнительные сведения о сущности
     * @return возвращает событие с дополнительными сведениями о сущности
     */
    public Addition setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Функция получения значения поля {@link Addition#additionalNumber}
     *
     * @return возвращает дополнительное число для сущности
     */
    public int getAdditionalNumber() {
        return additionalNumber;
    }

    /**
     * Функция установления значения поля {@link Addition#additionalNumber}
     *
     * @param additionalNumber дополнительное число для сущности
     */
    public void setAdditionalNumber(int additionalNumber) {
        this.additionalNumber = additionalNumber;
    }

    /**
     * Функция получения значения поля {@link Addition#id}
     *
     * @return возвращает идентификатор дополнительной информации
     */
    public int getId() {
        return id;
    }

    /**
     * Функция установления значения поля {@link Addition#id}
     *
     * @param id идентификатор дополнительной информации
     */
    public void setId(int id) {
        this.id = id;
    }
}
