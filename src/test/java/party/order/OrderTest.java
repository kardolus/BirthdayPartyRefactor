package party.order;

import org.junit.Before;
import org.junit.Test;
import party.order.items.Balloons;
import party.order.items.Cake;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.startsWith;

public class OrderTest {
    private Order subject;

    @Before
    public void Setup() {
        subject = new Order();
    }

    @Test
    public void testThatOrderHasAllExpectedItems() {
        final String COLOR = "red";
        final String MATERIAL = "mylar";
        final int NUMBER = 4;
        final String FROSTING_FLAVOR = "chocolate";
        final String FLAVOR = "chocolate";
        final String SHAPE = "circle";
        final String SIZE = "large";
        final String CAKE_COLOR = "brown";

        Balloons balloons = new Balloons(COLOR, MATERIAL, NUMBER);
        Cake cake = new Cake(FROSTING_FLAVOR, FLAVOR, SHAPE, SIZE, CAKE_COLOR);

        List<String> order = subject.order(balloons, cake);
        assertThat(order, hasSize(2));

        assertThat(order.get(0), startsWith(Balloons.BALLOON_ORDER_PREFIX));
        assertThat(order.get(1), startsWith(Cake.CAKE_ORDER_PREFIX));
    }
}