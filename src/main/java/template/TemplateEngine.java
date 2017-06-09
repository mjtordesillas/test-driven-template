package template;

public class TemplateEngine {

    private String variableValue;

    public TemplateEngine(String templateText) {

    }

    public void set(String variable, String value) {
        this.variableValue = value;
    }

    public String evaluate() {
        return "Hello, " + this.variableValue;
    }
}
