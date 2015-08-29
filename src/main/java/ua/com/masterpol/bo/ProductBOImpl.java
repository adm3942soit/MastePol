package ua.com.masterpol.bo;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.masterpol.bo.interfaces.ProductBO;
import ua.com.masterpol.dao.ProductDaoImpl;
import ua.com.masterpol.dao.interfases.ProductDao;
import ua.com.masterpol.model.Product;

import java.util.List;

/**
 * Created by Oxana on 29.08.2015.
 */
public class ProductBOImpl implements ProductBO{

    ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }
    @Override
    public boolean createProduct(String name, String description, Double priseUSD,
                                 Integer forCount, Double count, String shortName, String nameImage) {
        return productDao.createProduct(name, description, priseUSD, forCount, count, shortName, nameImage);
    }
    @Override
    public boolean addProduct(String name, String description, Double priseUSD, Integer forCount, Double count, String shortName) {
        return productDao.addProduct(name, description, priseUSD, forCount, count, shortName);
    }
    @Override
    public boolean addProduct(Product product){
        return productDao.addProduct(product);
    }
    @Override
    public boolean deleteProductByName(String name) {
        return productDao.deleteProductByName(name);
    }

    @Override
    public boolean deleteProductById(Long id) {
        return productDao.deleteProductById(id);
    }

    @Override
    public boolean changeImage(String name, String nameImage) {
        return productDao.changeImage(name, nameImage);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
}
