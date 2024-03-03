package api.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Класс базовых настроек для API-тестов
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class Specification {

    /**
     * Функция установки базовых настроек для запросов
     *
     * @param baseUrl  Базовый путь
     * @param basePath Базовый эндпоинт
     * @return базовые настройки запросов
     */
    public static RequestSpecification requestSpec(String baseUrl, String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .setContentType("application/json")
                .build();
    }

    /**
     * Функция установки базовых настроек для ответов
     *
     * @return базовые настройки ответов
     */
    public static ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .build();
    }

    /**
     * Функция инициализации базовых настроек
     *
     * @param request  Спецификация для запроса
     * @param response Спецификация для ответа
     */
    public static void installSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
