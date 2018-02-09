
import java.util.*;

public class DiaClase {
	
	// Autor: Alvaro Moya Pino
	
	// Atributos de la clase
	
	private Fecha dia;
	private ArrayList<Horario> sesiones;
	
	// Inicializa el día y crea la instancia de horario
	
	public DiaClase(Fecha dia) {
		this.dia = dia;
		this.sesiones = new ArrayList<Horario>();
	}
	
	// Getter y set de 'dia'
	
	public Fecha getDia() {
		return dia;
	}
	
//	public Horario getSesiones() {    HASTA QUE IGNACIO LO SUBA
//		return sesiones;
//	}
	
	public void setDia(Fecha dia) {
		this.dia = dia;
	}
	
	// Sobrecarga del metodo equals de la clase Object
	
	public boolean equals(Object object){
		boolean igual = false;
		if(object instanceof DiaClase){
			DiaClase diaClase = (DiaClase) object;
			if(diaClase.getDia().equals(this.getDia()))
				igual = true;
		}
		return igual;
	}
}
