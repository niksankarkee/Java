package com.niksan.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.niksan.hibernate.demo.entity.Instructor;
import com.niksan.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 1;

			Instructor tmpInstructor = session.get(Instructor.class, theId);

			// delete intructors
			if (tmpInstructor != null) {
				System.out.println("Deleting: " + tmpInstructor);

				// Note: will also delete associated "details" object
				// because of CascadeTyle.ALL
				session.delete(tmpInstructor);
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
