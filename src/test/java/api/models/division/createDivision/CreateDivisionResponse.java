package api.models.division.createDivision;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateDivisionResponse {

    public Data data;
    public List<Error> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public CreateDivision createDivision;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateDivision {
        public String id;
        public String name;
        public String description;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        public String message;
    }
}