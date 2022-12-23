package org.example.discounts;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


class PriceCalculatorShould {

    @Test
    public void totalZeroWhenThereArePrices(){
        PriceCalculator calculator = new PriceCalculator();
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void totalIsTheSumOfPrices(){
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.0);
        calculator.addPrice(20.34);
        assertThat(calculator.getTotal(), is(30.34));
    }

    @Test
    public void applyDiscountToPrices(){
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(100);
        calculator.addPrice(100);
        calculator.setDiscount(25);
        assertThat(calculator.getTotal(), is(150.0));
    }
}