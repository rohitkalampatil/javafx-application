import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput,priceInput,quantityInput;
    Button buttonAdd,buttonDelete;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Table View");

        // Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
       // nameColumn.setStyle("-fx-alignment: CENTER"); to align items center
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Price column
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //nameInput
        nameInput = new TextField();
        nameInput.setPromptText("Enter Product");
        nameInput.setMinWidth(100);

        //price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");

        //quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText(" Quantity");

        //Button add
        buttonAdd = new Button("Add");
        buttonAdd.setOnAction(e -> addButtonClicked());
        buttonDelete = new Button("Delete");
        buttonDelete.setOnAction(e -> deleteButtonClicked());


        table= new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.getChildren().addAll(nameInput,priceInput,quantityInput,buttonAdd,buttonDelete);

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(table,hBox);
        window.setScene(new Scene(layout));
        window.show();
    }

    //Add button function
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));

        // now adding to table
        table.getItems().add(product);

        //now clear all input fields
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();

    }

    //delete button function
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected,allProducts;
        allProducts=table.getItems();
        productSelected=table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }
    /// get all the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("lenovo",555.0,2));
        products.add(new Product("hp",765.0,3));
        products.add(new Product("dell",874.0,3));
        products.add(new Product("macbook",846.0,4));
        products.add(new Product("think pad",344.0,2));
        products.add(new Product("microsoft",938.33,9));
        products.add(new Product("acer",333.3,0));
        return products;

    }


}
