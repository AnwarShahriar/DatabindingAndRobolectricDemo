package me.anwarshahriar.testingcoffeeorderunittest;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

public class CoffeeOrder implements Observable{
    private PropertyChangeRegistry registry = new PropertyChangeRegistry();

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

    @Bindable
    public int getCoffeeCount() {
        return coffeeCount;
    }

    @Bindable
    public double getTotalPrice() {
        return totalPrice;
    }

    public void increment() {
        coffeeCount++;
        registry.notifyChange(this, me.anwarshahriar.testingcoffeeorderunittest.BR.coffeeCount);

        calculateTotalPrice();
    }

    public void decrement() {
        if (coffeeCount == 0) return;
        coffeeCount--;
        registry.notifyChange(this, me.anwarshahriar.testingcoffeeorderunittest.BR.coffeeCount);

        calculateTotalPrice();
    }

    private void calculateTotalPrice() {
        totalPrice = unitPrice * coffeeCount;
        registry.notifyChange(this, me.anwarshahriar.testingcoffeeorderunittest.BR.totalPrice);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.remove(onPropertyChangedCallback);
    }
}