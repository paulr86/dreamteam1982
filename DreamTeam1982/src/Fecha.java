
public class Fecha {

	private int dia = 0;
	private int mes = 0;
	private int agno = 0;
	
	// Constructor con parametros		
	public Fecha (int dia, int mes, int agno) throws Exception {
		// Si Año menor 2015 devuelve un error
		if (agno < 2015 || agno > 3000) {
			throw new Exception("El año intorducido no es correcto, debe oscilar entre \"2015\" y \"2999\".");

		// Si Año mayor 2015 comprobamos el mes
		} else {
			// Si el mes es incorrecto devuelve error
			if (mes < 1 && mes < 12) {
				throw new Exception("El mes intorducido no es correcto, revise la fecha");

			// INICIO 31 dias
			} else {
				// Si el mes tiene 31 dias
				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {

					// Si el dia esta entre 1 y 31 creamos una instancia
					if (dia >= 1 && dia <= 31) {
						this.dia = dia;
						this.mes = mes;
						this.agno = agno;

					// Si el dia no esta entre 1 y 31 devolvemos error
					} else {
						throw new Exception("El dia intorducido no es correcto, revise la fecha");
					}

					// FIN 31 DIAS

				// INICIO 30 dias
				} else {
					// Si el mes tiene 30 dias
					if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

						// Si el dia esta entre 1 y 30 creamos una instancia
						if (dia >= 1 && dia <= 30) {
							this.dia = dia;
							this.mes = mes;
							this.agno = agno;

						// Si el dia no esta entre 1 y 30 devolvemos error
						} else {
							throw new Exception("El dia intorducido no es correcto, revise la fecha");
						}

				// FIN 30 DIAS

					// Ya solo queda el mes 2, por lo que solo se comprueban los dias
					} else {
						// Si el dia esta entre 1 y 28 creamos una instancia
						if (dia >= 1 && dia <= 28) {
							this.dia = dia;
							this.mes = mes;
							this.agno = agno;

						// Si el dia no esta entre 1 y 28 devolvemos error
						} else {
							throw new Exception("El dia intorducido no es correcto, revise la fecha");
						}
					}
				}
			} // fin else mes
		} // fin else año		
	}
	
	// Getters
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}

	public int getAgno() {
		return agno;
	}

	// Metodo imprime fecha
	public void imprimeFecha (int dia, int mes, int año) {
		
		// Mostramos la fecha
		System.out.println("Fecha: " + dia + "/" + mes + "/" + año + "/");
	}
	
	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object) {
		boolean igual = false;
		if (object instanceof Fecha) {
			Fecha fecha = (Fecha) object;
			if (fecha.getDia() == this.getDia() && fecha.getMes() == this.getMes() && fecha.getAgno() == this.getAgno())
				igual = true;
		}
		
		return igual;
	}
}
			
			
			
			
			
			
			
			
			
			
				
		
	
		

			
			

	
	