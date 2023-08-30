import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

public class ConfirmBox {
    
    static boolean action;

    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(120);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);

        Button button1= new Button("Yes");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                action=true;
                window.close();
            }
        });

        Button button2= new Button("No");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                action=false;
                window.close();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button1,button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return action;
    }

}
