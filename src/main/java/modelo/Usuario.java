package modelo;

import java.time.LocalDate;

public class Usuario {

	int id;

	String nombres, rut;

	LocalDate fechaNacimiento;

	public Usuario() {}

	public Usuario(String rut, String nombres, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.rut = rut;
	}
//______________Getter y Setter________________
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//_______________________________________________________
	@Override
	public String toString() {
		return "Usuario [nombres=" + nombres + ", rut=" + rut + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
