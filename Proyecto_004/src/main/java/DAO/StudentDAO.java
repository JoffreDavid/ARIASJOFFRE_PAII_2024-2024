package DAO;


import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Student;

public class StudentDAO {

	public void createStudent(int id,String name,String lastname,int age) {
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        
        
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
        	Session session = sessionFactory.openSession();
        	
        	Student student = new Student();
        	student.setId(id);
        	student.setName(name);
        	student.setLastName(lastname);
        	student.setAge(age);
        	
        	session.beginTransaction();
        	session.persist(student);
      
        	session.getTransaction().commit();
    }
        
	}
	public Student readStudent(int id) {
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Student.class);

	    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
	        try (Session session = sessionFactory.openSession()) {
	            Student student = session.get(Student.class, id);

	            if (student != null) {
	                System.out.println("Student found:");
	                System.out.println("ID: " + student.getId());
	                System.out.println("Name: " + student.getName());
	                System.out.println("Last Name: " + student.getLastName());
	                System.out.println("Age: " + student.getAge());
	                return student;
	            } else {
	                System.out.println("Student with ID " + id + " not found.");
	                return null;
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Error finding student: " + e.getMessage());
	        return null;
	    }
	}
	
	public void updateStudent(int id, String name, String lastName, int age) {
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Student.class);

	    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
	        try (Session session = sessionFactory.openSession()) {
	            Student student = session.get(Student.class, id);

	            if (student != null) {
	                // Actualizar los datos del estudiante con los nuevos valores
	                student.setName(name);
	                student.setLastName(lastName);
	                student.setAge(age);

	                // Iniciar una transacción y guardar los cambios
	                session.beginTransaction();
	                session.update(student);
	                session.getTransaction().commit();

	                System.out.println("Student with ID " + id + " updated successfully.");
	            } else {
	                System.out.println("Student with ID " + id + " not found. Update operation aborted.");
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Error updating student: " + e.getMessage());
	    }
	}
	
	public void deleteStudent(int id) {
	    Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    configuration.addAnnotatedClass(Student.class);

	    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
	        try (Session session = sessionFactory.openSession()) {
	            Student student = session.get(Student.class, id);

	            if (student != null) {
	                session.beginTransaction();
	                session.delete(student);
	                session.getTransaction().commit();
	                System.out.println("Student with ID " + id + " deleted successfully.");
	            } else {
	                System.out.println("Student with ID " + id + " not found.");
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Error deleting student: " + e.getMessage());
	    }
	}

	
}
