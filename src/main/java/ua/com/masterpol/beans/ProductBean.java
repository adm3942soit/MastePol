package ua.com.masterpol.beans;

import ua.com.masterpol.bo.ProductBOImpl;
import ua.com.masterpol.bo.interfaces.ProductBO;
import ua.com.masterpol.model.Product;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Oxana on 29.08.2015.
 */
public class ProductBean implements Serializable {
    ProductBO productBo=new ProductBOImpl();
    CourseUSDBean courseUSD;

    String name;
    Double priceUSD;
    Integer forCount;
    String description;
    Double count;
    String nameImage;
    String shortName;
    public boolean createProduct(String name, String description, Double priceUSD, Integer forCount,
                              Double count, String shortName, String nameImage){
        return productBo.createProduct(name, description, priceUSD, forCount, count,
                shortName, nameImage);
    }
    public boolean addProduct(String name, String description, Double priceUSD, Integer forCount,
                              Double count, String shortName){
        return productBo.addProduct(name, description, priceUSD, forCount, count,
                shortName);
    }
    public boolean addProduct(){
        Product product=new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPriceUSD(priceUSD);
        product.setPriceUAH(priceUSD * courseUSD.getTodayCourseUSD().getBuyingRate());
        product.setForCount(forCount);
        product.setShortName(shortName);
        product.setAllCount(count);
        product.setNameImage(nameImage);
       return  productBo.addProduct(product);
    }
    public List<Product> getAllProducts(){

        return productBo.findAll();
    }
    public boolean deleteProductByName(String name){

        return productBo.deleteProductByName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(Double priceUSD) {
        this.priceUSD = priceUSD;
    }

    public Integer getForCount() {
        return forCount;
    }

    public void setForCount(Integer forCount) {
        this.forCount = forCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public void clearForm(){
        this.name="";
        this.description="";
        this.priceUSD=0.0;
        this.forCount=0;
        this.count=0.0;
        this.nameImage="";
        this.shortName="";
    }

    public ProductBO getProductBo() {
        return productBo;
    }

    public void setProductBo(ProductBO productBo) {
        this.productBo = productBo;
    }

    public CourseUSDBean getCourseUSD() {
        return courseUSD;
    }

    public void setCourseUSD(CourseUSDBean courseUSD) {
        this.courseUSD = courseUSD;
    }
}