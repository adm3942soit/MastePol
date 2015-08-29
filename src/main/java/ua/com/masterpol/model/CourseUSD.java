package ua.com.masterpol.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oxana on 29.08.2015.
 */
@Entity
@Table(name = "products")
public class CourseUSD {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    public long id;
    @Column(name = "BUYING_RATE")
    public Double  buyingRate;
    @Column(name = "SELLING_RATE")
    public Double sellingRate;
    @Column(name = "CREATED_DATE")
    public Date createdDate;

    public CourseUSD() {
    }

    public CourseUSD(Double buyingRate, Double sellingRate) {
        this.buyingRate = buyingRate;
        this.sellingRate = sellingRate;
        this.createdDate=new Date();
    }

    @Override
    public String toString() {
        return "CourseUSD{" +
                "id=" + id +
                ", buyingRate=" + buyingRate +
                ", sellingRate=" + sellingRate +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseUSD)) return false;

        CourseUSD courseUSD = (CourseUSD) o;

        if (getId() != courseUSD.getId()) return false;
        if (!getBuyingRate().equals(courseUSD.getBuyingRate())) return false;
        if (!getSellingRate().equals(courseUSD.getSellingRate())) return false;
        return getCreatedDate().equals(courseUSD.getCreatedDate());

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getBuyingRate().hashCode();
        result = 31 * result + getSellingRate().hashCode();
        result = 31 * result + getCreatedDate().hashCode();
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(Double buyingRate) {
        this.buyingRate = buyingRate;
    }

    public Double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
