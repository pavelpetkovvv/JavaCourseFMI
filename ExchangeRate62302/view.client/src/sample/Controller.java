package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.com.Currency;
import model.com.ITradeService;
import model.com.StockExchangeController;
import model.com.TradeProduct;

import java.io.IOException;
import java.net.Socket;


public class Controller {

    TextArea txaOutput;
    StockExchangeController controller;
    ITradeService trade;
    Alert mbox;

    void initialize(){
        mbox = new Alert(Alert.AlertType.CONFIRMATION);
        controller = new StockExchangeController();
        readTrade();
        controller.onTraders();
    }

    void readTrade(){
        try {
            Socket socket = new Socket("localhost", 12345);
            socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Currency[] updateCurrency(){
        controller.setTraders(this::updateCurrency);
        return trade.getTrade();
    }

}


