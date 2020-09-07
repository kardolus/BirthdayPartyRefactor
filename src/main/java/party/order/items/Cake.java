package party.order.items;

import utils.Logger;

import java.util.StringJoiner;

public class Cake implements PartyItem {
    public static final String CAKE_ORDER_PREFIX = "Cake ordered; ";
    public static final String MISSING_ARGUMENT_MESSAGE = "You must provide a %s.";
    public static final String COLOR = "color";
    public static final String SIZE = "size";
    public static final String SHAPE = "shape";
    public static final String FLAVOR = "flavor";
    public static final String FROSTING_FLAVOR = "frosting flavor";

    private String flavor, frostingFlavor, shape, size, color;

    public Cake(String flavor, String frostingFlavor, String shape, String size, String color) {
        setFlavor(flavor);
        setFrostingFlavor(frostingFlavor);
        setShape(shape);
        setSize(size);
        setColor(color);
    }

    @Override
    public String order(){
        return Logger.wrap(this.toString());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CAKE_ORDER_PREFIX, "")
                .add(this.flavor)
                .add(this.frostingFlavor)
                .add(this.shape)
                .add(this.size)
                .add(this.color)
                .toString();
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        if (flavor == null || flavor.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, FLAVOR));
        }
        this.flavor = flavor;
    }

    public String getFrostingFlavor() {
        return frostingFlavor;
    }

    public void setFrostingFlavor(String frostingFlavor) {
        if (frostingFlavor == null || frostingFlavor.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, FROSTING_FLAVOR));
        }
        this.frostingFlavor = frostingFlavor;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        if (shape == null || shape.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, SHAPE));
        }
        this.shape = shape;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, SIZE));
        }
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, COLOR));
        }
        this.color = color;
    }
}
