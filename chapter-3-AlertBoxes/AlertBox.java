import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import javax.swing.Action;
import javax.xml.stream.util.EventReaderDelegate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(120);

        Label label = new Label();
        label.setText(message);

        Button button = new Button("colse window");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                window.close();
            }
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
