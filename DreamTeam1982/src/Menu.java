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
		
		if(!existeAlumno(alumno.getDni(), lista)){ //Comprobamos que no existe el alumno antes de introducirlo.
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
	
	public static boolean existeAlumno(String dni, ArrayList<Alumno> lista) {// Autor: Pablo Romero Ruiz
		boolean existe = false;
		
		for(int i=0; i<lista.size() && !existe; i++){ //Recorre el ArrayList mientras que el alumno no se haya encontrado.
			
			if(lista.get(i).getDni().equals(dni)){// Si el dni del alumno que esta siendo recorrido es igual al dni que le hemos pasado
				existe = true; // Se deposita en una variable boolean.
			}
		}
		
		return existe;// Se devuelve la variable boolean.
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
		}//Bucle que muestra tyoda la informacion a la vez que recorre la lista
		
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
	

	public static void pasarLista(ArrayList<Alumno>lista ) throws Exception { 		//Rubén Tijeras
		Scanner entrada = new Scanner (System.in);
		
		

		if(hayAlumnos( lista) == true) {
			System.out.println("Fecha:");
			System.out.println("Día");
			int dia = entrada.nextInt();
			System.out.println("Número de mes");			//Fijamos la fecha y comprobamos en el trycatch que sea correcta
			int mes = entrada.nextInt();
			System.out.println("Año");
			int agno = entrada.nextInt();
			
			
			
			System.out.println("¿De qué sesión quieres pasar lista?");		//Pedimos la sesion
			int sesion = entrada.nextInt();
			
			if(sesion <1 || sesion > 7) {
				throw new Exception("Sesion incorrecta, valores entre 1 y 6");
			}
			
			
			try {
			Fecha fecha = new Fecha(dia, mes, agno);
			
			System.out.println("A continuación se listaran los alumnos, responda con Y en caso de asistencia o con N en caso de ausencia");
			
			

			entrada.nextLine();
		
		for(int n = 0; n < lista.size(); n++) {		//Bucle que saca toda la lista y en caso de respuesta afirmativa le coloca la falta
						
			
			
			System.out.println("Nombre: "+lista.get(n).getNombre() +". Apellidos: "+ lista.get(n).getApellidos());
			String respuesta = entrada.nextLine();
			
			if(respuesta.equals('n')) {		//n Mayus
				System.out.println(lista.get(n).getFaltas().get(dia).getSesiones().faltaHora(sesion));
			}
			
			if(respuesta.equals('N')) {		//N minuscula
				System.out.println(lista.get(n).getFaltas().get(dia).getSesiones().faltaHora(sesion));

			}
		}
			} catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
	}
	
	public static void faltaSesion(ArrayList<Alumno>lista) throws Exception {	//Rubén Tijeras
		Scanner entrada = new Scanner (System.in);
		
		
		System.out.println("DNI del alumno");		//Pide el dni para localizar al alumno
		String dni = entrada.nextLine();

		if(existeAlumno(dni, lista) == true) {
			System.out.println("Fecha:");
			System.out.println("Día");
			int dia = entrada.nextInt();
			System.out.println("Número de mes");			//Fijamos la fecha y comprobamos en el trycatch que sea correcta
			int mes = entrada.nextInt();
			System.out.println("Año");
			int agno = entrada.nextInt();
			
			System.out.println("¿Qué sesion ha faltado?");		//Pedimos la sesion
			int sesion = entrada.nextInt();
			
			if(sesion <1 || sesion > 7) {
				throw new Exception("Sesion incorrecta, valores entre 1 y 6");
				}
			
			
			try {
			Fecha fecha = new Fecha(dia, mes, agno);
			
			int posicion = lista.get(buscarAlumno(lista,dni)).getFaltas().indexOf(fecha);		//Sacamos la posición del AL de la fecha a la que queremos acceder
			
			lista.get(buscarAlumno(lista,dni)).getFaltas().get(posicion).getSesiones().faltaHora(sesion);		//Colocamos las faltas de la sesion
			
			} catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}

		else {
			System.out.println("No existe alumno");
		}


	}


	public static void faltaDia (ArrayList<Alumno>lista) { //ANtonio Megias
		Scanner entrada = new Scanner (System.in);
		
		
		System.out.println("DNI del alumno");			//DNI DEL ALUMNO
		String dni = entrada.nextLine();

		if(existeAlumno(dni, lista) == true) {			//Si existe el alumno hará el proceso
		
		System.out.println("Fecha:");
		System.out.println("Día");
		int dia = entrada.nextInt();
		System.out.println("Número de mes");			//Fijamos la fecha y comprobamos en el trycatch que sea correcta
		int mes = entrada.nextInt();
		System.out.println("Año");
		int agno = entrada.nextInt();
		
		try {
		Fecha fecha = new Fecha(dia, mes, agno);
		
//		int posicion = lista.get(buscarAlumno(lista,dni)).getFaltas().indexOf(fecha);		
		//Sacamos la posición del AL de la fecha a la que queremos acceder
		
		int posicion = buscarAlumno(lista, dni);
		
		Alumno tmp = lista.get(posicion);
		
		ArrayList<DiaClase> hola = tmp.getFaltas();
		
		int pepe = hola.indexOf(fecha);
		
		System.out.println(">" + pepe);
		
		//System.out.println(">>" + hola.get(0).getDia().getDia());
		
		//lista.get(buscarAlumno(lista,dni)).getFaltas().get(pepe).getSesiones().faltaDiaEntero();		//Colocamos las faltas del dia completo
		
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		}
		
		else {
			System.out.println("No existe alumno");			//Si no existe alumno
		}



	}


	
	
	public static void modificarAlumno(ArrayList<Alumno>lista) {//Autor Antonio Megias 
		Scanner entrada = new Scanner ( System.in);
		String dni;
		int menu, posicion;
		System.out.println("Introduce DNI del alumno a modificar: ");
		dni = entrada.nextLine();
		
		posicion = buscarAlumno(lista, dni);  //indica posicion del alumno del que posteriormente se va amodificar
		
		if (Menu.existeAlumno(dni,lista)== true) {		//Menú para elegir lo que quieres modificar y modificarlo.
			do {System.out.println("1 para Nombre"+"\n"+"2 para Apellidos"+"\n"+"3 para DNI"+"\n"+"4 para Telefono"+"\n"+"5 para e-mail"+"\n"+"6 SALIR");
				menu=entrada.nextInt();
				switch(menu) {
				case 1:
					System.out.println("Nuevo nombre: ");		//Nombre
					lista.get(posicion).setNombre(entrada.nextLine());
					break;
					
				case 2:
					System.out.println("Nuevo apellido: ");		//Apellido
					lista.get(posicion).setApellidos(entrada.nextLine());
				    break;
				    
				    
				case 3:
					System.out.println("Nuevo DNI: "); //DNI
					lista.get(posicion).setDni(entrada.nextLine());
					break;
					
				case 4:
					System.out.println("Nuevo Telefono: "); //TELEFONO
					lista.get(posicion).setTelefono(entrada.nextLine());
					break;
					
				case 5:
					System.out.println("Nuevo E-mail: ");//Email
					lista.get(posicion).setEmail(entrada.nextLine());
					break;
					
				case 6:
					break;
				default:
					System.out.println("Opción no válida.");	
				}	
			}while(menu<6);
		}else {
			System.out.println("Alumno inexsistente");
		}
	}
	
	public static boolean matricularAlumnos(ArrayList<Alumno> lista, Alumno alumno, String nomAsignatura)  throws Exception { // Autor: David guindo
		
		// Creamos una asignatura con el nombre introducido por el usuario
		Calificacion asignatura = new Calificacion(nomAsignatura);
		boolean matriculado = false;
				
		// Localizamos al alumno
		int posicion = lista.indexOf(alumno);
		
		// Si el alumno no existe (-1) devolvemos error
		if (posicion == -1) {
			throw new Exception("ERROR: El alumno intorducido no ha sido dado de alta");
		}
		
		// Si existe lo damos de alta en la asignatura que nos introdujo el usuario y devolvemos true
		alumno.ponerNotas("NE", nomAsignatura);
		matriculado = true;
				
		 // Devolvemos el estado de matricula
		return matriculado;
	}
		
	public static void listarFaltas(ArrayList<Alumno> lista, Alumno alumno) throws Exception { // Autor: David Guindo

		// comprobamos posicion del alumno
		int posicion = lista.indexOf(alumno);


		// Capturamos excepciones
		if (posicion == -1) {
			throw new Exception("ERROR: El alumno introducido no existe");
		}

		if (lista.get(posicion).getFaltas().size() == 0) {
			throw new Exception("ERROR: El alumno no tiene faltas");
		}

		// Mostramos los Dias que tiene el alumno registrados hasta que no haya m�s
		for (int contFaltas = 0; contFaltas < alumno.getFaltas().size(); contFaltas++) {
			System.out.print(alumno.getFaltas().get(contFaltas).getDia().imprimeFecha() + ": ");

			// Mostramos las sesiones que ha faltado el alumno del d�a correspondiente
			for (int contSesion = 0; contSesion < alumno.getFaltas().get(contFaltas).getSesiones().GetSesiones().length;contSesion++)
					System.out.print(alumno.getFaltas().get(contFaltas).getSesiones().GetSesiones() + " /	");
			}
		}
	



	public static void darBajaAsignatura(ArrayList<Alumno>lista) { // Autor: Ã�lvaro Moya Pino
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el DNI del alumno a dar de baja de la asignatura:");
		String dni = entrada.next();
		dni = dni.trim();
		
		if(buscarAlumno(lista,dni) != -1){
			int indiceAlumno = buscarAlumno(lista,dni);
			Alumno alumnoEncontrado = lista.get(indiceAlumno);
			
			System.out.println("Alumno encontrado, ahora escriba la asignatura de la que quiere darse de baja: ");
			entrada.nextLine();
			String asignaturaIntroducida = entrada.nextLine();
			
			int indiceAsignatura = alumnoTieneAsignatura(alumnoEncontrado, asignaturaIntroducida);
			if(indiceAsignatura != -1) {
				//Ahora borramos la asignatura de sus calificaciones
				alumnoEncontrado.getNotas().remove(indiceAsignatura);
				System.out.println("Alumno "+ alumnoEncontrado.getNombre() + ", se ha dado de baja de " + asignaturaIntroducida);
			}else {
				System.out.println("El alumno introducido no cursa esa asignatura introducida");
				darBajaAsignatura(lista);
			}
		}else {
			System.out.println("Alumno no encontrado, por favor, escriba un dni vÃ¡lido: ");
			darBajaAsignatura(lista);
		}
	}
	
	public static int alumnoTieneAsignatura(Alumno alumno, String asignatura) { // Autor: Ã�lvaro Moya Pino
		ArrayList <Calificacion> calificaciones = alumno.getNotas();
		for(Calificacion calificacion:calificaciones) {
			if(calificacion.getAsignatura().equals(asignatura)) {
				return calificaciones.indexOf(calificacion);
			}
		}
		return -1;
	}
	
	public static String listarCalificacionesDeAlumno(ArrayList<Alumno>lista) { // Autor: Ã�lvaro Moya Pino
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el DNI del alumno del que desea consultar las calificaciones:");
		String dni = entrada.next();
		dni = dni.trim();
		System.out.println("listar asignaturas");
		if(buscarAlumno(lista,dni) != -1){
			int indiceAlumno = buscarAlumno(lista,dni);
			Alumno alumnoEncontrado = lista.get(indiceAlumno);
			String listeDeCalificaciones = "El alumno " + alumnoEncontrado.getNombre() + " tiene las siguientes calificaciones ";
			for(Calificacion calificacion: alumnoEncontrado.getNotas()) {
				System.out.println(calificacion.getAsignatura() + ", tiene una nota de " + calificacion.getNota());
			}
		}else {
			System.out.println("Alumno no encontrado, por favor, escriba un dni vÃ¡lido: ");
			listarCalificacionesDeAlumno(lista);
		}
		
		return "";
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
					
					modificarAlumno(alumnos);
					
				}while(repetirOpcion());
				break;
				
			case 5:
				do{

					// Declarcion de variable
					String dni = "";
					Alumno alumno = new Alumno("");
					String asignatura = "";
					
					// Pedimos DNI del alumno y se lo asignamos a un alumno para comprobar si existe
					System.out.println("Introduzca el DNI del alumno a matricular: ");
					dni = entrada.nextLine();
					alumno.setDni(dni);
					
					// Pedimos la asignatura para pasarla como parametro al método
					System.out.println("Introduzca la asignatura en la que matricular al alumno: ");
					asignatura = entrada.nextLine();
					
					// Si se captura algún error en el método lo muestra por pantalla
					try {
						Menu.matricularAlumnos(alumnos, alumno, asignatura); 
							System.out.println("El alumno ha sido matriculado correctamente");
						
					} catch (Exception ex){
						System.out.println(ex.getMessage());
					} 
											
					
				}while(repetirOpcion());
				break;
				
			case 6:
				do{
					darBajaAsignatura(alumnos);
					
				}while(repetirOpcion());
				break;
			case 7:	//Rubén Tijeras
				do{
					
					introducirCalificacion(alumnos);
					
				}while(repetirOpcion());
				break;
			case 8:
				do{
					
					listarCalificacionesDeAlumno(alumnos);
					
				}while(repetirOpcion());
				break;
			case 9:
				do{
					
					try {
						faltaDia(alumnos);
						} catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
					
				}while(repetirOpcion());
				break;
			case 10:
				do{
					try {
					faltaSesion(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					
				}while(repetirOpcion());
				break;
			case 11:	//Rubén Tijeras
				
				
				try {
					pasarLista(alumnos);
				} catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				
				//NO REPETIR
				break;
			case 12: // Autor: David Guindo
				do{
					
					// Declaramos un alumno tmp para pasar datos al m�todo
					Alumno tmp = new Alumno("");
					
					// Pedimos el alumno del que listar las faltas
					System.out.println("Introduzca el DNI del alumno del que listar las faltas:");
					tmp.setDni(entrada.nextLine());
					
					// Si se produce una excepci�n la mostramos
					try {
						Menu.listarFaltas(alumnos, tmp);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				}while(repetirOpcion());
				break;
			case 13:
				//NO REPETIR
				System.out.println("¡Adios!");
				break;
			default:
				System.out.println("\nOpción no válida.\n");
				break;
			}
		} while (opcion != 13);

	}

}
