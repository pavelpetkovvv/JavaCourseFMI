package model.com;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

public class Currency implements Serializable {

    Money currencyCode;
    double exchange;
    static Random rand;


    public Currency() {
        currencyCode = Money.EUR_USD;
        exchange = 1;
    }

    public Currency(Money currencyCode, double exchange) {
        this.currencyCode = currencyCode;
        this.exchange = exchange;
    }

    public Currency(Currency currency) {
        currencyCode = currency.getCurrencyCode();
        ChaneExchangeRate();
        exchange = currency.getExchange();
    }

    public Money getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Money currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getExchange() {
        return exchange;
    }

    public void setExchange(double exchange) {
        this.exchange = exchange;
    }

    public static Random getRand() {
        return rand;
    }

    public static void setRand(Random rand) {
        Currency.rand = rand;
    }

    @Override
    public String toString() {
        String strDouble = String.format("%.4f", exchange);
        return "currencyCode: " + currencyCode +
                ", exchange: " + strDouble + LocalTime.now();
    }

    void ChaneExchangeRate(){
        double change = rand.nextInt(4 + 3) - 3;
        exchange = exchange * (change/100);
    }
}
