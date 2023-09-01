import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    ComboBox<String> comboBox;
    Button button;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ComboBox Example");

        //ComboBox <what kind data u use>
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "avatar",
                "marvel","disney"
        );

        comboBox.setPromptText("what is your fav movie");
        //for user input
        comboBox.setEditable(true);
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(comboBox.getValue());
            }
        });

        // button
        button =new Button("choose");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                printMovie();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox,button);

        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    private void printMovie(){
        System.out.println(comboBox.getValue());
    }
}
