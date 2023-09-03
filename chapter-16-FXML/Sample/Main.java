package Sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FXML Example");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        // FXML is Html for java in other words you can use it to design the view
        // in other words to design layouts or the interfaces for the user and then
        // you can stick all of your brains all of the logic in a separate file called controller
    }
}
