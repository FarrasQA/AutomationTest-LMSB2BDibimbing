package api.models.employee.createEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEmployeeResponse {

    public Data data;
    public List<Error> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public CreateEmployee createEmployee;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateEmployee {
        public String id;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        public String message;
    }
}