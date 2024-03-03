package api.helpers;

import api.pogo.AllEntitiesResponse;
import api.requests.CreateEntityRequest;

import java.util.List;

/**
 * Класс генерации тестовых данных
 *
 * @author Юлия Подычан
 * @version 1.0
 */
public class TestData {
    //Экземпляр генератора сущности №1
    static EntityGenerator entityGenerator = new EntityGenerator();
    //Экземпляр генератора сущности №2
    static EntityGenerator newEntityGenerator = new EntityGenerator();
    //Экземпляр дополнительной информации о событии №1
    static Addition addition = new Addition();
    //Экземпляр дополнительной информации о событии №2
    static Addition newAddition = new Addition();
    public static Addition getFakeAddition() {
        addition.setAdditionalInfo(fakeEntityAddInfo).setAdditionalNumber(fakeEntityAddNumber);
        return addition;
    }
    public static Addition getNewFakeAddition() {
        newAddition.setAdditionalInfo(newFakeEntityAddInfo).setAdditionalNumber(newFakeEntityAddNumber);
        return newAddition;
    }
    public static String fakeEntityAddInfo = entityGenerator.fakeEntityAddInfo();
    public static int fakeEntityAddNumber = entityGenerator.fakeEntityAddNumber();
    public static Addition fakeAddition = getFakeAddition();
    public static List<Integer> fakeImportantNumbers = entityGenerator.fakeEntityImportantNumbers();
    public static boolean fakeVerified = entityGenerator.fakeEntityVerified();
    public static String fakeTitle = entityGenerator.fakeEntityTitle();
    //Экземпляр сущности №1
    public static CreateEntityRequest entity = new CreateEntityRequest().setAddition(fakeAddition).setImportantNumbers(fakeImportantNumbers)
            .setTitle(fakeTitle).setVerified(fakeVerified);
    public static String newFakeEntityAddInfo = newEntityGenerator.fakeEntityAddInfo();
    public static int newFakeEntityAddNumber = newEntityGenerator.fakeEntityAddNumber();
    public static Addition newFakeAddition = getNewFakeAddition();
    public static List<Integer> newFakeImportantNumbers = newEntityGenerator.fakeEntityImportantNumbers();
    public static boolean newFakeVerified = newEntityGenerator.fakeEntityVerified();
    public static String newFakeTitle = newEntityGenerator.fakeEntityTitle();
    //Экземпляр сущности №2
    public static CreateEntityRequest newEntity = new CreateEntityRequest().setAddition(newFakeAddition).setImportantNumbers(newFakeImportantNumbers)
            .setTitle(newFakeTitle).setVerified(newFakeVerified);
    //Случайный номер страницы
    public static int testPage = 2;
    //Случайное количество сущностей на странице
    public static int testRerPage = 3;
}
