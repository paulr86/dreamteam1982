import java.util.*;
public class Menu {

	public static void MostrarMenu(){
//		Scanner entrada = new Scanner(System.in);
		
		System.out.println("GESTION DE ALUMNOS. Menu:"
				+ "\n1- Dar de alta alumnos"
				+ "\n2- Dar de baja alumnos"
				+ "\n3- Listar los alumnos"
				+ "\n4- Modificar alumnos"
				+ "\n5- Matricular alumnos"
				+ "\n6- Dar de baja de una asignatura"
				+ "\n7- Introducir calficación trimestral"
				+ "\n8- Listar calificaciones de alumnos"
				+ "\n9- Poner una falta (día completo)"
				+ "\n10- Poner una falta (en una sesión)"
				+ "\n11- Pasar lista"
				+ "\n12- Listar faltas"
				+ "\n13- Salir");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int opcion;
		
		do{
			MostrarMenu();
			opcion = entrada.nextInt();
		}while(opcion < 13);
		
		
	}

}
