package me.anwarshahriar.testingcoffeeorderunittest;

public class CoffeeOrder {
    private double unitPrice;
    private double totalPrice;
    private int coffeeCount;

    public CoffeeOrder(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setCoffeeCount(int coffeeCount) {
        if (coffeeCount < 0) return;
        this.coffeeCount = coffeeCount;
        calculateTotalPrice();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getCoffeeCount() {
        return coffeeCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void increment() {
        coffeeCount++;
        calculateTotalPrice();
    }

    public void decrement() {
        if (coffeeCount == 0) return;
        coffeeCount--;
        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        totalPrice = unitPrice * coffeeCount;
    }
}