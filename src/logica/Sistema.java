package logica;

public interface Sistema {
	boolean ingresarEstudiante(String rut,String correo,int nivel,String contrasena);
	boolean ingresarAsignaturaObligatoria(String c�digo,String nombre,int cr�ditos,String tipo,int nivel,int asignaturasPreRequisito);
	boolean ingresarAsignaturaPreRequisito(String codigo);
	boolean ingresarAsignaturaOpcional(String c�digo,String nombre,int cr�ditos,String tipo,int credPreRequisito);
	boolean ingresarProfesor(String rut,String correo,String contrase�a,int salario);
	void asociarEstudianteAsignatura(String rutEstudiante,String codigoAsignatura);
	void asociarAsignaturaProfesor(String rutProfesor,String codigoAsignatura);
	void escribirEstudiante();
	void login(String correo,String contrasena);
	void inscribirAsignaturas(String codigoAsignatura);
	void obtenerAsignaturasDisponibles(String rutAlumno);
	boolean eliminarAsignatura(String c�digo ,String asignatura);
	void obtenerAsignaturasInscritas(String rutAlumno);
	void chequeoAlumnos(String codigoAsignatura);
	void obtenerParalelosInscritosP(String rutProfesor);
	void ingresoNotaFinal(String codigoAsignatura,String rutAlumno);
	void CierreSemestre();
	void escribirEstudiantesEgresados();
	void asociarAsignaturaAsignaturaPre(String codigoAsignatura,String codigoAsignaturaPre);
}
