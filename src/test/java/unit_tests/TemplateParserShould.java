package unit_tests;

import org.junit.Test;
import template.TemplateParser;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TemplateParserShould {

    @Test
    public void returnEmptyWhenReceivingAnEmptyTemplate() throws Exception{
        List<String> segments = parseTemplate("");

        assertThat("Number of segments", segments.size(), is(1));
        assertThat(segments.get(0), is(""));
    }

    @Test
    public void parseTemplatesWithOnlyPlainText() throws Exception{
        List<String> segments = parseTemplate("plain text");

        assertThat("Number of segments", segments.size(), is(1));
        assertThat(segments.get(0), is("plain text"));
    }

    private List<String> parseTemplate(String template) {
        return new TemplateParser().parse(template);
    }
}
