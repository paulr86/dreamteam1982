
public class Alumno {

	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private ArrayList <DiaClase> faltas = new ArrayList <DiaClase>();
	private ArrayList <Calificacion> notas = new ArrayList <Calificacion>();
	
	//Constructores
	
	public Alumno (String dni) {
		this.dni = dni;
		this.faltas = new Diaclase();
		this.notas = Calificacion.getAsignatura()+" "+Calificacion.getNota();
	}
	
}
