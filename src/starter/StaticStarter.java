package starter;

import org.hibernate.Session;

import entity.Employee;
import repository.CRUDEmployee;

public class StaticStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Employee emp = new Employee("Pero", "Testovic", "BulBul");
		
		//add employee
		int idEmp = CRUDEmployee.AddEmployee(emp);
		
		//read employee
		Session ses =CRUDEmployee.getSession();
		ses.beginTransaction();
		Employee emp2 = ses.get(Employee.class, idEmp);
		System.out.println("Employee with id=5" +emp2);
		ses.getTransaction().commit();
		
		//read employee 2nd approach
		CRUDEmployee.ReadEmployee(2);
		
		//delete employee
		CRUDEmployee.deleteEmployee(5);
		
		CRUDEmployee.closeSessionFactory();
		
	}

}
