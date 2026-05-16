package api.models.division.createDivision;

public class CreateDivisionVariables {

    public Input input;

    public CreateDivisionVariables(
            String name,
            String description
    ) {
        this.input = new Input(
                name,
                description
        );
    }

    public static class Input {

        public String name;
        public String description;

        public Input(
                String name,
                String description
        ) {
            this.name = name;
            this.description = description;
        }
    }
}