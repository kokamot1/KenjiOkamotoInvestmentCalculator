package edu.westga.kenjiokamotoinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import edu.westga.kenjiokamotoinvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void calculateButtonClick(View v) {
        EditText paymentEditText = (EditText) findViewById(R.id.paymentEditText);
        EditText rateEditText = (EditText) findViewById(R.id.rateEditText);
        EditText yearsEditText = (EditText) findViewById(R.id.yearsEditText);
        TextView resultTextView = (TextView) findViewById(R.id.endBalancetextView);
        double payment;
        double rate;
        int years;

        try {
            payment = Double.parseDouble(paymentEditText.getText().toString());
            rate = Double.parseDouble(rateEditText.getText().toString()) / 100;
        } catch (NumberFormatException exception) {
            resultTextView.setText("Payment and Rate need to be decimal numbers");
            return;
        }
        try {
            years = Integer.parseInt(yearsEditText.getText().toString());
        } catch (NumberFormatException exception) {
            resultTextView.setText("Years must be an integer");
            return;
        }
        resultTextView.setText(InvestmentCalculator.getFutureValue(payment, rate, years));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
