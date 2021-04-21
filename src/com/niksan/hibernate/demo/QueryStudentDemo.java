package com.niksan.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niksan.hibernate.demo.enitty.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory =  new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
					
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();
//			List<Student> theStudents = session.createQuery("from Student").getResultList();
		
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName = "karkee" 
			theStudents = session.createQuery("from Student std where std.lastName='karkee'").getResultList();
			
			
			// display the students
			System.out.println("\n\nStudents who have last name of karkee");
			displayStudents(theStudents);
			
			// query students: lastName = "karkee" OR firstname = "Pratima"
			theStudents = session.createQuery("from Student s where s.lastName = 'karkee'" +  
												" OR s.firstName = 'Pratima'", Student.class).getResultList();
			
			// display the students 
			System.out.println("\n\nStudents who have last name of karkee & first name of Pratima");
			displayStudents(theStudents);
			
			// query students where email LIKE 'niksan.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%niksan.com'").getResultList();
			
			System.out.println("\n\nStudents whose email ends with niksan.com");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
