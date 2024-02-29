package api.helpers;

import api.pogo.AllEntitiesResponse;
import api.requests.CreateEntityRequest;

import java.util.List;

/**
 * Класс генерации тестовых данных
 *
 * @version 1.0
 * @author Юлия Подычан
 */
public class TestData {
    /**
     * Тело ответа после запроса всех сущностей без применения фильтров
     */
    AllEntitiesResponse getAllResponse;

    /**
     * Экземпляр генератора сущности №1
     */
    static EntityGenerator entityGenerator = new EntityGenerator();

    /**
     * Экземпляр генератора сущности №2
     */
    static EntityGenerator newEntityGenerator = new EntityGenerator();

    /**
     * Экземпляр дополнительной информации о событии №1
     */
    static Addition addition = new Addition();

    /**
     * Экземпляр дополнительной информации о событии №2
     */
    static Addition newAddition = new Addition();

    /**
     * Метод добавления в дополнительную информации о событии №1 сгенерированных дополнительных сведений {@link  TestData#fakeEntityAddInfo}
     * и дополнительного числа для сущности {@link  TestData#fakeEntityAddInfo}
     *
     * @return возвращает дополнительную информацию о событии №1
     */
    public static Addition getFakeAddition() {
        addition.setAdditionalInfo(fakeEntityAddInfo).setAdditionalNumber(fakeEntityAddNumber);
        return addition;
    }

    /**
     * Метод добавления в дополнительную информации о событии №2 сгенерированных дополнительных сведений {@link  TestData#fakeEntityAddInfo}
     * и дополнительного числа для сущности {@link  TestData#fakeEntityAddInfo}
     *
     * @return возвращает дополнительную информацию о событии №2
     */
    public static Addition getNewFakeAddition() {
        newAddition.setAdditionalInfo(newFakeEntityAddInfo).setAdditionalNumber(newFakeEntityAddNumber);
        return newAddition;
    }

    /**
     * Сгенерированные случайные дополнительные сведения о сущности №1
     * @see EntityGenerator#fakeEntityAddInfo()
     */
    public static String fakeEntityAddInfo = entityGenerator.fakeEntityAddInfo();

    /**
     * Сгенерированное случайное дополнительное число для сущности №1
     * @see EntityGenerator#fakeEntityAddNumber()
     */
    public static int fakeEntityAddNumber = entityGenerator.fakeEntityAddNumber();

    /**
     * Сгенерированная случайная дополнительная информация о событии №1 {@link TestData#getFakeAddition()}
     */
    public static Addition fakeAddition = getFakeAddition();

    /**
     * Сгенерированный случайный массив важных чисел №1
     * @see EntityGenerator#fakeEntityImportantNumbers()
     */
    public static List<Integer> fakeImportantNumbers = entityGenerator.fakeEntityImportantNumbers();

    /**
     * Сгенерированный случайный статус верификации №1
     * @see EntityGenerator#fakeEntityVerified()
     */
    public static boolean fakeVerified = entityGenerator.fakeEntityVerified();

    /**
     * Сгенерированный случайный заголовок №1
     * @see EntityGenerator#fakeEntityTitle()
     */
    public static String fakeTitle = entityGenerator.fakeEntityTitle();

    /**
     * Экземпляр сущности №1
     */
    public static CreateEntityRequest entity = new CreateEntityRequest().setAddition(fakeAddition).setImportantNumbers(fakeImportantNumbers)
            .setTitle(fakeTitle).setVerified(fakeVerified);

    /**
     * Сгенерированные случайные дополнительные сведения о сущности №2
     * @see EntityGenerator#fakeEntityAddInfo()
     */
    public static String newFakeEntityAddInfo = newEntityGenerator.fakeEntityAddInfo();

    /**
     * Сгенерированное случайное дополнительное число для сущности №2
     * @see EntityGenerator#fakeEntityAddNumber()
     */
    public static int newFakeEntityAddNumber = newEntityGenerator.fakeEntityAddNumber();

    /**
     * Сгенерированная случайная дополнительная информация о событии №2 {@link TestData#getFakeAddition()}
     */
    public static Addition newFakeAddition = getNewFakeAddition();

    /**
     * Сгенерированный случайный массив важных чисел №2
     * @see EntityGenerator#fakeEntityImportantNumbers()
     */
    public static List<Integer> newFakeImportantNumbers = newEntityGenerator.fakeEntityImportantNumbers();

    /**
     * Сгенерированный случайный статус верификации №2
     * @see EntityGenerator#fakeEntityVerified()
     */
    public static boolean newFakeVerified = newEntityGenerator.fakeEntityVerified();

    /**
     * Сгенерированный случайный заголовок №2
     * @see EntityGenerator#fakeEntityTitle()
     */
    public static String newFakeTitle = newEntityGenerator.fakeEntityTitle();

    /**
     * Экземпляр сущности №2
     */
    public static CreateEntityRequest newEntity = new CreateEntityRequest().setAddition(newFakeAddition).setImportantNumbers(newFakeImportantNumbers)
            .setTitle(newFakeTitle).setVerified(newFakeVerified);


    /**
     * Случайный номер страницы
     */
    public static int testPage = 2;
    /**
     * Случайное количество сущностей на странице
     */
    public static int testRerPage = 3;
}
