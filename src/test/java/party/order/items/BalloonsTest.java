package party.order.items;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BalloonsTest {
    private static final String COLOR = "red";
    private static final String MATERIAL = "mylar";
    private static final int NUMBER = 4;

    private Balloons subject;

    @Before
    public void setUp() {
        subject = new Balloons(COLOR, MATERIAL, NUMBER);
    }

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    public void testThatOrderIsConstructedAsExpected() {
        String result = subject.order();

        assertThat(result, startsWith(Balloons.BALLOON_ORDER_PREFIX));
        assertThat(result, containsString(subject.getColor()));
        assertThat(result, containsString(subject.getMaterial()));
        assertThat(result, containsString(String.valueOf(subject.getNumber())));

        assertThat(subject.getColor(), is(equalTo(COLOR)));
        assertThat(subject.getMaterial(), is(equalTo(MATERIAL)));
        assertThat(subject.getNumber(), is(equalTo(NUMBER)));
    }

    @Test
    public void testThatAtLeastZeroBalloonsAreProvided() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(Balloons.NUMBER_EXCEPTION);

        subject = new Balloons(COLOR, MATERIAL, -1);
    }

    @Test
    public void testThatTheColorIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Balloons.MISSING_ARGUMENT_MESSAGE, Balloons.COLOR));

        subject = new Balloons("     ", MATERIAL, NUMBER);
    }

    @Test
    public void testThatTheMaterialIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Balloons.MISSING_ARGUMENT_MESSAGE, Balloons.MATERIAL));

        subject = new Balloons(COLOR, null, NUMBER);
    }
}