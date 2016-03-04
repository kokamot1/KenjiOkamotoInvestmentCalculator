package edu.westga.kenjiokamotoinvestmentcalculator.model;


import java.text.DecimalFormat;

public class InvestmentCalculator {

    public static String getFutureValue(double payment, double rate, int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years must not be negative");
        }
        double endValue;
        if (rate == 0) {
            endValue = years * payment;
        } else {
            double numerator = Math.pow( (1 + rate), years ) - 1;
            endValue = payment * numerator / rate;
        }
        return "$" + new DecimalFormat("#,###.##").format(endValue);
    }

}
