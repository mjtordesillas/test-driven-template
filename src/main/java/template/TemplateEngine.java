package template;

import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

    private String templateText;
    private Map<String, String> variables;

    public TemplateEngine(String templateText) {
        this.templateText = templateText;
        this.variables = new HashMap<String, String>();
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    public String evaluate() {
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }

    private String replaceVariables() {
        String result = templateText;
        for(Map.Entry<String, String> entry: variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result) {
        if(result.matches(".*\\$\\{.+\\}.*")) {
            throw new MissingValueException();
        }
    }
}
