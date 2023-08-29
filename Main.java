import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception{
        //Added title to main window
        
        primaryStage.setTitle("Main page");
        
        //created button
        
        button = new Button();
        button.setText("click");
        
        // to display any thing on window we need create layout
        //StackPane creates a layout and we need to add children i.e element on layout
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        //now we need to create scene to display our button or children
        //scene is content on your window

        Scene scene =new Scene(layout, 300, 250);
            primaryStage.setScene(scene);
            primaryStage.show();

    }
        
}