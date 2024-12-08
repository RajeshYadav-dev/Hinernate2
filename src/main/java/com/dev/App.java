package com.dev;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dev.entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	Configuration  cfg = null;
    	SessionFactory sessionFactory = null;
    	Session session = null;
    	Transaction tx = null;
    	
    	boolean flag = false;  
    	
    	cfg = new Configuration();
    	    	
//    	Student std = new Student();
////    	std.setId(2);
//    	std.setName("Ramesh");
//    	std.setCity("Delhi");
//    	std.setBranch("ece");
//    	std.setFee(2000.00);
    	try {
    		cfg.configure("/com/dev/config/hibernate.cfg.xml");
        	sessionFactory = cfg.buildSessionFactory(); 
        	session = sessionFactory.openSession();
        	tx = session.beginTransaction();
//    		session.save(std);
        	Student std = session.get(Student.class, 1); 
        	tx.commit();
    		flag = true;
    		System.out.println("Object fetch");
    		System.out.println(std);
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if (!flag) {
				tx.rollback();
			}
			session.close();
			sessionFactory.close();
		}
        
    }
}
