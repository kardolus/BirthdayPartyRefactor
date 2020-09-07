package party;

import party.order.Order;
import party.order.items.Balloons;
import party.order.items.Cake;

public class App {
    public static final String DEFAULT_GREETING = "Hello world.";

    public String getGreeting() {
        return DEFAULT_GREETING;
    }

    public static void main(String[] args) {
        Order order = new Order();

        order.order(new Balloons("red", "mylar", 4), new Cake("chocolate", "chocolate", "circle", "large", "brown" ));
        order.order(new Balloons("blue", "latex", 7), new Cake("Vanilla", "chocolate", "square", "med", "brown"));
        order.order(new Balloons("yellow", "mylar", 4), new Cake("vanilla", "vanilla", "square", "small", "yellow"));
    }
}