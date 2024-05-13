package ec.edu.uce.Proyecto_004;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DAO.StudentDAO;
import models.Student;
import models.Teacher;

public class App 
{
    public static void main( String[] args ){
    	
    	
    	StudentDAO studentDao= new StudentDAO();
    	//studentDao.createStudent(4, "Juan","Perez", 30);
    	//studentDao.readStudent(4);
    	studentDao.updateStudent(4, "Joffre", "Arias", 23);
    	//studentDao2.deleteStudent(4);
    	
    	/*
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Student.class);
        
        
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
        	Session session = sessionFactory.openSession();
        	
        	Student student = new Student();
        	
        	
        	student.setId(4);
        	student.setName("Joffre");
        	student.setLastName("Arias");
        	student.setAge(23);
        	
       
        	
        	session.beginTransaction();
        	session.persist(student);
      
        	session.getTransaction().commit();
        */
        	
        }
    }


