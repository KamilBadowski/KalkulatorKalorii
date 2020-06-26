package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
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
        this.productModel = new ProductModel();//dodajemy model

    }

    public void addProductDatabase() {
        String name = this.nameTextField.getText();
        String calories = this.caloriesTextField.getText();

        if (!name.trim().isEmpty() && !calories.trim().isEmpty()) {
            Product product = new Product();
            product.setName(name);
            product.setCalories(Integer.parseInt(calories));
            this.productModel.addProduct(product);

            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("Dodano produkt");
            infoAlert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            infoAlert.setHeaderText("Dodano produkt i przypisano do niego kalorie");
            infoAlert.setContentText("Produkt " + product.getName() + " " + product.getCalories() + " " +
                    "został utworzony poprawnie!\nID produktu w bazie to " + product.getId());
            infoAlert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Brak danych");
            alert.setHeaderText("Error");
            alert.setContentText("Podaj poprawne dane");
            alert.showAndWait();
        }

    }

}
