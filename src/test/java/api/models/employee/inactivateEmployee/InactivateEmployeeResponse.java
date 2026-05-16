package api.models.employee.inactivateEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InactivateEmployeeResponse {

    public Data data;

    public static class Data {

        public Boolean inactivateEmployee;
    }

    public List<Error> errors;

    public static class Error {
        public String message;
    }
}