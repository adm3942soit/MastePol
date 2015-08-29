package ua.com.masterpol.beans;

import ua.com.masterpol.bo.interfaces.CourseUSDBO;
import ua.com.masterpol.model.CourseUSD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Oxana on 29.08.2015.
 */
public class CourseUSDBean implements Serializable {
    CourseUSDBO courseUSDBO;
    Double buyingRate;
    Double sellingRate;
    public List<CourseUSD> findAllCourses(Date fromDate, Date toDate){

      return new ArrayList<CourseUSD>();
    }
    public boolean createCourseUSD(Double buyingRate, Double sellingRate){
        return courseUSDBO.createCourseUSD(buyingRate, sellingRate);
    }
    public CourseUSD getTodayCourseUSD(){
        return courseUSDBO.findTodayCourseUsd();
    }
}
