package model.com;

import java.io.Serializable;

public class TradeProduct implements Serializable, ITradeService{
    Currency[] moneyToTrade;

    public TradeProduct() {
        Currency c1 = new Currency(Money.EUR_USD, 1.130);
        Currency c2 = new Currency(Money.GBP_USD, 1.65);
        Currency c3 = new Currency(Money.USD_JPY, 107.102);
        Currency c4 = new Currency(Money.USD_RUB, 34.37);

        this.moneyToTrade = new Currency[4];

        moneyToTrade[0] = c1;
        moneyToTrade[1] = c2;
        moneyToTrade[2] = c3;
        moneyToTrade[3] = c4;

    }

    public synchronized Currency[] getMoneyToTrade() {
        return moneyToTrade;
    }

    public synchronized void setMoneyToTrade(Currency[] moneyToTrade) {
        this.moneyToTrade = moneyToTrade;
    }

    @Override
    public Currency[] getTrade() {
        return getMoneyToTrade();
    }
}
