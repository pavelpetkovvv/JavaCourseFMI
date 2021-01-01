package sample;
import LoginSystem.User;
import LoginSystem.UsersList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;


    @FXML
    private PasswordField newPasswordField;

    @FXML
    private TextField newUsernameField;


    @FXML
    private void handleLoginButtonAction(ActionEvent event) {

        String username = login.getText();
        String pass = password.getText();
        boolean userFound = false;


        for (User i: UsersList.users){
            if(i.getUsername().equals(username)){
                if (i.getPassword().equals(pass))
                    System.out.println("Success");
                else
                    System.out.println("Incorrect password");
                userFound = true;
            }
        }
        if(!userFound)
            System.out.println("User does not exist");
    }


    @FXML
    private void handleSignUpButtonAction(ActionEvent event) {

        User user = new User(newUsernameField.getText(), newPasswordField.getText());
        UsersList.users.add(user);
    }

    @FXML
    private void handleIAlreadyHaveAccountButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleCreateAccountButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signupScene.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
        window.setTitle("Sign up");
        window.setScene(scene);
        window.show();
    }

}
