package party.order;

import party.order.items.PartyItem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public List<String> order(PartyItem... items){
        List<String> result = new ArrayList<>();

        for (PartyItem item : items) {
            result.add(item.order());
        }

        return result;
    }
}
