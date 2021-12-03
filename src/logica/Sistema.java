package logica;

public interface Sistema {
	/**
	 * a student enters the system
	 * @param rut student's rut
	 * @param correo student's email
	 * @param nivel student's level
	 * @param contrasena student's password
	 * @return true or false depending on whether the student was able to enter correctly
	 */
	boolean ingresarEstudiante(String rut,String correo,int nivel,String contrasena);
	/**
	 * se ingresa una asignatura obligatoria al sistema
	 * @param código
	 * @param nombre
	 * @param créditos
	 * @param tipo
	 * @param nivel
	 * @param asignaturasPreRequisito
	 * @return
	 */
	boolean ingresarAsignaturaObligatoria(String código,String nombre,int créditos,String tipo,int nivel,int asignaturasPreRequisito);
	/**
	 * the code of the prerequisite subjects that has a subject is entered
	 * @param codigo
	 * @return
	 */
	boolean ingresarAsignaturaPreRequisito(String codigo);
	/**
	 * an optional subject is entered into the system
	 * @param código
	 * @param nombre
	 * @param créditos
	 * @param tipo
	 * @param credPreRequisito
	 * @return
	 */
	boolean ingresarAsignaturaOpcional(String código,String nombre,int créditos,String tipo,int credPreRequisito);
	/**
	 * a teacher is entered into the system
	 * @param rut
	 * @param correo
	 * @param contraseña
	 * @param salario
	 * @return
	 */
	boolean ingresarProfesor(String rut,String correo,String contraseña,int salario);
	/**
	 * se asocia al estudiante con una asignatura
	 * @param rutEstudiante
	 * @param codigoAsignatura
	 * @param notaFinal
	 */
	void asociarEstudianteAsignatura(String rutEstudiante,String codigoAsignatura,double notaFinal);
	/**
	 * a subject is associated with a teacher
	 * @param rutProfesor
	 * @param codigoAsignatura
	 * @param numParalelo
	 */
	void asociarAsignaturaProfesor(String rutProfesor,String codigoAsignatura,String numParalelo);
	/**
	 * a new txt file is written with the data of the students
	 */
	void escribirEstudiante();
	/**
	 * allows a user to enter the system by entering their credentials
	 * @param correo
	 * @param contrasena
	 * @return
	 */
	String login(String correo,String contrasena);
	/**
	 * allows a student to enroll a subject
	 * @param codigoAsignatura
	 * @param correo
	 * @param paralelo
	 * @return
	 */
	boolean inscribirAsignaturas(String codigoAsignatura,String correo,String paralelo);
	/**
	 * the subjects taken are obtained by entering the email as a parameter
	 * @param correo
	 * @return
	 */
	String obtenerAsignaturasDisponibles(String correo);
	/**
	 * allows the student to delete an enrolled subject
	 * @param correo
	 * @param codigo
	 * @return
	 */
	boolean eliminarAsignatura(String correo ,String codigo);
	/**
	 * the subjects that a student has enrolled are obtained
	 * @param correo
	 * @return
	 */
	String obtenerAsignaturasInscritas(String correo);
	/**
	 * allows a teacher to see the students enrolled in one of their subjects
	 * @param correo
	 * @param codigo
	 * @param paralelo
	 * @return
	 */
	String chequeoAlumnos(String correo,String codigo,String paralelo);
	/**
	 * the subjects that a teacher is going to teach are obtained
	 * @param correo
	 * @return
	 */
	String obtenerParalelosInscritosP(String correo);
	/**
	 * allows a teacher to enter a student's final grade in a particular subject
	 * @param correo
	 * @param codigo
	 * @param paralelo
	 * @param rutAlumno
	 * @param notaFinal
	 * @return
	 */
	boolean ingresoNotaFinal(String correo,String codigo,String paralelo,String rutAlumno,double notaFinal);
	/**
	 * consolidate the semester data and close the system
	 */
	void CierreSemestre();
	/**
	 * a new txt file is written with the data of the graduated students
	 */
	void escribirEstudiantesEgresados();
	/**
	 * associates a subject with its prerequisite subjects
	 * @param codigoAsignatura
	 * @param codigoAsignaturaPre
	 */
	void asociarAsignaturaAsignaturaPre(String codigoAsignatura,String codigoAsignaturaPre);
	/**
	 * associates a student with their enrolled subject
	 * @param rutEstudiante
	 * @param codigoAsignatura
	 * @param paralelo
	 */
	void asociarEstudianteAsignaturaInscrita(String rutEstudiante,String codigoAsignatura,String paralelo);
	/**
	 * the students enrolled in a parallel subject are obtained
	 * @param correo
	 * @param codigo
	 * @param paralelo
	 * @return
	 */
	String obtenerEstudiantesInscritos(String correo,String codigo,String paralelo);
}
