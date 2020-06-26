package database;

import models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.DbManager;

import javax.persistence.Query;
import java.util.List;

public class ProductDao {

    private SessionFactory sessionFactory;

    public ProductDao() {
        this.sessionFactory = DbManager.getSessionFactory();
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("from Product ", Product.class).list();
        session.getTransaction().commit();
        return products;
        // return sessionFactory.openSession().createQuery("from Product").list();
    }

    public void deleteProductById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product productToDelete = session.get(Product.class, id);
        session.delete(productToDelete);
        session.getTransaction().commit();
    }

    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }


}
