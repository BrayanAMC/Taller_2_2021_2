package logica;

public interface Sistema {
	boolean ingresarEstudiante(String rut,String correo,int nivel,String contrasena);
	boolean ingresarAsignaturaObligatoria(String código,String nombre,int créditos,String tipo,int nivel,int asignaturasPreRequisito);
	boolean ingresarAsignaturaPreRequisito(String codigo);
	boolean ingresarAsignaturaOpcional(String código,String nombre,int créditos,String tipo,int credPreRequisito);
	boolean ingresarProfesor(String rut,String correo,String contraseña,int salario);
	void asociarEstudianteAsignatura(String rutEstudiante,String codigoAsignatura,double notaFinal);
	void asociarAsignaturaProfesor(String rutProfesor,String codigoAsignatura,String numParalelo);
	void escribirEstudiante();
	String login(String correo,String contrasena);
	boolean inscribirAsignaturas(String codigoAsignatura,String correo,String paralelo);
	String obtenerAsignaturasDisponibles(String correo);
	boolean eliminarAsignatura(String correo ,String codigo);
	String obtenerAsignaturasInscritas(String correo);
	String chequeoAlumnos(String correo,String codigo,String paralelo);
	String obtenerParalelosInscritosP(String correo);
	boolean ingresoNotaFinal(String correo,String codigo,String paralelo,String rutAlumno,double notaFinal);
	void CierreSemestre();
	void escribirEstudiantesEgresados();
	void asociarAsignaturaAsignaturaPre(String codigoAsignatura,String codigoAsignaturaPre);
	void asociarEstudianteAsignaturaInscrita(String rutEstudiante,String codigoAsignatura,String paralelo);
	String obtenerEstudiantesInscritos(String correo,String codigo,String paralelo);
}
