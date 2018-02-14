import java.util.*;

public class Menu { // Autor: Pablo Romero Ruiz

	public static void MostrarMenu() { 		// Autor: Pablo Romero Ruiz
		

		System.out.println("GESTION DE ALUMNOS. Menu:" + "\n1- Dar de alta alumnos" + "\n2- Dar de baja alumnos"
				+ "\n3- Listar los alumnos" + "\n4- Modificar alumnos" + "\n5- Matricular alumnos"
				+ "\n6- Dar de baja de una asignatura" + "\n7- Introducir calficaci�n trimestral"
				+ "\n8- Listar calificaciones de alumnos" + "\n9- Poner una falta (d�a completo)"
				+ "\n10- Poner una falta (en una sesi�n)" + "\n11- Pasar lista" + "\n12- Listar faltas"
				+ "\n13- Salir");
	}
	
	public static boolean RepetirOpcion() {		// Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner (System.in);
		boolean repetir = false;
		char opc; 
		
		
		System.out.println("�Quieres repetir la operaci�n? Y/N:");
		opc = Character.toUpperCase(entrada.next().charAt(0));
		//	M�todo est�tico para pasar un car�cter a may�sculas, ya que
		//	el usuario va a introducir o may�sculas o min�sculas.
		if(opc == 'Y'){
			repetir = true;
		}
		
		return repetir;
		
	}
	
	public static int BuscarAlumno(ArrayList<Alumno> lista, String dni){
		int posicion;
		
		posicion = lista.indexOf(dni);
		
		return posicion;
	}
	
	public static boolean DarAlta(ArrayList<Alumno> lista) {		// Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner(System.in);
		
		boolean resultado = false;
		String dni;
		String nombre;
		String apellidos;
		
		System.out.println("Introduce el nombre del alumno:");
		nombre = entrada.nextLine();
		
		System.out.println("Introduce los apellidos:");
		apellidos = entrada.nextLine();
		
		System.out.println("Introduce el dni:");
		dni = entrada.nextLine();
		
		Alumno alumno = new Alumno(dni, nombre, apellidos);
		
		if(!ExisteAlumno(alumno, lista)){
			lista.add(alumno);
			resultado = true;
		}
		
		return resultado;
	}
	
	public static boolean DarBaja(ArrayList<Alumno> lista){
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;
		String dni;
		
		
		System.out.println("Introduce el DNI del alumno a eliminar:");
		dni = entrada.next();
		
		if(lista.remove(BuscarAlumno(lista,dni)) == lista.get(BuscarAlumno(lista, dni))){
			//		Condici�n del if: la funci�n remove de java devuelve aquello que elimina si
			//		lo ha eliminado correctamente. As� que para comprobar si se ha eliminado el alumno
			//		comparamos el metodo con el alumno a borrar (objeto alumno, no acepta otra cosa).
			resultado = true;
		}
		
		
		return resultado;
	}
	
	public static boolean ExisteAlumno(Alumno alumno, ArrayList<Alumno> lista) {// Autor: Pablo Romero Ruiz
		Iterator <Alumno> iterador = lista.iterator();
		boolean existe = false;
		
		while(iterador.hasNext() && !existe){
			if(alumno.getDni() == iterador.next().getDni()){
				existe = true;
			}
		}
		
		return existe;
	}
	
	
	
	public static boolean HayAlumnos(ArrayList<Alumno> lista) {//Autor Antonio MEgias
		boolean hay = false;
		if(lista.size()!=0) {
			hay = true;
		}else {
			hay = false;
		}
		return hay;
	}
	
	public static void ListarAlumnos(ArrayList<Alumno>lista) {
		Iterator <Alumno> listador = lista.iterator();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int opcion;

		do {
			MostrarMenu();
			opcion = entrada.nextInt();
			
			entrada.nextLine(); //LIMPIANDO BUFFER
			
			switch (opcion) {
			case 1:// Autor: Pablo Romero Ruiz
				do{
					if(DarAlta(alumnos)){
						System.out.println("Alumno introducido correctamente.");
					}else{
						System.out.println("No se ha introducido correctamente.");
					}
				}while(RepetirOpcion());
				break;
			case 2:// Autor: Pablo Romero Ruiz
				do{
					if(DarBaja(alumnos)){
						System.out.println("Alumno eliminado correctamente.");
					}else{
						System.out.println("Error al eliminar alumno");
					}
					
				}while(RepetirOpcion());
				break;
			case 3:
				if(Menu.HayAlumnos(alumnos)== true) {
					System.out.println("Existen alumnos");
					
				}else {
					System.out.println("No hay alumnos");
				}
				//NO REPETIR //AUTOR ANTONIO MEGIAS
		
				break;
			case 4://AUTOR ANTONIO MEGIAS
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
				System.out.println("�Adios!");
				break;
			default:
				System.out.println("Opci�n no v�lida.");
			}
		} while (opcion < 13);

	}

}
