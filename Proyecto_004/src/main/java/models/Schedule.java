package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
 
	@Id
	private int id_materia;
	@Id
	private int id_alumno;
	@Id
	private int id_profesor;
	@Column(name="hora_inicio")
	private int hora_inicio;
	@Column(name="hora_fin")
	private int hora_fin;
	@Column(name="dia")
	private String dia;
	
	public Schedule() {
		
	}

	public Schedule(int id_materia, int id_alumno, int id_profesor, int hora_inicio, int hora_fin, String dia) {
		super();
		this.id_materia = id_materia;
		this.id_alumno = id_alumno;
		this.id_profesor = id_profesor;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.dia = dia;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public int getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public int getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(int hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
}
