
public class Horario {

	private char[] sesiones = new char[6];

	// Constructor por defeco
	public Horario() {
		for (int y = 0; y < 6; y++) {
			sesiones[y] = ' ';
		}
	}
	
		// GetSesiones
	public char[] getSesiones() {
		return sesiones;
	}
	
	// faltaDiaEntero()
	public void faltaDiaEntero() {
		for (int y = 0; y < 6; y++) {
			sesiones[y] = 'F';
		}
	}

	// faltaHora (int sesion)
	public boolean faltaHora(int sesion) {

		try {
			sesiones[sesion - 1] = 'F';
			return true;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Solo hay sesiones enumeradas de 1 a 6");
			return false;
		}
		// de 1 a 6 hora
	}

	public String imprimeHorario() {

		String horario = "";

		for (int n = 0; n < 6; n++) {

			horario = horario + sesiones[n];

			if (n != 5)
				horario = horario + "/";
		}
		return horario;
	}
}
