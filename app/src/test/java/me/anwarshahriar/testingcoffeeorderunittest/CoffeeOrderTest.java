package me.anwarshahriar.testingcoffeeorderunittest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by anwar on 9/21/16.
 */

public class CoffeeOrderTest {
    private final static double PRICE_TEST = 5.0;
    private CoffeeOrder mOrder;

    @Before
    public void setUp() {
        mOrder = new CoffeeOrder(PRICE_TEST);
    }
    @Test
    public void orderIsNotNull() {
        assertNotNull(mOrder);
    }
    @Test
    public void orderDecrement() {
        mOrder.decrement();
        assertEquals(0, mOrder.getCoffeeCount());
        mOrder.setCoffeeCount(25);
        mOrder.decrement();
        assertEquals(24, mOrder.getCoffeeCount());
    }
    @Test
    public void orderIncrement() {
        mOrder.increment();
        assertEquals(1, mOrder.getCoffeeCount());
        mOrder.setCoffeeCount(25);
        mOrder.increment();
        assertEquals(26, mOrder.getCoffeeCount());
    }
    @Test
    public void orderTotalPrice() {
        assertEquals(0.0, mOrder.getTotalPrice());
        mOrder.setCoffeeCount(25);
        assertEquals(PRICE_TEST * 25, mOrder.getTotalPrice());
    }
    @Test
    public void orderSetCoffeeCount() {
        mOrder.setCoffeeCount(-1);
        assertEquals(0, mOrder.getCoffeeCount());
        mOrder.setCoffeeCount(25);
        assertEquals(25, mOrder.getCoffeeCount());
    }
}