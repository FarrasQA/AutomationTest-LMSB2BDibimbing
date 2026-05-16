package api.models.division.updateDivision;

public class UpdateDivisionVariables {

    public String id;
    public Input input;

    public UpdateDivisionVariables(
            String id,
            String name,
            String description
    ) {

        this.id = id;

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