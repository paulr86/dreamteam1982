import java.util.*;

public class Menu { // Autor: Pablo Romero Ruiz

	public static void mostrarMenu() { // Autor: Pablo Romero Ruiz

		System.out.println("GESTION DE ALUMNOS. Menu:" + "\n1- Dar de alta alumnos" + "\n2- Dar de baja alumnos"
				+ "\n3- Listar los alumnos" + "\n4- Modificar alumnos" + "\n5- Matricular alumnos"
				+ "\n6- Dar de baja de una asignatura" + "\n7- Introducir calficación trimestral"
				+ "\n8- Listar calificaciones de alumnos" + "\n9- Poner una falta (día completo)"
				+ "\n10- Poner una falta (en una sesión)" + "\n11- Pasar lista" + "\n12- Listar faltas"
				+ "\n13- Salir");
	}
	
	// Repite laopcion del menu
	public static boolean repetirOpcion() { // Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner(System.in);
		boolean repetir = false;
		char opc;

		System.out.println("¿Quieres repetir la operación? Y/N:");
		opc = Character.toUpperCase(entrada.next().charAt(0));
		// Método estático para pasar un carácter a mayúsculas, ya que
		// el usuario va a introducir o mayúsculas o minúsculas.
		if (opc == 'Y') { //Si introduce una 'Y', pasa a true el boolean.
			repetir = true;
		}

		return repetir;
	}

	// Devuelve la posicion del alumno en el array (-1 no existe alumno)
	public static int buscarAlumno(ArrayList<Alumno> lista) { // Autor: Pablo Romero Ruiz

		Scanner entrada = new Scanner(System.in);
		int posicion = -1; //Usa -1 por defecto en caso de que no lo encuentre, que lo devuelva indicando que no lo ha encontrado.
		String dni;

		System.out.println("Introduce el dni del alumno:");	//Pide el dni del alumno, ya que es el atributo que distingue un alumno de otro.
		dni = entrada.next();

		dni = dni.trim(); // En caso de que el usuario haya metido espacios accidentales al final y al principio del dni.

		Alumno alumnoABuscar = new Alumno(dni); // Se crea un alumno temporal, que pasaremos a indexOf para obtener la posicion del alumno con ese dni en el AL.

		posicion = lista.indexOf(alumnoABuscar); // Se busca ese alumno y se obtiene su posicion.

		return posicion;// Devolvemos la variable con la posicion.
	}

	// Crea nuevo alumno en el Array List de Alumnos
	public static void darAlta(ArrayList<Alumno> lista) throws Exception { // Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner(System.in);

		String dni;
		String nombre;
		String apellidos;

		// Pedimos los datos para pasar al constructor de Alumno.
		
		System.out.println("Introduce el nombre del alumno:");
		nombre = entrada.nextLine();

		System.out.println("Introduce los apellidos:");
		apellidos = entrada.nextLine();

		System.out.println("Introduce el dni:");
		dni = entrada.nextLine();

		dni = dni.trim(); // Recortamos los espacios del principio y del final del dni que introducimos
							// por teclado.
		// Así evitamos que haya diferencias de caractéres por espacios.

		Alumno alumno = new Alumno(dni, nombre, apellidos); // Creamos el alumno.

		if (existeAlumno(alumno.getDni(), lista)) { // Comprobamos que no existe el alumno antes de introducirlo.
			throw new Exception("El alumno que vas a introducir ya existe.");
		}else{
			lista.add(alumno);// Lo introducimos en el arraylist.
		}

	}

	// Elimina alumno del Array List de Alumnos
	public static void darBaja(ArrayList<Alumno> lista) throws Exception {// Autor: Pablo Romero Ruiz
		Scanner entrada = new Scanner(System.in);
		String dni;

		// Metodo para dar baja a un alumno.

		// Pedimos el dni a traves de teclado en vez de argumento del metodo, para
		// evitar codigo en el case.

		int posicion = buscarAlumno(lista); // Pedimos el dni y buscamos el alumno

		if (posicion == -1) { //Si no existe el alumno
			throw new Exception("No se ha encontrado el alumno."); //Tiramos una excepcion.
		} else { //Si existe
			lista.remove(buscarAlumno(lista)); //Lo borramos del AL.
		}

	}

	// Devuelve TRUE si existe el alumno en el Array List y FALSE si no existe
	public static boolean existeAlumno(String dni, ArrayList<Alumno> lista) {// Autor: Pablo Romero Ruiz
		boolean existe = false;

		for (int i = 0; i < lista.size() && !existe; i++) { // Recorre el ArrayList mientras que el alumno no se haya
															// encontrado.

			if (lista.get(i).getDni().equals(dni)) {// Si el dni del alumno que esta siendo recorrido es igual al dni
													// que le hemos pasado
				existe = true; // Se deposita en una variable boolean.
			}
		}

		return existe;// Se devuelve la variable boolean.
	}

	// Lista todos los Alumnos del Array List
	public static void listarAlumnos(ArrayList<Alumno> lista) { // Autor: Antonio Megias

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("Alumno: " + lista.get(i).getNombre() + " " + lista.get(i).getApellidos());
		} // Bucle que muestra tyoda la informacion a la vez que recorre la lista

	}

	// Añade una calificacion a una Asignatura del alumno
	public static void introducirCalificacion(ArrayList<Alumno> lista) throws Exception { // Rubén Tijeras
		int posicion;
		String nota, asignatura;
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introducir la nota del alumno");
		nota = entrada.next(); // Pedimos nota
		entrada.nextLine(); // Limpiando buffer

		System.out.println("Introducir la asignatura de dicha nota");
		asignatura = entrada.next(); // Pedimos asignatura
		entrada.nextLine(); // Limpiando buffer

		posicion = buscarAlumno(lista); // Conseguimos la posicion con el metodo buscarAlumno

		// Creamos un tmpCalif para saber si el alumno ya esta matriculado y si es assi
		// devolvemos una excepcion
		Calificacion tmpCalif = new Calificacion(asignatura);
		if (lista.get(posicion).getNotas().indexOf(tmpCalif) == -1) {
			throw new Exception("El alumno no esta matriculado en esa asignatura");
		}

		lista.get(posicion).ponerNotas(nota, asignatura); // Sacamos el alumno y le ponemos la nota

		System.out.println("Alumno: " + lista.get(posicion).getNombre());
		System.out.println("Asignatura: " + asignatura);
		System.out.println("Calificación: " + nota);
		System.out.print("\n");
	}

	// Muestra todos los alumnos y pregunta si han faltado o no
	public static void pasarLista(ArrayList<Alumno> lista) throws Exception { // Rubén Tijeras
		Scanner entrada = new Scanner(System.in);

		if (lista.isEmpty() == true) {
			throw new Exception("Esta vacio");
		}

		System.out.println("Fecha:");
		System.out.println("  Día:");
		int dia = entrada.nextInt();
		System.out.println("  Mes:"); // Fijamos la fecha y comprobamos en el trycatch que sea correcta
		int mes = entrada.nextInt();
		System.out.println("  Año:");
		int agno = entrada.nextInt();

		System.out.println("¿Sesión?"); // Pedimos la sesion
		int sesion = entrada.nextInt();

		if (sesion < 1 || sesion > 7) {
			throw new Exception("Sesion incorrecta, valores entre 1 y 6"); // Filtramos la sesion para que sea correta																	
		}

		try {

			Fecha fecha = new Fecha(dia, mes, agno); // Creamos una nueva fecha
			System.out.println("A continuación se listaran los alumnos, responda con Y en caso de asistencia o con N en caso de ausencia");
			entrada.nextLine(); // Limpiamos el buffer

			for (int n = 0; n < lista.size(); n++) { // Bucle que saca toda la lista y en caso de respuesta afirmativa le coloca la falta
														
				// Creamos la falta sino existe
				crearFalta(lista, fecha, lista.get(n));

				// Creamos un tmp de Falta para buscar la posicion de la fecha en el ArrayList
				DiaClase tmpFalta = new DiaClase(fecha);

				// Sacamos la posición del AL de la fecha a la que queremos acceder
				int posicion = lista.get(n).getFaltas().indexOf(tmpFalta);

				// Mostramos el alumno a poner la falta
				System.out.println("Nombre: " + lista.get(n).getNombre() + " // Apellido: " + lista.get(n).getApellidos()
						+ " // DNI: " + lista.get(n).getDni());
				char respuesta = entrada.nextLine().charAt(0);

				if (respuesta == 'N' || respuesta == 'n') { // N minuscula
					lista.get(n).getFaltas().get(posicion).getSesiones().faltaHora(sesion);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// Pone falta de una sesion a un alumno
	public static void faltaSesion(ArrayList<Alumno> lista) throws Exception { // Rubén Tijeras
		Scanner entrada = new Scanner(System.in);

		// DNI DEL ALUMNO
		// System.out.println("DNI del alumno");
		// String dni = entrada.nextLine();

		int posicionAlumno = buscarAlumno(lista);

		// Si existe el alumno hará el proceso
		if (posicionAlumno != -1) {

			// Pedimos fecha y sesion comprobamos en el trycatch que sea correcta
			System.out.println("Fecha:");
			System.out.println("  Día:");
			int dia = entrada.nextInt();
			System.out.println("  Mes:");
			int mes = entrada.nextInt();
			System.out.println("  Año:");
			int agno = entrada.nextInt();
			System.out.println("¿SESION?");
			int sesion = entrada.nextInt();

			// Si la sesion es incorrecta capturamos excepcion
			if (sesion < 1 || sesion > 7) {
				throw new Exception("Sesion incorrecta, valores entre 1 y 6");
			}

			try {
				// Creamos un objeto fecha y un tmp de alumno para pasar al metodo
				Fecha fecha = new Fecha(dia, mes, agno);
				Alumno tmpAlm = lista.get(posicionAlumno);

				// Creamos la falta sino existe
				crearFalta(lista, fecha, tmpAlm);

				// Creamos un tmp de Falta para buscar la posicion de la fecha en el ArrayList
				DiaClase tmpFalta = new DiaClase(fecha);

				// Sacamos la posición del AL de la fecha a la que queremos acceder
				int posicion = lista.get(posicionAlumno).getFaltas().indexOf(tmpFalta);

				// Colocamos las faltas del dia completo
				lista.get(posicionAlumno).getFaltas().get(posicion).getSesiones().faltaHora(sesion);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());

			}

		} else {

			System.out.println("No existe alumno"); // Si no existe alumno
		}
	}

	// Pone falta de un dia completo a un alumno
	public static void faltaDia(ArrayList<Alumno> lista) throws Exception { // ANtonio Megias
		Scanner entrada = new Scanner(System.in);

		// System.out.println("DNI del alumno"); //DNI DEL ALUMNO
		// String dni = entrada.nextLine();

		int posicionAlumno = buscarAlumno(lista);

		if (posicionAlumno == -1) { // Si existe el alumno hará el proceso
			throw new Exception("No existe alumno.");
		} else {
			System.out.println("Fecha:");
			System.out.println("  Día");
			int dia = entrada.nextInt();
			System.out.println("  Mes"); // Fijamos la fecha y comprobamos en el trycatch que sea correcta
			int mes = entrada.nextInt();
			System.out.println("  Año");
			int agno = entrada.nextInt();

			try {
				// Creamos un objeto fecha y un tmp de alumno para pasar al metodo
				Fecha fecha = new Fecha(dia, mes, agno);
				Alumno tmpAlm = lista.get(posicionAlumno);

				// Creamos la falta sino existe
				crearFalta(lista, fecha, tmpAlm);

				// Creamos un tmp de Falta para buscar la posicion de la fecha en el ArrayList
				DiaClase tmpFalta = new DiaClase(fecha);

				// Sacamos la posición del AL de la fecha a la que queremos acceder
				int posicion = lista.get(posicionAlumno).getFaltas().indexOf(tmpFalta);

				// Colocamos las faltas del dia completo
				lista.get(posicionAlumno).getFaltas().get(posicion).getSesiones().faltaDiaEntero();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	// Devulve true si se crea la falta y false sino se crea la falta
	
	// Comprueba si un alumno tiene un falta en su array de faltas y sino la tiene la añade al Array
	public static boolean crearFalta(ArrayList<Alumno> lista, Fecha fecha, Alumno alumno) throws Exception { // Autores: David y Pablo
																												
		Scanner entrada = new Scanner(System.in);
		boolean resultado = false;

		DiaClase faltaPasada = new DiaClase(fecha);

		// Buscamos posicion alumno
		int posAlum = lista.indexOf(alumno);

		// Sino existe alumno capturamos excepcion
		if (posAlum == -1) {
			throw new Exception("ERROR: El alumno no existe");
		}

		// Si no se localiza la falta devolvemos true y añadimos la falta al array
		if (lista.get(posAlum).getFaltas().indexOf(faltaPasada) == -1) {
			lista.get(posAlum).getFaltas().add(faltaPasada);
			resultado = true;
			// Si se localiza la falta devolvemos false
		} else {
			resultado = false;
		}

		return resultado;
	}

	// Modifica los datos de un Alumno
	public static void modificarAlumno(ArrayList<Alumno> lista) {// Autor Antonio Megias
		Scanner entrada = new Scanner(System.in);
		// String dni;
		int menu;
		// System.out.println("Introduce DNI del alumno a modificar: ");
		// dni = entrada.nextLine();

		int posicion = buscarAlumno(lista);

		// posicion = buscarAlumno(lista, dni); //indica posicion del alumno del que
		// posteriormente se va amodificar

		if (posicion != -1) { // Menú para elegir lo que quieres modificar y modificarlo.
			do {
				System.out.println("1 para Nombre" + "\n" + "2 para Apellidos" + "\n" + "3 para DNI" + "\n"
						+ "4 para Telefono" + "\n" + "5 para e-mail" + "\n" + "6 SALIR");
				menu = entrada.nextInt();
				switch (menu) {
				case 1:
					entrada.nextLine();
					System.out.println("Nuevo nombre: "); // Nombre
					lista.get(posicion).setNombre(entrada.nextLine());
					break;

				case 2:
					entrada.nextLine();
					System.out.println("Nuevo apellido: "); // Apellido
					lista.get(posicion).setApellidos(entrada.nextLine());
					break;

				case 3:
					entrada.nextLine();
					System.out.println("Nuevo DNI: "); // DNI
					lista.get(posicion).setDni(entrada.nextLine());
					break;

				case 4:
					entrada.nextLine();
					System.out.println("Nuevo Telefono: "); // TELEFONO
					lista.get(posicion).setTelefono(entrada.nextLine());
					break;

				case 5:
					entrada.nextLine();
					System.out.println("Nuevo E-mail: ");// Email
					lista.get(posicion).setEmail(entrada.nextLine());
					break;

				case 6:
					System.out.println("¡HASTA LA PRÓXIMA!");
					break;

				default:
					System.out.println("Opción no válida.");
				}
			} while (menu < 6);
		} else {
			System.out.println("Alumno inexsistente");
		}
	}

	// Matricula a un alumno de una asignatura 
	public static boolean matricularAlumnos(ArrayList<Alumno> lista, Alumno alumno, String nomAsignatura) throws Exception { // Autor: David guindo

		// Creamos una asignatura con el nombre introducido por el usuario
		Calificacion asignatura = new Calificacion(nomAsignatura);
		boolean matriculado = false;

		// Localizamos al alumno
		int posicion = lista.indexOf(alumno);

		// Creamos un tmpCalif para saber si el alumno ya esta matriculado y si es assi
		// devolvemos una excepcion
		Calificacion tmpCalif = new Calificacion(nomAsignatura);
		if (lista.get(posicion).getNotas().indexOf(tmpCalif) != -1) {
			throw new Exception("El alumno ya esta matriculado de esa asignatura");
		}

		// Si el alumno no existe (-1) devolvemos error
		if (posicion == -1) {
			throw new Exception("ERROR: El alumno intorducido no ha sido dado de alta");
		}

		// Si existe lo damos de alta en la asignatura que nos introdujo el usuario y
		// devolvemos true
		lista.get(posicion).ponerNotas("NE", nomAsignatura);
		matriculado = true;

		// Devolvemos el estado de matricula
		return matriculado;
	}

	// Lista el Array List de faltas de un alumno
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

		// Mostramos un indice para que se vean bonitas las faltas
		System.out.println("FECHA:			1/2/3/4/5/6");

		// Mostramos los Dias que tiene el alumno registrados hasta que no haya m�s
		for (int contFaltas = 0; contFaltas < lista.get(posicion).getFaltas().size(); contFaltas++) {
			lista.get(posicion).getFaltas().get(contFaltas).getDia().imprimeFecha();

			System.out.print("		" + lista.get(posicion).getFaltas().get(contFaltas).getSesiones().imprimeHorario());

			System.out.print("\n");
		}
	}

	// Da de baja a un alumno de una asignatura
	public static void darBajaAsignatura(ArrayList<Alumno> lista) throws Exception { // Autor: Ã�lvaro Moya Pino
		Scanner entrada = new Scanner(System.in);
		// System.out.println("Introduce el DNI del alumno a dar de baja de la
		// asignatura:");
		// String dni = entrada.next();
		// dni = dni.trim();

		int indiceAlumno = buscarAlumno(lista);

		if (indiceAlumno == -1) {
			throw new Exception("Alumno no encontrado.");
		} else {
			// int indiceAlumno = buscarAlumno(lista,dni);
			Alumno alumnoEncontrado = lista.get(indiceAlumno);

			System.out.println("Alumno encontrado, ahora escriba la asignatura de la que quiere darse de baja: ");
			String asignaturaIntroducida = entrada.nextLine();

			int indiceAsignatura = alumnoTieneAsignatura(alumnoEncontrado, asignaturaIntroducida);
			if (indiceAsignatura != -1) {
				// Ahora borramos la asignatura de sus calificaciones
				alumnoEncontrado.getNotas().remove(indiceAsignatura);
				System.out.println(
						"Alumno " + alumnoEncontrado.getNombre() + ", se ha dado de baja de " + asignaturaIntroducida);
			} else {
				System.out.println("El alumno introducido no cursa esa asignatura introducida");
				darBajaAsignatura(lista);
			}
		}
		// }else {
		// System.out.println("Alumno no encontrado, por favor, escriba un dni vÃ¡lido:
		// ");
		// darBajaAsignatura(lista);
		// }
	}

	// Comprueba si un alumno esta matriculado de una asignatura
	public static int alumnoTieneAsignatura(Alumno alumno, String asignatura) { // Autor: Ã�lvaro Moya Pino
		ArrayList<Calificacion> calificaciones = alumno.getNotas();
		for (Calificacion calificacion : calificaciones) {
			if (calificacion.getAsignatura().equals(asignatura)) {
				return calificaciones.indexOf(calificacion);
			}
		}
		return -1;
	}

	// Muestra todas las asignaturas y calificaciones de un alumno
	public static String listarCalificacionesDeAlumno(ArrayList<Alumno> lista) throws Exception { // Autor: Ã�lvaro Moya
																									// Pino
		Scanner entrada = new Scanner(System.in);
		// System.out.println("Introduce el DNI del alumno del que desea consultar las
		// calificaciones:");
		// String dni = entrada.next();
		// dni = dni.trim();

		int indiceAlumno = buscarAlumno(lista);

		System.out.println("listar asignaturas");
		if (indiceAlumno == -1) {
			throw new Exception("Alumno no encontrado.");
		} else {
			// int indiceAlumno = buscarAlumno(lista,dni);
			Alumno alumnoEncontrado = lista.get(indiceAlumno);
			String listeDeCalificaciones = "El alumno " + alumnoEncontrado.getNombre()
					+ " tiene las siguientes calificaciones ";
			for (Calificacion calificacion : alumnoEncontrado.getNotas()) {
				System.out.println(calificacion.getAsignatura() + ", tiene una nota de " + calificacion.getNota());
			}
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

			entrada.nextLine(); // LIMPIANDO BUFFER

			switch (opcion) {
			case 1:// Autor: Pablo Romero Ruiz
				do {
					try{
						darAlta(alumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetirOpcion());
				break;
			case 2:// Autor: Pablo Romero Ruiz
				do {
					try {
						darBaja(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetirOpcion());
				break;
			case 3:
				if (alumnos.isEmpty() != true) {
					listarAlumnos(alumnos);
				} else {
					System.out.println("No hay alumnos");
				}
				// NO REPETIR //AUTOR ANTONIO MEGIAS

				break;
			case 4:// AUTOR ANTONIO MEGIAS
				do {

					modificarAlumno(alumnos);

				} while (repetirOpcion());
				break;

			case 5:
				do {

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

					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				} while (repetirOpcion());
				break;

			case 6:
				do {
					try {
						darBajaAsignatura(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetirOpcion());
				break;
			case 7: // Rubén Tijeras
				do {

					try {
						introducirCalificacion(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				} while (repetirOpcion());
				break;
			case 8:
				do {
					try {
						listarCalificacionesDeAlumno(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetirOpcion());
				break;
			case 9:
				do {

					try {
						faltaDia(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				} while (repetirOpcion());
				break;
			case 10:
				do {
					try {
						faltaSesion(alumnos);
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				} while (repetirOpcion());
				break;
			case 11: // Rubén Tijeras

				try {
					pasarLista(alumnos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

				// NO REPETIR
				break;
			case 12: // Autor: David Guindo
				do {

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

				} while (repetirOpcion());
				break;
			case 13:
				// NO REPETIR
				System.out.println("¡Adios!");
				break;
			default:
				System.out.println("\nOpción no válida.\n");
				break;
			}
		} while (opcion != 13);

	}

}
