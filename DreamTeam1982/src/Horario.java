
public class Horario {

	private char[] sesiones = new char [6];

//Constructor por defeco
		
		public Horario (){
			for (int y = 0; y < 6; y++) {
			sesiones[y] = ' ';
			}
		}
//GetSesiones
			
		public char[] GetSesiones() {
			return sesiones;
		}	
		
//faltaDiaEntero()

		public void faltaDiaEntero() {
			for (int y = 0; y < 6; y++) {
				sesiones[y] = 'F';
			}
		}
		
//faltaHora (int sesion)

		public void faltaHora (int sesion) {
			sesiones[sesion - 1] = 'F';
			
			
		// de 1 a 6 hora 
	}
}
