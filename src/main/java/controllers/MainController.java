package controllers;

import database.ProductDao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelFx.ProductFx;
import modelFx.ProductModel;
import models.Product;

import java.util.List;

public class MainController {

    @FXML
    private Button btnShowProducts;

    @FXML
    private Button btnAddProducts;

    @FXML
    private Button btnEditProduct;

    @FXML
    private TableView productTable;

    @FXML
    private TableColumn<ProductFx, Long> columnId;

    @FXML
    private TableColumn<ProductFx, String> columnName;

    @FXML
    private TableColumn<ProductFx, Integer> columnCalories;

    private ProductModel productModel;

    @FXML
    void initialize() {
        this.productModel = new ProductModel();
        this.productModel.init();
        showProductsList();
    }

    public void showProductsList() {
        this.productModel.init();
        this.productTable.setItems(this.productModel.getProductFxObservableList());
        this.columnId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        this.columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.columnCalories.setCellValueFactory(cellData -> cellData.getValue().caloriesProperty().asObject());


    }

    public void addProduct() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Dodaj produkt");
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("Cant Load new window");
        }
    }

    public void editProduct() {
        System.out.println("Edit products");

    }

    public void deleteProduct() {

        ProductFx productFx = (ProductFx) productTable.getSelectionModel().getSelectedItem();
        long id = productFx.getId();
        this.productModel.deleteProductById(id);

    }
}
