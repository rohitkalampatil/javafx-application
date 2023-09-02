import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Working with CSS");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        //label
        TextField textField = new TextField();
        textField.setPromptText("Enter Something");
        GridPane.setConstraints(textField,0,0);


        Button button = new Button("Click");
        GridPane.setConstraints(button,1,0);

        Button signUp = new Button("Sign Up");
        signUp.getStyleClass().add("btn-signUp");
        GridPane.setConstraints(signUp,2,0);

        Label name = new Label();
        name.setText("Hey There");
        name.setId("bold-name");
        GridPane.setConstraints(name,0,2);

        gridPane.getChildren().addAll(textField,button,signUp,name);


        Scene scene = new Scene(gridPane,400,200);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();
    }
}
