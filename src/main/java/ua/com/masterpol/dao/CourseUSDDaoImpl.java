package ua.com.masterpol.dao;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.masterpol.dao.interfases.CourseUSDDao;
import ua.com.masterpol.model.CourseUSD;

import java.util.Date;

/**
 * Created by Oxana on 29.08.2015.
 */
@Repository
@Transactional
public class CourseUSDDaoImpl implements CourseUSDDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean createCourseUSD(Double buyingRate, Double sellingRate) {
        CourseUSD courseUSD = new CourseUSD(buyingRate, sellingRate);
        try {
            sessionFactory.getCurrentSession().save(courseUSD);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteTodayCourseUSD() {
        CourseUSD courseUSD = findTodayCourseUsd();
        try {
            sessionFactory.getCurrentSession().delete(courseUSD);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public CourseUSD findTodayCourseUsd() {

        return (CourseUSD) (sessionFactory.getCurrentSession().createCriteria(CourseUSD.class)
                .add(Restrictions.like("createdDate", new Date())).uniqueResult());
    }

    @Override
    public CourseUSD findCourseUSDByDate(Date createdDate) {

        return (CourseUSD) sessionFactory.getCurrentSession().createCriteria(CourseUSD.class)
                .add(Restrictions.like("createdDate", createdDate)).uniqueResult();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}