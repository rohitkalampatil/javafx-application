
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import jdk.internal.util.xml.impl.Input;

public class Main extends Application{

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Home page");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(8);
        grid.setVgap(8);

        // name label
        Label name = new Label("Enter your Name");
        GridPane.setConstraints(name,0,0);

        // name TextField
        TextField nameInput = new TextField("username");
        GridPane.setConstraints(nameInput,1,0);

        // password label
        Label pass = new Label("Enter your Password");
        GridPane.setConstraints(pass,0,1);

        // pass word TextField
        TextField passInput = new TextField();
        passInput.setPromptText("pasword");
        GridPane.setConstraints(passInput,1,1);

        //button login
        Button login =new Button("Login");
        GridPane.setConstraints(login,1,2);
        grid.getChildren().addAll(name,nameInput,passInput,pass,login);

        Scene  scene = new Scene(grid,300,250);
        window.setScene(scene);
        window.show();
    }
}
