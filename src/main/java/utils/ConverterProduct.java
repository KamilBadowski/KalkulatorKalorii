package utils;

import modelFx.ProductFx;
import models.Product;

public class ConverterProduct {

    public static Product convertToProduct(ProductFx productFx) {
        Product product = new Product();
        product.setId(productFx.getId());
        product.setName(productFx.getName());
        product.setCalories(productFx.getCalories());
        return product;
    }

    public static ProductFx convertToProductFx(Product product) {
        ProductFx productFx = new ProductFx();
        productFx.setId(product.getId());
        productFx.setName(product.getName());
        productFx.setCalories(product.getCalories());
        return productFx;
    }

}
