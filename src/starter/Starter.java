package starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee; 

public class Starter {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			//ADDING EMPLOYEE
			
			System.out.println("Creating new employee object...");
			Employee emp = new Employee("Milena", "Petrovic", "BulBul");
			
			//begin transaction
			session.beginTransaction();

			System.out.println("\n\nSaving employee...");
			session.save(emp);

			session.getTransaction().commit();

			
			
			//READ THE EMPLOYEE
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n\nREAD employee with id..." +emp.getId());
			Employee emp1 = session.get(Employee.class, emp.getId());
			System.out.println("Employee: "+emp1);
			
			//commit transaction
			session.getTransaction().commit();

			
			//DELETE THE EMPLOYEE 
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			 
			Employee employer = session.get(Employee.class, 2);
			session.delete(employer);

			// commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("THE END");
 
		} finally {
			factory.close();
		}

	}

}
