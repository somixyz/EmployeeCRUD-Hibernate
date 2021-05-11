package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;

public class CRUDEmployee {

	static SessionFactory factory;
	static {
		System.out.println("STATIC BLOCK ACTIVATED...\n\n\n");
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
	}

	public static int AddEmployee(Employee employee) {

		// ADDING EMPLOYEE

		Session session = factory.getCurrentSession();
		
		//begin transaction
		System.out.println("Creating new employee object...");
		session.beginTransaction();
		
		//saving 
		System.out.println("\n\nSaving employee...");
		session.save(employee);

		// commit transaction
		session.getTransaction().commit();

		return employee.getId();
	}

	public static void ReadEmployee(int idEmployee) {

		// READ THE EMPLOYEE

		// now get a new session and start transaction
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		System.out.println("\n\nREAD employee with id..." + idEmployee);
		Employee emp1 = session.get(Employee.class, idEmployee);
		System.out.println("Displaying Employee: " + emp1);

		// commit transaction
		session.getTransaction().commit(); 
	}
	
	public static void deleteEmployee(int idEmployee) {
		//DELETE THE EMPLOYEE
		
		Session session = factory.getCurrentSession();
		session.beginTransaction(); 
		
		Employee employer = session.get(Employee.class, idEmployee);
		session.delete(employer);

		// commit the transaction
		session.getTransaction().commit();
	}
	
	public static void closeSessionFactory() { 
		try {
			factory.close();
		} finally { 
		}
		
	}
	
	public static Session getSession() {
		return factory.getCurrentSession();
	}

}
