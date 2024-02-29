package pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Entity {

    private Addition addition;
    @JsonProperty("important_numbers")
    private List<Integer> importantNumbers;
    private String title;
    private boolean verified;


    public Entity(Addition addition, List<Integer> importantNumbers, String title, boolean verified) {

        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;
    }

    public Entity() {

    }

    public Addition getAddition() {
        return addition;
    }

    public Entity setAddition(Addition addition) {
        this.addition = addition;
        return this;
    }

    public List<Integer> getImportantNumbers() {
        return importantNumbers;
    }

    public Entity setImportantNumbers(List<Integer> importantNumbers) {
        this.importantNumbers = importantNumbers;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Entity setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean isVerified() {
        return verified;
    }

    public Entity setVerified(boolean verified) {
        this.verified = verified;
        return this;
    }
}
