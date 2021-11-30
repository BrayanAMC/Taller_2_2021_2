package logica;

import java.sql.SQLOutput;

import dominio.Alumno;
import dominio.Asignatura;
import dominio.Profesor;
import ucn.StdOut;

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
		Alumno alumno = new Alumno(rut,correo,nivel,contrasena);
		boolean out = generalAlumnos.agregarAlumno(alumno);
		return out;
	}

	@Override
	public boolean ingresarAsignaturaObligatoria(String código, String nombre, int créditos, String tipo, int nivel,
			int asignaturasPreRequisito) {
		AsignaturaObligatoria asigObli = new AsignaturaObligatoria(código, nombre, créditos, tipo, nivel, asignaturasPreRequisito);
		boolean out = generalAsignaturas.ingresarAsignatura(asigObli);
		return out;
	}

	@Override
	public boolean ingresarAsignaturaPreRequisito(String codigo) {
		return false;
	}

	@Override
	public boolean ingresarAsignaturaOpcional(String código, String nombre, int créditos, String tipo,
			int credPreRequisito) {
		AsignaturaOpcional asigOpc = new AsignaturaOpcional(código, nombre, créditos, tipo, credPreRequisito);
		boolean out = generalAsignaturas.ingresarAsignatura(asigOpc);
		return out;
	}

	@Override
	public boolean ingresarProfesor(String rut, String correo, String contraseña, int salario) {
		Profesor profesor = new Profesor(rut,correo,contraseña,salario);
		boolean out = generalProfesores.ingresarProfesor(profesor);
		return out;
	}

	@Override
	public void asociarEstudianteAsignatura(String rutEstudiante, String codigoAsignatura,double notaFinal) {
		Alumno alumno = generalAlumnos.buscarAlumnoRut(rutEstudiante);
		Asignatura asignatura = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(alumno!=null && asignatura!=null) 
		{
			asignatura.getListaAlumnos().agregarAlumno(alumno);
			
			Asignatura asignaturaPoseida = new Asignatura(asignatura.getCodigo(),asignatura.getNombre(),asignatura.getCreditos(),asignatura.getTipo());
			alumno.getListaAsignatura().ingresarAsignatura(asignaturaPoseida);
			alumno.getListaAsignatura().buscarAsignaturaCode(codigoAsignatura).setNotaFinal(notaFinal);
			System.out.println(asignatura.getCodigo());
			System.out.println(asignaturaPoseida.getCodigo());
			System.out.println(asignatura.getNotaFinal());
			System.out.println(asignaturaPoseida.getNotaFinal());
		}
		
	}

	@Override
	public void asociarAsignaturaProfesor(String rutProfesor, String codigoAsignatura,String numParalelo) {
		Profesor p = generalProfesores.buscarProfesorRut(rutProfesor);
		Asignatura asignatura = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(asignatura!=null && p!=null) 
		{
			//ambos existen
			asignatura.setProfesor(p);
			asignatura.setParalelo(numParalelo);
			p.getListaAsignaturas().ingresarAsignatura(asignatura);
			
		}
		Asignatura asignatura_dictando = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		System.out.println("el profesor con el rut: "+p.getRut()+" esta dictando el ramo de: "+asignatura_dictando.getNombre());
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

	@Override
	public void asociarAsignaturaAsignaturaPre(String codigoAsignatura, String codigoAsignaturaPre) {
		AsignaturaObligatoria asignatura = (AsignaturaObligatoria) generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(asignatura != null) 
		{
			asignatura.ingresarListaPre(codigoAsignaturaPre);
			
		}
		Asignatura a = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(a instanceof AsignaturaObligatoria) 
		{
			AsignaturaObligatoria obligatoria = (AsignaturaObligatoria)a;
			System.out.println(obligatoria.obtenerCodigoAsigPre(0));
			System.out.println(obligatoria.obtenerCodigoAsigPre(1));
			System.out.println(obligatoria.obtenerCodigoAsigPre(2));
		}
		
	}

}
