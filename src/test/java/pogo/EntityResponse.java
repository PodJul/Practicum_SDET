package pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EntityResponse {

    private String id;
    private Addition addition;
    @JsonProperty("important_numbers")
    private List<Integer> importantNumbers;
    private String title;
    private boolean verified;


    public EntityResponse(String id, Addition addition, List<Integer> importantNumbers, String title, boolean verified) {
        this.id = id;
        this.addition = addition;
        this.importantNumbers = importantNumbers;
        this.title = title;
        this.verified = verified;

    }

    public EntityResponse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Addition getAddition() {
        return addition;
    }

    public void setAddition(Addition addition) {
        this.addition = addition;
    }

    public List<Integer> getImportantNumbers() {
        return importantNumbers;
    }

    public void setImportantNumbers(List<Integer> importantNumbers) {
        this.importantNumbers = importantNumbers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

}
