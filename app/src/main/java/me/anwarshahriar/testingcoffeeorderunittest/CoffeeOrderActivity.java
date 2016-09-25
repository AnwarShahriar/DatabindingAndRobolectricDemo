package me.anwarshahriar.testingcoffeeorderunittest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.anwarshahriar.testingcoffeeorderunittest.databinding.ActivityCoffeeOrderBinding;

public class CoffeeOrderActivity extends AppCompatActivity {
    ActivityCoffeeOrderBinding binding;
    CoffeeOrder coffeeOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coffee_order);

        coffeeOrder = new CoffeeOrder(15);
        OrderActionHandler handler = new OrderActionHandler();

        binding.setCoffeeOrder(coffeeOrder);
        binding.setHandler(handler);
    }

    public class OrderActionHandler {
        public void increment() {
            coffeeOrder.increment();
        }

        public void decrement() {
            coffeeOrder.decrement();
        }
    }
}