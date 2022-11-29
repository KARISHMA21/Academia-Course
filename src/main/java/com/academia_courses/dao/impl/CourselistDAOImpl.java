package com.academia_courses.dao.impl;

import com.academia_courses.bean.Course;
import com.academia_courses.bean.Employee;
import com.academia_courses.dao.CourslistDAO;
import com.academia_courses.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class CourselistDAOImpl implements CourslistDAO {
    /*

    */

    @Override
    public List<Course> showcoursedetails() {

        List<Course> courselist = new ArrayList<>();

            try (Session session = HibernateSessionUtil.getSession()){
                for (
                        final Object course: session
                        .createQuery("FROM Course").list()

                )
                 //   System.out.println(course);
                    courselist.add((Course) course);
               // System.out.println("=============================300000000000000000000000==================================================================");
                //  System.out.println(course);

               // System.out.println("==========================3333333333333333333333333333333333=====================================================================");
            }
            catch (HibernateException exception) {
                System.out.println(exception.getLocalizedMessage());
            }

            return courselist;
        }

    @Override
    public  Boolean removecourse(Integer courseid) {
        System.out.println("=================================================================================================");
        System.out.println("Removing course : " + courseid);
        System.out.println("===============================================================================================");

        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String query_string="DELETE FROM Course WHERE id=:courseid";
            Query query=session.createQuery(query_string);
            query.setParameter("courseid", courseid);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public Course showcoursedetails(Integer courseid){
        try (Session session = HibernateSessionUtil.getSession()){

            System.out.println("==================================================================================================");
            System.out.println(" In edit page of course :"+ courseid);
            System.out.println("===============================================================================================");
            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Course WHERE id = :courseid"
                            )
                            .setParameter("courseid", courseid)
                            .list()
            );
            System.out.println("==================================================================================================");
            System.out.println(result);
            System.out.println("===============================================================================================");
            // If no valid admin found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Course) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    public Boolean updatecourse(Integer courseid,Course coursedetails_update){
        System.out.println("=================================================================================================");
        System.out.println("Updating course : " + courseid);
        System.out.println("===============================================================================================");

        try (Session session = HibernateSessionUtil.getSession()) {

            Integer Id = coursedetails_update.getId();
            String code = coursedetails_update.getCourse_code();
            String name = coursedetails_update.getCourse_name();
            String description = coursedetails_update.getCourse_description();
            Integer year = coursedetails_update.getCourse_year();
            Integer term = coursedetails_update.getCourse_term();
            Integer credits = coursedetails_update.getCourse_credits();
            Integer capacity = coursedetails_update.getCourse_capacity();
            String faculty = coursedetails_update.getCourse_faculty();


            Transaction transaction = session.beginTransaction();
            String query_string="UPDATE Course set " +
                    "course_name=course_name," +
                    " course_description=course_description," +
                    "course_year=course_year, " +
                    "course_term = course_term," +
                    "course_credits = course_credits," +
                    "course_capacity = course_capacity," +
                    "course_faculty = course_faculty WHERE id=:courseid";
            Query query=session.createQuery(query_string);
            query.setParameter("course_name", name);
            query.setParameter("course_description", description);
            query.setParameter("course_year",year);
            query.setParameter("course_term",term);
            query.setParameter("course_credits",credits);
            query.setParameter("course_capacity",capacity);
            query.setParameter("course_faculty",faculty);
            query.setParameter("courseid", courseid);
            query.executeUpdate();
            transaction.commit();
            return true;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return false;

    }


}

/*
his.course_name = course_name;
        this.course_description = course_description;
        this.course_year = course_year;
        this.course_term = course_term;
        this.course_credits = course_credits;
        this.course_capacity = course_capacity;
        this.course_faculty = course_faculty;


 "FROM Employee WHERE email = :Email and password = :Password"
         )
         .setParameter("Email", Email)
         .setParameter("Password", Password)
         .list()


 */