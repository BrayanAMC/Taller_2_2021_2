package logica;

public class SistemaIMPL implements Sistema {

	private ListaAlumnos generalAlumnos;
	private ListaAsignaturas generalAsignaturas;
	private ListaProfesores generalProfesores;
	public SistemaIMPL() {
		generalAlumnos = new ListaAlumnos(999);
		generalAsignaturas = new ListaAsignaturas(999);
		generalProfesores = new ListaProfesores(999);
	}

	@Override
	public boolean ingresarEstudiante(String rut, String correo, int nivel, String contrasena) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarAsignaturaObligatoria(String código, String nombre, int créditos, int tipo, int nivel,
			int asignaturasPreRequisito) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarAsignaturaPreRequisito(String codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarAsignaturaOpcional(String código, String nombre, int créditos, int tipo,
			int credPreRequisito) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarProfesor(String rut, String correo, String contraseña, int salario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void asociarEstudianteAsignatura(String rutEstudiante, String codigoAsignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asociarAsignaturaProfesor(String rutProfesor, String codigoAsignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirEstudiante() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String correo, String contrasena) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inscribirAsignaturas(String codigoAsignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerAsignaturasDisponibles(String rutAlumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eliminarAsignatura(String código, String asignatura) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void obtenerAsignaturasInscritas(String rutAlumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chequeoAlumnos(String codigoAsignatura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenerParalelosInscritosP(String rutProfesor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ingresoNotaFinal(String codigoAsignatura, String rutAlumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CierreSemestre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirEstudiantesEgresados() {
		// TODO Auto-generated method stub
		
	}

}
