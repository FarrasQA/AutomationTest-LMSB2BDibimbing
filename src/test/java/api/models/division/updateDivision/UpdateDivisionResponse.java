package api.models.division.updateDivision;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDivisionResponse {

    public Data data;
    public List<Error> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public UpdateDivision updateDivision;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UpdateDivision {
        public String id;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        public String message;
    }
}