
public class Calificacion {
	
	//ATRIBUTOS
	private String asignatura;
	private String nota;
	
	

	//CONSTRUCTOR
	public Calificacion(String asignatura) {
		this.asignatura=asignatura;
	}
	
	
	//METODOS
	
	//get
	
	public String getAsignatura() {
		return asignatura;
	}
	public String getNota() {
		return nota;
	}
	
	//set
	
	public void setAsignatura(String asignatura) {
		this.asignatura=asignatura;
	}
	
	public void setNota(String nota) {
		this.nota=nota;
	}
	
	
	//equal
	
	public boolean equals(Object object) {
		boolean igual = false;
		
		if (object instanceof Calificacion) {
			  Calificacion calificacion = (Calificacion) object;
			  
	if(calificacion.getAsignatura().equalsIgnoreCase(this.getAsignatura()))
					
					igual = true;
		}
		return igual;
		
	}
	
}
