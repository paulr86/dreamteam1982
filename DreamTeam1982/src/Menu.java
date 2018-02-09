import java.util.*;

public class Menu { // Autor: Pablo Romero Ruiz

	public static void MostrarMenu() {
		

		System.out.println("GESTION DE ALUMNOS. Menu:" + "\n1- Dar de alta alumnos" + "\n2- Dar de baja alumnos"
				+ "\n3- Listar los alumnos" + "\n4- Modificar alumnos" + "\n5- Matricular alumnos"
				+ "\n6- Dar de baja de una asignatura" + "\n7- Introducir calficación trimestral"
				+ "\n8- Listar calificaciones de alumnos" + "\n9- Poner una falta (día completo)"
				+ "\n10- Poner una falta (en una sesión)" + "\n11- Pasar lista" + "\n12- Listar faltas"
				+ "\n13- Salir");
	}
	
	public static boolean RepetirOpcion() {
		Scanner entrada = new Scanner (System.in);
		boolean repetir = false;
		
		System.out.println("¿Quieres repetir la operación? Y/N:");
		if(entrada.next().charAt(0) == 'Y'){
			repetir = true;
		}
		
		return repetir;
		
	}
	
	public static void DarAlta(ArrayList<Alumno> lista) {
		Scanner entrada = new Scanner(System.in);
		
		Alumno alumno = new Alumno();
		
		System.out.println("Introduce el nombre del alumno:");
//		alumno.setNombre(entrada.next());
		
		System.out.println("Introduce los apellidos:");
//		alumno.setApellidos(entrada.next());
		
		System.out.println("Introduce el dni:");
//		alumno.setDni(entrada.next());
		
		if(!ExisteAlumno(alumno, lista)){
			lista.add(alumno);
		}
	}
	
	public static boolean ExisteAlumno(Alumno alumno, ArrayList<Alumno> lista) {
		Iterator <Alumno> iterador = lista.iterator();
		boolean existe = false;
		
//		Clase alumno. Pablo
		
//		while(iterador.hasNext() && !existe){
//			if(alumno.getDni() == iterador.next().getDni()){
//				existe = true;
//			}
//		}
		
		return existe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int opcion;

		do {
			MostrarMenu();
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 2:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 3:
				//NO REPETIR
				break;
			case 4:
				do{
					
					
				}while(RepetirOpcion());
				break;
				
			case 5:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 6:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 7:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 8:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 9:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 10:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 11:
				//NO REPETIR
				break;
			case 12:
				do{
					
					
				}while(RepetirOpcion());
				break;
			case 13:
				//NO REPETIR
				System.out.println("¡Adios!");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion < 13);

	}

}
