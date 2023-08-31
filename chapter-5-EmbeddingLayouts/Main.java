import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;


public class Main extends Application {
    Stage window;

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Home page");

        HBox topmenu = new HBox(10);
        Button button1 = new Button("file");
        Button button2 = new Button("view");
        Button button3 = new Button("edit");
        Button button4 = new Button("exit");
        topmenu.setAlignment(Pos.CENTER_LEFT);
        //topmenu.setPadding(new Insets(10,10,50,40));
        topmenu.getChildren().addAll(button1,button2,button3,button4);

        VBox leftmenu = new VBox(20);
        Button buttonA = new Button("Button A");
        Button buttonB = new Button("Button B");
        Button buttonC = new Button("Button C");
        leftmenu.getChildren().addAll(buttonA,buttonB,buttonC);

        BorderPane layout = new BorderPane();
        layout.setTop(topmenu);
        layout.setLeft(leftmenu);
        Scene scene = new Scene(layout,300,250);

        window.setScene(scene);
        window.show();

    }
}