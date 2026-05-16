package api.models.division.deleteDivision;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteDivisionResponse {

    public Data data;
    public List<Error> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public Boolean deleteDivision;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        public String message;
    }
}