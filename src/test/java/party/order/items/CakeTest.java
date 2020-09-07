package party.order.items;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CakeTest {
    private static final String FROSTING_FLAVOR = "chocolate";
    private static final String FLAVOR = "chocolate";
    private static final String SHAPE = "circle";
    private static final String SIZE = "large";
    private static final String CAKE_COLOR = "brown";

    private Cake subject;

    @Before
    public void setUp() {
        subject = new Cake(FLAVOR, FROSTING_FLAVOR, SHAPE, SIZE, CAKE_COLOR);
    }

    @Rule
    public ExpectedException exceptionGrabber = ExpectedException.none();

    @Test
    public void testThatOrderIsConstructedAsExpected() {
        String result = subject.order();

        assertThat(result, startsWith(Cake.CAKE_ORDER_PREFIX));
        assertThat(result, containsString(subject.getColor()));
        assertThat(result, containsString(subject.getFlavor()));
        assertThat(result, containsString(subject.getFrostingFlavor()));
        assertThat(result, containsString(subject.getShape()));
        assertThat(result, containsString(subject.getSize()));

        assertThat(subject.getFrostingFlavor(), is(equalTo(FROSTING_FLAVOR)));
        assertThat(subject.getFlavor(), is(equalTo(FLAVOR)));
        assertThat(subject.getShape(), is(equalTo(SHAPE)));
        assertThat(subject.getSize(), is(equalTo(SIZE)));
        assertThat(subject.getColor(), is(equalTo(CAKE_COLOR)));
    }

    @Test
    public void testThatTheColorIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Cake.MISSING_ARGUMENT_MESSAGE, Cake.COLOR));

        subject = new Cake(FLAVOR, FROSTING_FLAVOR, SHAPE, SIZE, " ");
    }

    @Test
    public void testThatTheSizeIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Cake.MISSING_ARGUMENT_MESSAGE, Cake.SIZE));

        subject = new Cake(FLAVOR, FROSTING_FLAVOR, SHAPE, null, CAKE_COLOR);
    }

    @Test
    public void testThatTheShapeIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Cake.MISSING_ARGUMENT_MESSAGE, Cake.SHAPE));

        subject = new Cake(FLAVOR, FROSTING_FLAVOR, "", SIZE, CAKE_COLOR);
    }

    @Test
    public void testThatTheFrostingFlavorIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Cake.MISSING_ARGUMENT_MESSAGE, Cake.FROSTING_FLAVOR));

        subject = new Cake(FLAVOR, "   ", SHAPE, SIZE, CAKE_COLOR);
    }

    @Test
    public void testThatTheFlavorIsNotNullOrEmpty() {
        exceptionGrabber.expect(IllegalArgumentException.class);
        exceptionGrabber.expectMessage(String.format(Cake.MISSING_ARGUMENT_MESSAGE, Cake.FLAVOR));

        subject = new Cake("", FROSTING_FLAVOR, SHAPE, SIZE, CAKE_COLOR);
    }
}