package model_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Subjects implements IDAOSubjects{
	
	private int id;
	private String name;
	private String description;
	private int level;
	
	private PreparedStatement ps;
	private String table = "Subject";
	
	public Subjects(int id, String name, String description, int level) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
	}
	
	@Override
	public void create(Connection connection, Subjects subjects) throws SQLException {
		ps = connection.prepareStatement("INSERT INTO " + table + " (id, name, description, level) VALUES (?,?,?,?)");
		ps.setInt(1, subjects.getId());
		ps.setString(2, subjects.getName());
		ps.setString(3, subjects.getDescription());
		ps.setInt(4, subjects.getLevel());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Subjects read(Connection connection, Subjects subjects, int id_subjects) throws SQLException {
		ResultSet resultados = null;
		String sql = null;
		subjects = new Subjects(0, "", "", 0);

		ps = connection.prepareStatement("SELECT * FROM \" + table + \" WHERE id = ?");
		ps.setInt(1, id_subjects);
		resultados = ps.executeQuery();

		if (resultados.next()) {
			subjects.setId(resultados.getInt(1));
			subjects.setName(resultados.getString(2));
			subjects.setDescription(resultados.getString(3));
			subjects.setLevel(resultados.getInt(4));

			System.out.println(subjects.toString());
		}

		ps.close();
		return subjects;
	}

	@Override
	public void update(Connection connection, Subjects subjects, int id_subjects) throws SQLException {
		ps = connection.prepareStatement("UPDATE " + table + " SET name=?, lastname=?, age=? WHERE id=?");
		ps.setString(1, subjects.getName());
		ps.setString(2, subjects.getDescription());
		ps.setInt(3, subjects.getLevel());
		ps.setInt(4, id_subjects);
		ps.execute();
		ps.close();

		
	}

	@Override
	public void delete(Connection connection, int id_subjects) throws SQLException {
		ps = connection.prepareStatement("DELETE FROM " + table + " WHERE id=?");
		ps.setInt(1, id_subjects);
		ps.execute();
		ps.close();
		
	}

	@Override
	public void createTable(Connection connection) throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS " + table + " ( " + "id INT PRIMARY KEY," + "name VARCHAR(35),"
				+ "description VARCHAR(150)," + "level INT" + ")";
		connection.createStatement().executeUpdate(query);
		System.out.println("Tabla creada o ya existente.");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	

}
