package pages.elements;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TestData {
    static Faker faker = new Faker(new Locale("en-RU"));
    public static String fakePostCode = faker.numerify("##########");
    public static String fakeLastName = faker.name().lastName();
    public static String fakeFirstName = faker.name().firstName();

    public static String createFirstName(String postCode) {
        FirstNameConstructor firstNameConstructor = new FirstNameConstructor();
        String[] splitPostCode = firstNameConstructor.splitPostCode(postCode);
        ArrayList<String> splitPostCodeStr = (ArrayList<String>) firstNameConstructor.joinPostCode(splitPostCode);
        List<Integer> convertPostCode = firstNameConstructor.convertPostCodeToNum(splitPostCodeStr);

        String[] firstName = new String[5];
        for (int i = 0; i < convertPostCode.size(); i++) {
            int key = convertPostCode.get(i);
            Map<Integer, String> map = firstNameConstructor.createMap();

            if (key / 26 == 0) {
                firstName[i] = (map.get(key));
            } else if (key / 26 == 1) {
                firstName[i] = (map.get(key - 26));
            } else if (key / 26 == 2) {
                firstName[i] = (map.get(key - 52));
            } else if (key / 26 == 3) {
                firstName[i] = (map.get(key - 78));
            }
        }
        return String.join("", firstName);
    }
}
