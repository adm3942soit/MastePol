package ua.com.masterpol.bo;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.masterpol.bo.interfaces.CourseUSDBO;
import ua.com.masterpol.dao.CourseUSDDaoImpl;
import ua.com.masterpol.dao.interfases.CourseUSDDao;
import ua.com.masterpol.model.CourseUSD;

import java.util.Date;

/**
 * Created by Oxana on 29.08.2015.
 */
public class CourseUSDBOImpl implements CourseUSDBO {

    CourseUSDDao courseUSDDao;
    @Override
    public boolean createCourseUSD(Double buyingRate, Double sellingRate) {
        return courseUSDDao.createCourseUSD(buyingRate, sellingRate)
                ;
    }

    @Override
    public boolean deleteTodayCourseUSD() {

        return courseUSDDao.deleteTodayCourseUSD();
    }

    @Override
    public CourseUSD findTodayCourseUsd() {

        return courseUSDDao.findTodayCourseUsd();
    }

    @Override
    public CourseUSD findCourseUSDByDate(Date createdDate) {
        return courseUSDDao.findCourseUSDByDate(createdDate);
    }

    public CourseUSDDao getCourseUSDDao() {
        return courseUSDDao;
    }

    public void setCourseUSDDao(CourseUSDDao courseUSDDao) {
        this.courseUSDDao = courseUSDDao;
    }
}
