
import java.util.*;

//RUBEN TIJERAS

public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private ArrayList<DiaClase> faltas;
	private ArrayList<Calificacion> notas;

	// Constructores

	public Alumno(String dni) { // Coge como argumento el DNI, crea un ArrayList tipo DiaClase y Calificacion
		this.dni = dni;
		this.faltas = new ArrayList<DiaClase>();
		this.notas = new ArrayList<Calificacion>();
	}

	public Alumno(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.faltas = new ArrayList<DiaClase>();
		this.notas = new ArrayList<Calificacion>();

	}

	//// GETTER SETTER ////

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {

		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<DiaClase> getFaltas() {
		return faltas;
	}

	public ArrayList<Calificacion> getNotas() {
		return notas;
	}
	
	public void ponerNotas(String calificacion, String asignatura) {
		// Compruebo si existe una calificacion sobre esa asignatura
		//Recorro todas las calificaciones
		Boolean notaPuesta = false;
		
		// comprobamos si en asignatura existe calificación
		
		for(Calificacion calificacion2 : this.getNotas()) {
			if(calificacion2.getAsignatura().equals(asignatura)) {
				calificacion2.setNota(calificacion);
				notaPuesta = true;
			}
		}
		
		if(!notaPuesta) { 
			Calificacion calif = new Calificacion(asignatura); //Creamos un objeto calificacion para introducir sus notas
			calif.setNota(calificacion);	//Establecemos la nota
			this.notas.add(calif);	//Añadimos la calificacion
		}
	}

	public boolean equals(Object object) {
		boolean igual = false;

		if (object instanceof Alumno) {
			Alumno alumno = (Alumno) object;
			if (alumno.getDni().equalsIgnoreCase(this.getDni()))
				igual = true;
		}

		return igual;
	}

}
