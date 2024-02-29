package api.tests;

import api.helpers.Specification;
import org.junit.Before;

/**
 * Класс с настройками для запуска тестов
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class BaseApiTest {

    /**
     * Функция, устанавливающая значения baseUrl и basePath
     */
    @Before
    public void setUp() {
        Specification.installSpec(Specification.requestSpec("http://localhost:8080/", "api"), Specification.responseSpec());

    }
}
