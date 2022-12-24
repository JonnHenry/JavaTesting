package org.example.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount;

    public double getTotal() {
        double total = prices.stream().reduce(0.0,(subtotal,element)->subtotal+element);
        return this.discount>0?total*((100-this.discount)/100):total;
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {

        this.discount = discount;
    }
}
