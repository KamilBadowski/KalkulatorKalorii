package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import modelFx.ProductModel;
import models.Product;


public class AddController {
    @FXML
    private Button addProduct;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField caloriesTextField;

    private ProductModel productModel;

    @FXML
    void initialize() {
        this.productModel = new ProductModel();

    }

    public void addProductDatabase() {
        String name = this.nameTextField.getText();
        String calories = this.caloriesTextField.getText();

        if (!name.trim().isEmpty() && !calories.trim().isEmpty()) {
            Product product = new Product();
            product.setName(name);
            product.setCalories(Integer.parseInt(calories));
            this.productModel.addProduct(product);

            Stage stage = (Stage) nameTextField.getScene().getWindow();
            stage.close();
        }


    }

}
