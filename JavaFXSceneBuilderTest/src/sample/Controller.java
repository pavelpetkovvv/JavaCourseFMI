package sample;
import LoginSystem.Login;
import LoginSystem.Users;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private void handleButton1Action(ActionEvent event) {
        String username = login.getText();
        String pass = password.getText();
        for (Login i:Users.users){
            if(i.getUsername().equals(username)){
                if (i.getPassword().equals(pass))
                    System.out.println("Success");
                else
                    System.out.println("Incorrect password");
            }else
                System.out.println("User does not exist");
        }
    }

}
