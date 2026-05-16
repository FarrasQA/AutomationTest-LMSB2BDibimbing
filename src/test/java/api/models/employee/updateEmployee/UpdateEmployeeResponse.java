package api.models.employee.updateEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmployeeResponse {

    public Data data;
    public List<Error> errors;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public UpdateEmployee updateEmployee;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UpdateEmployee {
        public String id;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error {
        public String message;
    }
}