package party;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class AppTest {
    private App subject;

    @Before
    public void setUp() {
        subject = new App();
    }

    @Test
    public void testThatAppHasAGreeting() {
        String greeting = subject.getGreeting();

        assertThat(greeting, is(notNullValue()));
        assertThat(greeting, is(equalTo(App.DEFAULT_GREETING)));
    }
}
