package sample;

import Encryption.CipherMethod;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class Controller {


    @FXML
    private TextField CipherTextField;

    @FXML
    private TextField TxtToEnDeCryptField;

    @FXML
    private TextField OutputField;

    @FXML
    private Button EncryptButton;

    @FXML
    private Button DecryptButton;

    @FXML
    private Button QuitButton;


    @FXML
    private void handleDecryptButton (ActionEvent event){
        CipherMethod cipherMethod = new CipherMethod();
        OutputField.setText(cipherMethod.decryptText(TxtToEnDeCryptField.getText(), CipherTextField.getText()));
    }

    @FXML
    private void handleEncryptButton (ActionEvent event){
        CipherMethod cipherMethod = new CipherMethod();
        OutputField.setText(cipherMethod.encryptText(TxtToEnDeCryptField.getText(), CipherTextField.getText()));
    }

    @FXML
    public void handleQuitButton(ActionEvent event) {
        Platform.exit();
    }
}
