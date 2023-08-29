import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        // Added title to main window

        primaryStage.setTitle("Main page");

        // created button

        button = new Button();

        // sets text on button
        button.setText("click");

        // add event on button i.e to make button responsive whenever user click
        // it will need to implement eventhandler
        button.setOnAction(this);
        // this stand for event is gona handle in this class

        // to display any thing on window we need create layout
        // StackPane creates a layout and we need to add children i.e element on layout

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        // now we need to create scene to display our button or children
        // scene is content on your window

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // to add ebvent handler when user click button
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            System.out.println("touched button");
        }
    }
}