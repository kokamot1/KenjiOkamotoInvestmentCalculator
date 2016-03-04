package edu.westga.kenjiokamotoinvestmentcalculator;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testCalculatorWithValidInput() {
        MainActivity activity = getActivity();
        final EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                paymentEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("100");
        getInstrumentation().waitForIdleSync();

        final EditText rateEditText =
                (EditText) activity.findViewById(R.id.rateEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                rateEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("3.4");
        getInstrumentation().waitForIdleSync();

        final EditText yearsEditText =
                (EditText) activity.findViewById(R.id.yearsEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                yearsEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("20");
        getInstrumentation().waitForIdleSync();

        Button calculateButton =
                (Button) activity.findViewById(R.id.button);

        TouchUtils.clickView(this, calculateButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.endBalancetextView);
        String actualText = greetMessage.getText().toString();
        assertEquals("$2,799.09", actualText);
    }

    public void testCalculatorWithInvalidPayment() {
        MainActivity activity = getActivity();
        final EditText rateEditText =
                (EditText) activity.findViewById(R.id.rateEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                rateEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("3.4");
        getInstrumentation().waitForIdleSync();

        final EditText yearsEditText =
                (EditText) activity.findViewById(R.id.yearsEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                yearsEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("20");
        getInstrumentation().waitForIdleSync();

        Button calculateButton =
                (Button) activity.findViewById(R.id.button);

        TouchUtils.clickView(this, calculateButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.endBalancetextView);
        String actualText = greetMessage.getText().toString();
        assertEquals("Payment and Rate need to be decimal numbers", actualText);
    }

    public void testCalculatorWithInvalidRate() {
        MainActivity activity = getActivity();
        final EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                paymentEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("100");
        getInstrumentation().waitForIdleSync();

        final EditText yearsEditText =
                (EditText) activity.findViewById(R.id.yearsEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                yearsEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("20");
        getInstrumentation().waitForIdleSync();

        Button calculateButton =
                (Button) activity.findViewById(R.id.button);

        TouchUtils.clickView(this, calculateButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.endBalancetextView);
        String actualText = greetMessage.getText().toString();
        assertEquals("Payment and Rate need to be decimal numbers", actualText);
    }

    public void testCalculatorWithInvalidYear() {
        MainActivity activity = getActivity();
        final EditText paymentEditText =
                (EditText) activity.findViewById(R.id.paymentEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                paymentEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("100");
        getInstrumentation().waitForIdleSync();

        final EditText rateEditText =
                (EditText) activity.findViewById(R.id.rateEditText);

        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                rateEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("3.4");
        getInstrumentation().waitForIdleSync();

        Button calculateButton =
                (Button) activity.findViewById(R.id.button);

        TouchUtils.clickView(this, calculateButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.endBalancetextView);
        String actualText = greetMessage.getText().toString();
        assertEquals("Years must be an integer", actualText);
    }

}