import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
public class Main extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Menu Example");

        //File menu
        Menu fileMenu = new Menu("File");

        //file menu items
        MenuItem itemNew = new MenuItem("New...");
        itemNew.setOnAction(e -> System.out.println("Create a new file"));
        fileMenu.getItems().add(itemNew);

        fileMenu.getItems().add(new MenuItem("open..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("save"));
        fileMenu.getItems().add(new MenuItem("Setting..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        //Exit MenuItem
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnAction(e -> window.close());
        fileMenu.getItems().add(itemExit);

        //Edit Menu
        Menu editMenu = new Menu("Edit");

        //edit MenuItems
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));
        //paste menuItem
        MenuItem paste = new MenuItem("Pest");
        paste.setOnAction(e -> System.out.println("pasting"));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        // Help Menu

        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected())
                System.out.println("Program will now display line numbers");
            else
                System.out.println("Hiding line number");
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        layout =new BorderPane();
        layout.setTop(menuBar);
        window.setScene(new Scene(layout,600,450));
        window.show();
    }
}
