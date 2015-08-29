package ua.com.masterpol.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.masterpol.dao.interfases.ProductDao;
import ua.com.masterpol.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oxana on 29.08.2015.
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {

        List<Product> list=(ArrayList < Product >) sessionFactory.getCurrentSession().
 createQuery("FROM Product").list();
//                createCriteria(Product.class).list();
                return (list==null?new ArrayList<Product>():list);
    }

    @Override
    public Product findByName(String name) {

        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("productID", id)).uniqueResult();
    }
    @Override
    public boolean createProduct(String name, String description, Double priseUSD,
                              Integer forCount, Double count, String shortName, String nameImage
    ) {
        Product product = new Product(name, description, priseUSD, forCount, count, shortName, nameImage);
        try {
            sessionFactory.getCurrentSession().save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }
    @Override
    public boolean addProduct(String name, String description, Double priseUSD,
                              Integer forCount, Double count, String shortName
    ) {
        Product product = new Product(name, description, priseUSD, forCount, count, shortName);
        try {
            sessionFactory.getCurrentSession().save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }
    @Override
    public boolean addProduct(Product product){
        try {
            sessionFactory.getCurrentSession().save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean deleteProductByName(String name) {
        Product product = new ProductDaoImpl().findByName(name);
        try {
            sessionFactory.getCurrentSession().delete(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteProductById(Long id) {
        Product product = new ProductDaoImpl().findById(id);
        try {
            sessionFactory.getCurrentSession().delete(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean changeImage(String name, String nameImage) {
        Product product = new ProductDaoImpl().findByName(name);
        product.setNameImage(nameImage);
        try {
            sessionFactory.getCurrentSession().save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
