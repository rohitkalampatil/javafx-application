import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
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

        // checkBox
        CheckBox box1 = new CheckBox("first");
        CheckBox box2 = new CheckBox("second");
        CheckBox box3 = new CheckBox("third");

        //if default select one
        box1.setSelected(true);

        //button order
        Button button =new Button("order");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleOptions(box1,box2,box3);
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1,box2,box3,button);

        Scene scene = new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    //handling  option checkbox
    private void handleOptions(CheckBox box1,CheckBox box2,CheckBox box3){
        String message = "user order:\n";

        if(box1.isSelected())
            message += "first\n";

        if(box2.isSelected())
            message += "second\n";

        if(box3.isSelected())
            message += "third\n";

        System.out.println(message);
    }
}
