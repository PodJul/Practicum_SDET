package pogo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Addition {

    @JsonProperty("additional_info")
    private String additionalInfo;
    @JsonProperty("additional_number")
    private int additionalNumber;
    int id;


    public Addition(String additionalInfo, int additionalNumber) {
        this.additionalInfo = additionalInfo;
        this.additionalNumber = additionalNumber;
    }

    public Addition() {
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public Addition setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public int getAdditionalNumber() {
        return additionalNumber;
    }

    public void setAdditionalNumber(int additionalNumber) {
        this.additionalNumber = additionalNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
