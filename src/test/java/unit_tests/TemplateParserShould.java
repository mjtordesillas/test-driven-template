package unit_tests;

import org.junit.Test;
import template.TemplateParser;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TemplateParserShould {

    @Test
    public void returnEmptyWhenReceivingAnEmptyTemplate() throws Exception{
        List<String> segments = parseTemplate("");

        assertSegments(segments, "");
    }

    @Test
    public void parseTemplatesWithOnlyPlainText() throws Exception{
        List<String> segments = parseTemplate("plain text");

        assertSegments(segments, "plain text");
    }

    private List<String> parseTemplate(String template) {
        return new TemplateParser().parse(template);
    }

    private void assertSegments(List<? extends Object> actual, Object... expected) {
        assertThat("Number of segments does not match", actual.size(), is(expected.length));
        assertEquals(Arrays.asList(expected), actual);
    }
}
