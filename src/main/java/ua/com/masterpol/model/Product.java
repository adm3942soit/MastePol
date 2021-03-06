package ua.com.masterpol.model;

import ua.com.masterpol.dao.CourseUSDDaoImpl;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oxana on 29.08.2015.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue
    public long productId;

    @Column(name = "NAME")
    public String name;
    @Column(name = "DESCRIPTION")
    public String description;
    @Column(name="PRICE_UAH")
    public Double priceUAH;
    @Column(name="PRICE_USD")
    public Double priceUSD;
    @Column(name="FOR_COUNT")
    public Integer forCount;
    @Column(name="ALL_COUNT")
    public Double allCount;
    @Column(name = "SHORT_NAME")
    public String shortName;

    @Column(name = "NAME_IMAGE")
    public String nameImage;

    @Column(name="CREATED_DATE")
    public Date createdDate;

    public Product() {
    }

    public Product(String name, String description,
                   Double priceUSD, Integer forCount, Double allCount,
                   String shortName, String nameImage) {
        this.name = name;
        this.description = description;
        CourseUSD courseUSD=(new CourseUSDDaoImpl()).findTodayCourseUsd();
        this.priceUAH = priceUSD*courseUSD.getBuyingRate();
        this.priceUSD = priceUSD;
        this.forCount = forCount;
        this.allCount = allCount;
        this.shortName = shortName;
        this.nameImage = nameImage;
        this.createdDate = new Date();
    }
    public Product(String name, String description,
                   Double priceUSD, Integer forCount,
                   String shortName) {
        this.name = name;
        this.description = description;
        CourseUSD courseUSD=(new CourseUSDDaoImpl()).findTodayCourseUsd();
        this.priceUAH = priceUSD*courseUSD.getBuyingRate();
        this.priceUSD = priceUSD;
        this.forCount = forCount;
        this.allCount++;
        this.shortName = shortName;
        this.createdDate = new Date();
    }
    public Product(String name, String description,
                   Double priceUSD, Integer forCount,Double count,
                   String shortName) {
        this.name = name;
        this.description = description;
        CourseUSD courseUSD=(new CourseUSDDaoImpl()).findTodayCourseUsd();
        this.priceUAH = priceUSD*courseUSD.getBuyingRate();
        this.priceUSD = priceUSD;
        this.forCount = forCount;
        this.allCount+=count;
        this.shortName = shortName;
        this.createdDate = new Date();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name +
                '\'' +
                ", description='" + description + '\'' +
                ", price=" + priceUAH +"for"+
                forCount+" "+shortName+
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductId() != product.getProductId()) return false;
        if (!getName().equals(product.getName())) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (!getPriceUAH().equals(product.getPriceUAH())) return false;
        if (!getPriceUSD().equals(product.getPriceUSD())) return false;
        if (!getForCount().equals(product.getForCount())) return false;
        if (!getAllCount().equals(product.getAllCount())) return false;
        if (!getShortName().equals(product.getShortName())) return false;
        return getCreatedDate().equals(product.getCreatedDate());

    }

    @Override
    public int hashCode() {
        int result = (int) (getProductId() ^ (getProductId() >>> 32));
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getPriceUAH().hashCode();
        result = 31 * result + getPriceUSD().hashCode();
        result = 31 * result + getForCount().hashCode();
        result = 31 * result + getAllCount().hashCode();
        result = 31 * result + getShortName().hashCode();
        result = 31 * result + getCreatedDate().hashCode();
        return result;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPriceUAH() {
        return priceUAH;
    }

    public void setPriceUAH(Double priceUAH) {
        this.priceUAH = priceUAH;
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

    public Double getAllCount() {
        return allCount;
    }

    public void setAllCount(Double allCount) {
        this.allCount = allCount;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }
}
