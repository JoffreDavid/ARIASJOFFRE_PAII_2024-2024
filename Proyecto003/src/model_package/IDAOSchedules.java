package model_package;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAOSchedules {

	public void create(Connection connection, Schedules schedules) throws SQLException;

	public Schedules read(Connection connection, Schedules schedules, int id_schedule) throws SQLException;

	public void update(Connection connection,  Schedules schedules, int id_schedule)throws SQLException;

	public void delete(Connection connection, int id_schedules)throws SQLException;
	
	public void createTable(Connection connection) throws SQLException;

}
