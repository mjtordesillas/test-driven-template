package unit_tests;

import org.junit.Test;
import template.TemplateEngine;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemplateEngineShould {
    @Test
    public void evaluateOneVariable() throws Exception {
        TemplateEngine templateEngine = new TemplateEngine("Hello, ${name}");
        templateEngine.set("name", "Reader");
        assertThat(templateEngine.evaluate(), is("Hello, Reader"));
    }

}
