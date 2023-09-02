import com.sun.crypto.provider.HmacMD5KeyGenerator;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene;
    TreeView<String> treeView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Tree View");

        TreeItem<String> root,file,tool;

        //root
        root =new TreeItem<>();
        root.setExpanded(true);
        //file
        file = makeBranch("file",root);
        makeBranch("new",file);
        makeBranch("edit",file);
        makeBranch("view",file);

        //tool
        tool = makeBranch("tool",root);
        makeBranch("zoom",tool);
        makeBranch("merge",tool);

        //create treeView
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                if (newValue!= null)
                    System.out.println(newValue.getValue());
            }
        });

        // Layout
        StackPane layout = new StackPane();
        layout.getChildren().addAll(treeView);

        Scene scene =  new Scene(layout,300,250);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title,TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(false);
        parent.getChildren().add(item);
        return item;
    }
}
