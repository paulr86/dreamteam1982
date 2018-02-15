import java.util.*;

public class Menu { // Autor: Pablo Romero Ruiz

	public static void mostrarMenu() { 		// Autor: Pablo Romero Ruiz
		

		System.out.println("GESTION DE ALUMNOS. Menu:" + "\n1- Dar de alta alumnos" + "\n2- Dar de baja alumnos"
				+ "\n3- Listar los alumnos" + "\n4- Modificar alumnos" + "\n5- Matricular alumnos"
				+ "\n6- Dar de baja de una asignatura" + "\n7- Introducir calficación trimestral"
				+ "\n8- Listar calificaciones de alumnos" + "\n9- Poner una falta (día completo)"
				+ "\n10- Poner una falta (en una sesión)" + "\n11- Pasar lista" + "\n12- Listar faltas"
				+ "\n13- Salir");
	}
	
	public static boolean repetirOpcion() {		// Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner (System.in);
		boolean repetir = false;
		char opc; 
		
		
		System.out.println("¿Quieres repetir la operación? Y/N:");
		opc = Character.toUpperCase(entrada.next().charAt(0));
		//	Método estático para pasar un carácter a mayúsculas, ya que
		//	el usuario va a introducir o mayúsculas o minúsculas.
		if(opc == 'Y'){
			repetir = true;
		}
		
		return repetir;
		
	}
	
	public static int buscarAlumno(ArrayList<Alumno> lista, String dni){
		int posicion = -1;
		boolean terminado = false;
//		Iterator <Alumno> iterador = lista.iterator(); 

//		while(iterador.hasNext()){
//			System.out.println(iterador.next().getDni());
//		}
		
		for(int i = 0; i<lista.size() && !terminado; i++){
			if(lista.get(i).getDni().equals(dni)){
				posicion = i;
			}
		}
		
		return posicion;
	}
	
	public static boolean darAlta(ArrayList<Alumno> lista) {		// Autor: Pablo Romero Ruiz
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
		
		dni = dni.trim();
		
		Alumno alumno = new Alumno(dni, nombre, apellidos);
		
		if(!existeAlumno(alumno, lista)){
			lista.add(alumno);
			resultado = true;
		}
		
		return resultado;
	}
	
	public static boolean darBaja(ArrayList<Alumno> lista){
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;
		String dni;
		
		
		System.out.println("Introduce el DNI del alumno a eliminar:");
		dni = entrada.next();
		
		if(buscarAlumno(lista,dni) != -1){
			lista.remove(buscarAlumno(lista,dni));
			resultado = true;
		}
		
		return resultado;
	}
	
	public static boolean existeAlumno(Alumno alumno, ArrayList<Alumno> lista) {// Autor: Pablo Romero Ruiz
		Iterator <Alumno> iterador = lista.iterator();
		boolean existe = false;
		
		while(iterador.hasNext() && !existe){
			if(alumno.getDni() == iterador.next().getDni()){
				existe = true;
			}
		}
		
		return existe;
	}
	
	
	
	public static boolean hayAlumnos(ArrayList<Alumno> lista) {//Autor Antonio MEgias
		boolean hay = false;
		if(lista.size()!=0) {
			hay = true;
		}else {
			hay = false;
		}
		return hay;
	}
	
	public static void listarAlumnos(ArrayList<Alumno>lista) {
		Iterator <Alumno> listador = lista.iterator();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		int opcion;

		do {
			mostrarMenu();
			opcion = entrada.nextInt();
			
			entrada.nextLine(); //LIMPIANDO BUFFER
			
			switch (opcion) {
			case 1:// Autor: Pablo Romero Ruiz
				do{
					if(darAlta(alumnos)){
						System.out.println("Alumno introducido correctamente.");
					}else{
						System.out.println("No se ha introducido correctamente.");
					}
				}while(repetirOpcion());
				break;
			case 2:// Autor: Pablo Romero Ruiz
				do{
					if(darBaja(alumnos)){
						System.out.println("Alumno eliminado correctamente.");
					}else{
						System.out.println("Error al eliminar alumno");
					}
					
				}while(repetirOpcion());
				break;
			case 3:
				if(Menu.hayAlumnos(alumnos)== true) {
					System.out.println("Existen alumnos");
					
				}else {
					System.out.println("No hay alumnos");
				}
				//NO REPETIR //AUTOR ANTONIO MEGIAS
		
				break;
			case 4://AUTOR ANTONIO MEGIAS
				do{
					
					
				}while(repetirOpcion());
				break;
				
			case 5:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 6:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 7:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 8:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 9:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 10:
				do{
					
					
				}while(repetirOpcion());
				break;
			case 11:
				//NO REPETIR
				break;
			case 12:
				do{
					
					
				}while(repetirOpcion());
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
