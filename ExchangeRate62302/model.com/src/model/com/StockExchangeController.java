package model.com;

import javafx.scene.control.TextArea;

import java.util.function.Supplier;

public class StockExchangeController implements Runnable{

    javafx.scene.control.TextArea txaExchange;
    Currency[] currency;
    String txtUpdate;
    Supplier<Currency[]> traders;
    TradeProduct tradeProduct = new TradeProduct();

    public StockExchangeController() {
        txaExchange = new TextArea();
    }

    public void setTraders(Supplier<Currency[]> traders) {
        this.traders = traders;
    }

    @Override
    public void run() {
        while (true){
            traders.get();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String text = new String();
            for(Currency c : currency){
                text.concat(c.toString() + "\n");
            }

            txaExchange.setText(text);
        }
    }

    public void onTraders(){
        StockExchangeController stockExchangeController = new StockExchangeController();
        Thread thread = new Thread(stockExchangeController);
    }
}
