package modelFx;

import database.ProductDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Product;
import org.hibernate.Session;
import utils.ConverterProduct;

import java.util.List;

public class ProductModel {

    private ObservableList<ProductFx> productFxObservableList = FXCollections.observableArrayList();

    public void init() {
        ProductDao productDao = new ProductDao();
        List<Product> productList = productDao.getAllProducts();
        this.productFxObservableList.clear();
        productList.forEach(product -> {
            ProductFx productFx = ConverterProduct.convertToProductFx(product);
            this.productFxObservableList.add(productFx);
        });
    }

    public void deleteProductById(long id) {
        ProductDao productDao = new ProductDao();
        productDao.deleteProductById(id);
        init();
    }

    public void addProduct(Product product) {
        ProductDao productDao = new ProductDao();
        productDao.addProduct(product);
        init();
    }

    public ObservableList<ProductFx> getProductFxObservableList() {
        return productFxObservableList;
    }
}
