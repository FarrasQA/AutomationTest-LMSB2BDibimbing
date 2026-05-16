package api.models.employee.updateEmployee;

public class UpdateEmployeeVariables {

    public String id;
    public Input input;

    public UpdateEmployeeVariables(
            String id,
            String name,
            String employeeId,
            String email,
            String phoneNumber,
            String divisionId,
            String employeeRole
    ) {

        this.id = id;

        this.input = new Input(
                name,
                employeeId,
                email,
                phoneNumber,
                divisionId,
                employeeRole
        );
    }

    public static class Input {

        public String name;
        public String employeeId;
        public String email;
        public String phoneNumber;
        public String divisionId;
        public String employeeRole;

        public Input(
                String name,
                String employeeId,
                String email,
                String phoneNumber,
                String divisionId,
                String employeeRole
        ) {

            this.name = name;
            this.employeeId = employeeId;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.divisionId = divisionId;
            this.employeeRole = employeeRole;
        }
    }
}