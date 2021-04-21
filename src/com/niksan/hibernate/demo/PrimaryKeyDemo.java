package com.niksan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niksan.hibernate.demo.enitty.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =  new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 students object
			System.out.println("Creating 3 new student object....");
			
			Student tempStudent1 = new Student("Niksan", "Karkee", "niksan@niksan.com");
			Student tempStudent2 = new Student("Pratima", "Tamang", "pratima@niksan.com");
			Student tempStudent3 = new Student("Mina", "karkee", "mina@niksan.com");
			
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
	

	}

}
