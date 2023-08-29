import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.event.*;

public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primStage) throws Exception {
        window = primStage;
        window.setTitle("Home page");

        button = new Button("click me", button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                AlertBox.display("Alert", "Hello there");
            }
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 400, 300);
        
        window.setScene(scene);
        window.show();

    }
}