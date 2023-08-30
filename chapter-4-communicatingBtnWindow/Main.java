import javafx.application.Application;
import javafx.stage.Stage;

//import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
///import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.geometry.Pos;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Home page");

        Button button = new Button("Click for confirm box");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                boolean result = ConfirmBox.display("Confirm Box", "Are you shure!");
                System.out.println(result);
            }
        });

        /*
         * whenever user clicks cross on window he bypass the userdefine function
         * closeProgram()
         * to close our application properly when the user clicks either close button or
         * cross
         * we can use closeProgram() or window.setOnCloseRequest() methos to close our
         * application
         */

        // window.setOnCloseRequest()
        window.setOnCloseRequest(e -> {
            // here when we close application with cross it calls closeProgram()
            // in closeProgram() app takes confirmation to close if true close app else dont
            // without taking care of yes or no it closing the app when user click cross
            //  to prevent this we use consume()
            e.consume();
            closeProgram();
        });
        // e -> closeProgram() this is Called Lambda expression

        // button for closing program or application
        Button close = new Button("Close");
        close.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                closeProgram();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(button, close);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 250);

        window.setScene(scene);
        window.show();

    }

    // user define function for closing the application
    public void closeProgram() {
        boolean result = ConfirmBox.display("Exit", "Are you shure want to exit!");
        if (result) {
            window.close();
        }

    }
}