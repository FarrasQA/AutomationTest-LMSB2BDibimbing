package api.models.employee.createEmployee;

public class CreateEmployeeVariables {

  public Input input;

  public CreateEmployeeVariables(
    String name,
    String employeeId,
    String email,
    String phoneNumber,
    String divisionId,
    String employeeRole
  ) {
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
