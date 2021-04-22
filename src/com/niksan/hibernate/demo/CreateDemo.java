package com.niksan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niksan.hibernate.demo.entity.Instructor;
import com.niksan.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// create the objects
//			Instructor tempInstructor = new Instructor("niksan", "karkee", "nik@gmail.com");
//
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.nik.com/youtube",
//					"I love to code!!");
			Instructor tempInstructor = new Instructor("rijan", "karkee", "rij@gmail.com");

			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.rij.com/youtube",
					"I love to play guitar!");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will Also save the details object
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
