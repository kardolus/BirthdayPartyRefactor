package utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LoggerTest {
    @Test
    public void testThatWrapDoesNotUpdateInput() {
        final String input = "input";

        assertThat(Logger.wrap(input), is(equalTo(input)));
    }
}