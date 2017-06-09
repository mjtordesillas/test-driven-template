package template;

public class TemplateEngine {

    private String variableValue;
    private String templateText;

    public TemplateEngine(String templateText) {

        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variableValue = value;
    }

    public String evaluate() {
        return templateText.replaceAll("\\$\\{name\\}", variableValue);
    }
}
