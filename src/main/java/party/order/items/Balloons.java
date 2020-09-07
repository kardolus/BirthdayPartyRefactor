package party.order.items;

import utils.Logger;

import java.util.StringJoiner;

public class Balloons implements PartyItem {
    public static final String BALLOON_ORDER_PREFIX = "Balloons ordered; ";
    public static final String MISSING_ARGUMENT_MESSAGE = "You must provide a %s.";
    public static final String NUMBER_EXCEPTION = "You need to order 1 or more balloons.";
    public static final String COLOR = "color";
    public static final String MATERIAL = "material";

    private String color, material;
    private int number;

    public Balloons(String color, String material, int number) {
        setColor(color);
        setMaterial(material);
        setNumber(number);
    }

    @Override
    public String order() {
        return Logger.wrap(this.toString());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BALLOON_ORDER_PREFIX, "")
                .add(this.color)
                .add(this.material)
                .add(String.valueOf(this.number))
                .toString();
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(MISSING_ARGUMENT_MESSAGE, MATERIAL));
        }
        this.material = material;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
        this.number = number;
    }
}
