package unit_tests;

import org.junit.Before;
import org.junit.Test;
import template.TemplateEngine;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemplateEngineShould {


    private TemplateEngine templateEngine;

    @Before
    public void setUp() throws Exception {
        templateEngine = new TemplateEngine("${one}, ${two}, ${three}");
        templateEngine.set("one", "1");
        templateEngine.set("two", "2");
        templateEngine.set("three", "3");
    }

    @Test
    public void evaluateMultipleVariables() throws Exception {
        assertTemplateEngineEvaluatesTo("1, 2, 3");
    }

    @Test
    public void ignoreUnknownVariables() throws Exception {
        templateEngine.set("name", "someone");
        assertTemplateEngineEvaluatesTo("1, 2, 3");
    }

    private void assertTemplateEngineEvaluatesTo(String expected) {
        assertThat(templateEngine.evaluate(), is(expected));
    }

}
