package com.example.javatests.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        double total = 0;

        for (double price :
                prices) {
            total += price;
        }

        return total * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
