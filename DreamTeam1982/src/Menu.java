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
	
	public static int buscarAlumno(ArrayList<Alumno> lista, String dni){ //Autor: Pablo Romero Ruiz
		int posicion = -1;
		boolean terminado = false;
		//		Este programa busca un alumno en un arraylist. Pide un ArrayList en el que buscar y un dni para buscar
		//		al alumno. Devuelve la posicion en el ArrayList en la que se encuentra.
		for(int i = 0; i<lista.size() && !terminado; i++){ //		Bucle que recorre el array.
			if(lista.get(i).getDni().equals(dni)){//		Compara el dni del objeto alumno que va encontrando, con el dni
												//			que le pasamos.
				posicion = i;	//Deposita la posicion en la que los dos dni son iguales en una variable.
			}
		}
		
		return posicion;//		Devolvemos la variable con la posicion.
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
		
		dni = dni.trim(); //Recortamos los espacios del principio y del final del dni que introducimos por teclado.
		//					Así evitamos que haya diferencias de caractéres por espacios.
		
		Alumno alumno = new Alumno(dni, nombre, apellidos);
		
		if(!existeAlumno(alumno, lista)){ //Comprobamos que no existe el alumno antes de introducirlo.
			lista.add(alumno);//Lo introducimos en el arraylist.
			resultado = true;//Cambiamos la variable boolean para devolver que ha funcionado el metodo.
		}
		
		return resultado;// Devolvemos el boolean.
	}
	
	public static boolean darBaja(ArrayList<Alumno> lista){//Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;
		String dni;
		
		//Metodo para dar baja a un alumno.
		
		System.out.println("Introduce el DNI del alumno a eliminar:");
		dni = entrada.next();
		
		//Pedimos el dni a traves de teclado en vez de argumento del metodo, para evitar codigo en el case.
		
		dni = dni.trim();	//Controlamos los espacios al principio y al final del dni.
		
		if(buscarAlumno(lista,dni) != -1){ //Ya que buscarAlumno devuelve un -1 si no encuentra el alumno,
										//	lo usamos para cerciorarnos de que existe el alumno antes de borrarlo.
			lista.remove(buscarAlumno(lista,dni)); //Una vez encontrado, lo borramos.
			resultado = true; //Variable booleana para saber si ha funcionado el metodo.
		}
		
		return resultado;// Devolvemos el boolean para informar si ha funcionado o no.
	}
	
	public static boolean existeAlumno(Alumno alumno, ArrayList<Alumno> lista) {// Autor: Pablo Romero Ruiz
		Iterator <Alumno> iterador = lista.iterator(); //Iterador para recorrer el ArrayList.
		boolean existe = false; //Variable boolean para informar del funcionamiento del metodo.
		
		while(iterador.hasNext() && !existe){ //Mientras haya alumnos en el ArrayList, y no haya terminado la busqueda, va a seguir.
			if(alumno.getDni() == iterador.next().getDni()){ //Si coiniciden el dni del alumno que le hemos pasado, y el dni del ArrayList
				existe = true; //Pasa a verdadero el boolean
			}
		}
		
		return existe; //Y se devuelve.
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
	
	public static void listarAlumnos(ArrayList<Alumno>lista) { //Autor: Antonio Megias
		
		for(int i=0; i<lista.size(); i++) {
			System.out.println("Alumno: " + lista.get(i).getNombre() + " " + lista.get(i).getApellidos());
		}
		
	}
	
	public static void introducirCalificacion(ArrayList<Alumno>lista) {		//Rubén Tijeras
		int posicion;
		String dni, nota, asignatura;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introducir el dni del alumno que quiere calificar");
		dni = entrada.next();		//Pedimos dni
		entrada.nextLine(); 		//Limpiando buffer
		
		System.out.println("Introducir la nota del alumno");
		nota = entrada.next();		//Pedimos nota
		entrada.nextLine(); 		//Limpiando buffer
		
		System.out.println("Introducir la asignatura de dicha nota");
		asignatura = entrada.next();		//Pedimos asignatura
		entrada.nextLine(); 		//Limpiando buffer
		
		posicion = buscarAlumno(lista, dni);	//Conseguimos la posicion con el metodo buscarAlumno
		
		lista.get(posicion).ponerNotas(nota, asignatura);	//Sacamos el alumno y le ponemos la nota
		
		System.out.println(lista.get(posicion).getNotas());
		
		
	}
	
	public static void pasarLista(ArrayList<Alumno>lista) {		//Rubén Tijeras
		Scanner entrada = new Scanner ( System.in);
		String respuesta;
		
		System.out.println("¿De qué sesión va a pasar lista?");
		int sesion = entrada.nextInt();
		
		System.out.println("Introducir dia");
		int dia = entrada.nextInt();
		
		System.out.println("A continuación se listarán los alumnos registrados, responda con Y/N si han asistido a clase o no");
		
		for(int n = 0; n < lista.size()-1; n++) {
			
			System.out.println(lista.get(n).getNombre()+" "+lista.get(n).getApellidos());
			respuesta = entrada.nextLine();
			
			if(respuesta.equals("Y")) {
				lista.get(n).getFaltas().get(dia).getSesiones().get(sesion).faltaHora(sesion);
			}
			
		}
		
	}
	
	public static void modificarAlumnos(Alumno alumno,ArrayList<Alumno>lista) {
		Scanner entrada = new Scanner(System.in);
		String escaner;
//		System.out.println("Alumno a modificar: ");
//		escaner = entrada.nextLine();
		existeAlumno(alumno, lista);
		
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
				if(hayAlumnos(alumnos)== true) {
					listarAlumnos(alumnos);
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
			case 7:	//Rubén Tijeras
				do{
					
					introducirCalificacion(alumnos);
					
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
			case 11:	//Rubén Tijeras
				
				pasarLista(alumnos);
				
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
