package pages.elements;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EntityGenerator {

    Faker faker = new Faker(new Locale("en-RU"));
    int n = faker.number().randomDigit();
    List<Integer> importantNumbers = new ArrayList<>();

    public String fakeEntityAddInfo() {
        return faker.lorem().sentence();
    }

    public int fakeEntityAddNumber() {
        return faker.number().numberBetween(1, 1000);
    }

    public String fakeEntityTitle() {
        return faker.name().title();
    }

    public boolean fakeEntityVerified() {
        return faker.random().nextBoolean();
    }

    public List<Integer> fakeEntityImportantNumbers() {
        for (int i = 0; i < n; i++) {

            importantNumbers.add(i, faker.number().numberBetween(0, 100));

        }

        return importantNumbers;
    }
}
