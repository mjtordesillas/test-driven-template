package unit_tests;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegexApiLearningTests {

    @Test
    public void testHowGroupCountWorks () throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "(needle)";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertThat(matcher.groupCount(), is(2));
    }

    @Test
    public void testFindStartAndEnd () throws Exception {
        String haystack = "The needle shop sells needles";
        String regex = "needle";
        Matcher matcher = Pattern.compile(regex).matcher(haystack);
        assertThat(matcher.find(), is(true));
        assertThat("Wrong start index of 1st match", matcher.start(), is(4));
        assertThat("Wrong end index of 1st match",matcher.end(), is(10));

        assertThat(matcher.find(), is(true));
        assertThat("Wrong start index of 2nd match", matcher.start(), is(22));
        assertThat("Wrong end index of 2nd match",matcher.end(), is(28));

        assertThat("Should not have more matches", matcher.find(), is(false));
    }
}
