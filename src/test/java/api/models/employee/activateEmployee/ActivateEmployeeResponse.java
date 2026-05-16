package api.models.employee.activateEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivateEmployeeResponse {
    public Data data;

    public static class Data {
        public Boolean activateEmployee;
    }

    public List<Error> errors;

    public static class Error {
        public String message;
    }
}