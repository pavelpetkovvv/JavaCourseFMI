package sample;


import Client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;

public class Controller {

    Client client = new Client("localHost", 1234);

    @FXML
    private javafx.scene.control.Button sendButton;

    @FXML
    private javafx.scene.control.TextField messageToSend;

    @FXML
    private javafx.scene.control.TextField recievedMessage;

    public void setSendButton(ActionEvent e){
        client.sendMessage(messageToSend.getText());
        //client.run();
    }

}

