package api.helpers;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Класс методов для генерации случайных полей
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class EntityGenerator {
    Faker faker = new Faker(new Locale("en-RU"));
    //Случайное число для описания размера массива
    int n = faker.number().randomDigit();
    List<Integer> importantNumbers = new ArrayList<>();

    /**
     * Функция генерации случайных дополнительных сведений о сущности
     *
     * @return возвращает additional_info
     */
    public String fakeEntityAddInfo() {
        return faker.lorem().sentence();
    }

    /**
     * Функция генерации случайного дополнительного числа для сущности
     *
     * @return возвращает additional_number
     */
    public int fakeEntityAddNumber() {
        return faker.number().numberBetween(1, 1000);
    }

    /**
     * Функция генерации случайного заголовка сущности
     *
     * @return возвращает title
     */
    public String fakeEntityTitle() {
        return faker.name().title();
    }

    /**
     * Функция генерации случайного статуса верификации сущности
     *
     * @return возвращает verified
     */
    public boolean fakeEntityVerified() {
        return faker.random().nextBoolean();
    }

    /**
     * Функция генерации случайного массива важных чисел для сущности
     *
     * @return возвращает important_numbers
     */
    public List<Integer> fakeEntityImportantNumbers() {
        for (int i = 0; i < n; i++) {
            importantNumbers.add(i, faker.number().numberBetween(0, 100));
        }
        return importantNumbers;
    }
}
