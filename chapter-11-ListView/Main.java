import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;

public class Main extends Application {

    Stage window;
    Button button;
    ListView<String> listView;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("List View");
        button =new Button("click");

        //adding items
        listView = new ListView<>();
        listView.getItems().addAll("Ironman","hulk","captain america","black hat");

        // default we can select only one
        // to select multiple use selection modal

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // adding event to selected item

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listViewItems();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView,button);

        Scene scene =  new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }
    private void listViewItems(){
        /*
        * all  the list that you work with in JavaFX are of type Observable list so
        * what we can do is we can actually grab the items from here in other words
        * we can grab whatever items the user selected store them in side an observable
        */
        String item = "";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems();

        for (String m: movies){
            item += m +"\n";
        }
        System.out.println(item);

    }
}
