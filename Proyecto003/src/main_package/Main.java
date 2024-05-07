package main_package;

import java.sql.SQLException;

import model_package.Alumn;
import model_package.Conexion;
import model_package.Professor;
import model_package.Schedules;
import model_package.Subjects;

public class Main {

	/*
	 * Author: Arias Joffre
	 * Tema: Inversion de depencias con conexion a sql
	 */
	public static void main(String[] args) throws SQLException {

		//Primero creamos el alumno
		
		Alumn person1 = new Alumn(4, "Juan", "Sanchez", 15);
		
        //Metodo para crear la tabla
		// person1.createTable(Conexion.getConnection());
		
		//Creamos un alumno en la db
		//person1.create(Conexion.getConnection(), person1);
		
		// person1.update(Conexion.getConnection(),person2, person2.getId());
		// person1.delete(Conexion.getConnection(), 1);
		// person1.read(Conexion.getConnection(), person1,1);

		// Segundo creamos el profesor
	     Professor professor1 = new Professor(0, "Luis", "Ruiz", 35);
		
		//Metodo para crear la tabla
	     professor1.createTable(Conexion.getConnection());
		
		//Creamos un profesor en la db
		//p1.create(Conexion.getConnection(), p1);

		// Tercero creamos una materia
		Subjects subjects = new Subjects(12, "Lengua", "materia de lengua y literatura", 18);
		
		//Metodo para crear la tabla
		 //subjects.createTable(Conexion.getConnection());
		
		//Creamos una materia en la db
		//subject.create(Conexion.getConnection(), subject);
		
		//Por ultimo creamos los horarios
		Schedules sche = new Schedules(subjects.getId(), person1.getId(), professor1.getId(), "9", "11", "Lunes");
		sche.createTable(Conexion.getConnection());
		//sche.create(Conexion.getConnection(), sche);

	}

	
}
