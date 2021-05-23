package com.example.javatests.discounts;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void totalZeroWhenThereAreNotPrices() {
        PriceCalculator priceCalculator = new PriceCalculator();

        assertEquals(0, priceCalculator.getTotal(), 0);
    }

    @Test
    public void totalIsSumOfPrices() {

        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.addPrice(10);
        priceCalculator.addPrice(15);

        assertEquals(25, priceCalculator.getTotal(),0);
    }

    @Test
    public void applyDiscountToPrices() {

        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.addPrice(12.5);
        priceCalculator.addPrice(17.5);
        priceCalculator.setDiscount(50);

        assertEquals(15, priceCalculator.getTotal(),0);
    }
}