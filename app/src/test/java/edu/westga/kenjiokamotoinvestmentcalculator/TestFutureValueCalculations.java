package edu.westga.kenjiokamotoinvestmentcalculator;

import org.junit.Test;

import edu.westga.kenjiokamotoinvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestFutureValueCalculations {
    @Test
    public void when1000payment3percentFor10years() throws Exception {
        double payment = 1000;
        double rate = 0.03;
        int years = 10;
        String expected = "$11,463.88";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when2000payment3percentFor10years() throws Exception {
        double payment = 2000;
        double rate = 0.03;
        int years = 10;
        String expected = "$22,927.76";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when1000payment3percentFor0years() throws Exception {
        double payment = 1000;
        double rate = 0.03;
        int years = 0;
        String expected = "$0";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when100payment100percentFor11years() throws Exception {
        double payment = 50;
        double rate = 1.00;
        int years = 11;
        String expected = "$102,350";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when0payment10percentFor5years() throws Exception {
        double payment = 0;
        double rate = 0.1;
        int years = 5;
        String expected = "$0";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when100payment0percentFor5years() throws Exception {
        double payment = 100;
        double rate = 0;
        int years = 5;
        String expected = "$500";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when25CentPayment10percentFor30years() throws Exception {
        double payment = .25;
        double rate = 0.1;
        int years = 30;
        String expected = "$41.12";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when83423payment9point2percentFor33years() throws Exception {
        double payment = 834.23;
        double rate = 0.092;
        int years = 33;
        String expected = "$156,450.21";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when83423paymentNegative9point2percentFor33years() throws Exception {
        double payment = 834.23;
        double rate = -0.092;
        int years = 33;
        String expected = "$8,692.46";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void when10payment5percentFor3years() throws Exception {
        double payment = 10;
        double rate = .05;
        int years = 3;
        String expected = "$31.53";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
         public void whenYearsIsNegativeShouldThrowExceptin() throws Exception {
        double payment = 10;
        double rate = .05;
        int years = -3;
        try {
            InvestmentCalculator.getFutureValue(payment, rate, years);
            fail("Failed to throw IllegalArgumentException when years negative");
        } catch (IllegalArgumentException ex) {

        }
    }

    @Test
    public void whenNegative1000payment5percentFor30years() throws Exception {
        double payment = -1000;
        double rate = .05;
        int years = 30;
        String expected = "$-66,438.85";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }

    @Test
    public void whenNegative1000paymentNegative5percentFor30years() throws Exception {
        double payment = -1000;
        double rate = -.05;
        int years = 30;
        String expected = "$-15,707.22";
        assertEquals(expected, InvestmentCalculator.getFutureValue(payment, rate, years));
    }
}