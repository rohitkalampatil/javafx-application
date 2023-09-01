import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class Main extends Application{
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ChoiceBox Example");

        //dropdown list
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().addAll("banana","pineapple","orange");

        //set a default value
        choiceBox.setValue("Apple");
        
        // Adding Listener to dropdown selection changes
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });


        //button select
        Button button =  new Button("Select");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getChoice(choiceBox);
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);

        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();

    }
    private void getChoice(ChoiceBox<String> choiceBox){
        String fruit = choiceBox.getValue();
        System.out.println(fruit);

    }
}
