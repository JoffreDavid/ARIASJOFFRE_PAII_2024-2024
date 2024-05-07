package model_package;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOSubjects {

	public void create(Connection connection, Subjects subjects) throws SQLException;
	public Subjects read(Connection connection, Subjects subjects, int id_subjects) throws SQLException;

	public void update(Connection connection,  Subjects subjects, int id_subjects)throws SQLException;

	public void delete(Connection connection, int id_subjects)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;
}
