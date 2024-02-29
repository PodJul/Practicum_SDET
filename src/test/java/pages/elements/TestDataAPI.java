package pages.elements;

import pogo.Addition;
import pogo.Entity;

import java.util.List;

public class TestDataAPI {

    static EntityGenerator entityGenerator = new EntityGenerator();
    static EntityGenerator newEntityGenerator = new EntityGenerator();

    static Addition addition=new Addition();
    static Addition newAddition=new Addition();

    public static Addition getFakeAddition() {
        addition.setAdditionalInfo(fakeEntityAddInfo).setAdditionalNumber(fakeEntityAddNumber);
        return addition;
    }
    public static Addition getNewFakeAddition() {
        newAddition.setAdditionalInfo(newFakeEntityAddInfo).setAdditionalNumber(newFakeEntityAddNumber);
        return newAddition;
    }
    public static String fakeEntityAddInfo=entityGenerator.fakeEntityAddInfo();
    public static int fakeEntityAddNumber=entityGenerator.fakeEntityAddNumber();
    public static Addition fakeAddition = getFakeAddition();
    public static List<Integer> fakeImportantNumbers = entityGenerator.fakeEntityImportantNumbers();
    public static boolean fakeVerified = entityGenerator.fakeEntityVerified();
    public static String fakeTitle = entityGenerator.fakeEntityTitle();
    public static Entity entity = new Entity().setAddition(fakeAddition).setImportantNumbers(fakeImportantNumbers)
            .setTitle(fakeTitle).setVerified(fakeVerified);
    public static String newFakeEntityAddInfo=newEntityGenerator.fakeEntityAddInfo();
    public static int newFakeEntityAddNumber=newEntityGenerator.fakeEntityAddNumber();
    public static Addition newFakeAddition = getNewFakeAddition();
    public static List<Integer> newFakeImportantNumbers = newEntityGenerator.fakeEntityImportantNumbers();
    public static boolean newFakeVerified = newEntityGenerator.fakeEntityVerified();
    public static String newFakeTitle = newEntityGenerator.fakeEntityTitle();
    public static Entity newEntity = new Entity().setAddition(newFakeAddition).setImportantNumbers(newFakeImportantNumbers)
            .setTitle(newFakeTitle).setVerified(newFakeVerified);

}
