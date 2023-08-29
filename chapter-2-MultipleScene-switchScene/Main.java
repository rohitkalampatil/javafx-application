import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;
     
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        Label label = new Label("Welcome to first scene");
        Button button1 = new Button("click");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.setScene(scene2);
            }
        });

        // layout 1 childrens ae leid in verticle column
        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 600, 600);

        // Button 2
        Button button2 = new Button("back");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.setScene(scene1);
            }
        });

        // layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 600);

        // right now we have two scene let window know which scene will display first or
        // default scene for
        // which scene would display first
        window.setScene(scene1);
        window.setTitle("first scene");
        window.show();

    }

}