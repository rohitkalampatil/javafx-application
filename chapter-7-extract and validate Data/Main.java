import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.*;
public class Main extends Application{

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Home Page");

        // Text Field
        TextField nameInput = new TextField();
        Button button = new Button("Send");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(nameInput.getText());
                isInt(nameInput.getText());
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput,button);
        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    // validation user input data
    private boolean isInt(String message){
        try
        {
            int age = Integer.parseInt(message);
            System.out.println("user is: "+age);
            return true;
        }catch (Exception e){
            System.out.println("error "+message+" is not Number");
            return false;
        }
    }
}
