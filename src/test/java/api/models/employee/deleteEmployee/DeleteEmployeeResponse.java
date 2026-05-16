package api.models.employee.deleteEmployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteEmployeeResponse {
    public Data data;

    public static class Data {
        public Boolean deleteEmployee;
    }

    public List<Error> errors;

    public static class Error {
        public String message;
    }
}