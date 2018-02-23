
public class pruebaa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno prueba = new Alumno ("1");
		
		prueba.setNombre("Nombre");
		
		prueba.getFaltas().get(0).getSesiones().faltaHora(1);
		
		System.out.println(prueba.getFaltas().get(0).getSesiones().getSesiones());
		
	}

}
