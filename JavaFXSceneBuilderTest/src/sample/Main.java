package sample;

import LoginSystem.Login;
import LoginSystem.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Login user1 = new Login();
        user1.setUsername("pavel");
        user1.setPassword("123456");
        //Users usr = new Users();
        Users.users.add(user1);
        launch(args);

    }
}
