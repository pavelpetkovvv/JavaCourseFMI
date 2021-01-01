package sample;

import LoginSystem.User;
import LoginSystem.UsersList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("loginScene.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        //adding 2 users for testing purposes
        User user1 = new User("pavel", "123456");
        User user2 = new User("stefan", "654321");
        UsersList.users.add(user1);
        UsersList.users.add(user2);


        launch(args);
    }
}
