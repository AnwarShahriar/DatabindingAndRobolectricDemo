package me.anwarshahriar.testingcoffeeorderunittest;

import android.widget.Button;
import android.widget.TextView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class CoffeeOrderActivityTest {

    @Test
    public void shouldNotBeNull() {
        CoffeeOrderActivity coffeeOrderActivity =
                Robolectric.setupActivity(CoffeeOrderActivity.class);
        assertNotNull(coffeeOrderActivity);
    }

    @Test
    public void totalPriceShouldBeZeroAtFirstTime() {
        CoffeeOrderActivity coffeeOrderActivity =
                Robolectric.setupActivity(CoffeeOrderActivity.class);
        TextView tvTotalPrice =
                (TextView) coffeeOrderActivity.findViewById(R.id.tvTotalPrice);
        assertEquals("Total Price: $0.0", tvTotalPrice.getText().toString());
    }

    @Test
    public void totalPriceShouldBe3TimesOfUnitPriceAfter3Increments() {
        CoffeeOrderActivity coffeeOrderActivity =
                Robolectric.setupActivity(CoffeeOrderActivity.class);
        TextView tvTotalPrice =
                (TextView) coffeeOrderActivity.findViewById(R.id.tvTotalPrice);
        Button btnIncrement =
                (Button) coffeeOrderActivity.findViewById(R.id.btnIncrement);

        btnIncrement.performClick();
        btnIncrement.performClick();
        btnIncrement.performClick();

        assertEquals("Total Price: $45.0", tvTotalPrice.getText().toString());
    }
}