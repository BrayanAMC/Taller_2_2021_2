package logica;

import java.sql.SQLOutput;

import dominio.Alumno;
import dominio.Asignatura;
import dominio.Profesor;
import ucn.StdOut;

public class SistemaIMPL implements Sistema {

	private static final Exception NullPointerException = null;
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
			if(asignatura instanceof AsignaturaObligatoria) 
			{
				AsignaturaObligatoria asig = (AsignaturaObligatoria)asignatura;
				AsignaturaObligatoria asignaturaPoseida = new AsignaturaObligatoria(asig.getCodigo(),asig.getNombre(), asig.getCreditos(), asig.getTipo(), asig.getNivel(), asig.getCantPre());
				//asignaturaPoseida.setParalelo(asignatura.getParalelo());
				asignaturaPoseida.setNotaFinal(notaFinal);
				alumno.getListaAsignaturas().ingresarAsignatura(asignaturaPoseida);
				//alumno.getListaAsignaturas().buscarAsignaturaCode(codigoAsignatura).setNotaFinal(notaFinal);
			}
			if(asignatura instanceof AsignaturaOpcional) 
			{
				AsignaturaOpcional asig2 = (AsignaturaOpcional)asignatura;
				AsignaturaOpcional asignaturaPoseida2 = new AsignaturaOpcional(asig2.getCodigo(),asig2.getNombre(),asig2.getCreditos(),asig2.getTipo(),asig2.getCreditosPre());
				//asignaturaPoseida2.ingresarParalelo(asignatura.);
				asignaturaPoseida2.setNotaFinal(notaFinal);
				alumno.getListaAsignaturas().ingresarAsignatura(asignaturaPoseida2);
				//alumno.getListaAsignaturas().buscarAsignaturaCode(codigoAsignatura).setNotaFinal(notaFinal);
			}
			
			//Asignatura asignaturaPoseida = new Asignatura(asignatura.getCodigo(),asignatura.getNombre(),asignatura.getCreditos(),asignatura.getTipo());
			//alumno.getListaAsignaturas().ingresarAsignatura(asignaturaPoseida);
			//alumno.getListaAsignaturas().buscarAsignaturaCode(codigoAsignatura).setNotaFinal(notaFinal);
			
		}
		
	}

	@Override
	public void asociarAsignaturaProfesor(String rutProfesor, String codigoAsignatura,String numParalelo) {
		Profesor p = generalProfesores.buscarProfesorRut(rutProfesor);
		Asignatura a = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(a!=null && p!=null) 
		{
			//ambos existen
			a.setProfesor(p);
			//a.setParalelo(numParalelo);
			a.ingresarParalelo(numParalelo);
			//p.getListaAsignaturas().ingresarAsignatura(asignatura);
			
			if(a instanceof AsignaturaObligatoria) 
			{
				AsignaturaObligatoria asig = (AsignaturaObligatoria)a;
				AsignaturaObligatoria asignaturaInscrita = new AsignaturaObligatoria(asig.getCodigo(),asig.getNombre(), asig.getCreditos(), asig.getTipo(), asig.getNivel(), asig.getCantPre());
				asignaturaInscrita.setProfesor(p);
				asignaturaInscrita.ingresarParalelo(numParalelo);
				p.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita);
				
			}
			if(a instanceof AsignaturaOpcional) 
			{
				AsignaturaOpcional asig2 = (AsignaturaOpcional)a;
				AsignaturaOpcional asignaturaInscrita2 = new AsignaturaOpcional(asig2.getCodigo(),asig2.getNombre(),asig2.getCreditos(),asig2.getTipo(),asig2.getCreditosPre());
				asignaturaInscrita2.setProfesor(p);
				asignaturaInscrita2.ingresarParalelo(numParalelo);
				p.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita2);
				
			}
			
		}
		
		Asignatura asignatura_dictando = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		System.out.println("el profesor con el rut: "+p.getRut()+" esta dictando el ramo de: "+asignatura_dictando.getNombre());
	}

	@Override
	public void escribirEstudiante() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String login(String correo, String contrasena) {
		
		for (int i = 0; i < generalAlumnos.getCant(); i++) {
			if(generalAlumnos.buscarAlumnoI(i).getCorreo().equalsIgnoreCase(correo)) 
			{
				if(generalAlumnos.buscarAlumnoI(i).getContrasena().equalsIgnoreCase(contrasena)) 
				{
					return "1";
				}
				
			}
			
		}
		for (int j = 0; j < generalProfesores.getCant(); j++) {
			if(generalProfesores.buscarProfesorI(j).getCorreo().equalsIgnoreCase(correo)) 
			{
				if(generalProfesores.buscarProfesorI(j).getContrasena().equalsIgnoreCase(contrasena)) 
				{
					return "2";
				}
			}
			
		}
		return "0";
	}

	@Override
	public boolean inscribirAsignaturas(String codigoAsignatura,String correo,String paralelo) {
		int contador = 0;
		Asignatura asigSistema = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		Alumno alumno = generalAlumnos.buscarAlumnoCorreo(correo);
		String currentCodigo;
		
		for (int i = 0; i < alumno.getListaAsignaturas().getCant(); i++) {
			currentCodigo = alumno.getListaAsignaturas().buscarAsignaturaI(i).getCodigo();
			
			if(currentCodigo.equalsIgnoreCase(codigoAsignatura)) 
			{
				contador++;
			}
			
		}
		if(contador == 0) 
		{
			//no tiene esa asignatura en su lista por lo tanto se puede inscribir
			Asignatura a = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
			if(a!=null && alumno!=null) 
			{
				if(a instanceof AsignaturaObligatoria) 
				{
					AsignaturaObligatoria asig = (AsignaturaObligatoria)a;
					AsignaturaObligatoria asignaturaInscrita = new AsignaturaObligatoria(asig.getCodigo(),asig.getNombre(), asig.getCreditos(), asig.getTipo(), asig.getNivel(), asig.getCantPre());
					asignaturaInscrita.ingresarParalelo(paralelo);
					asignaturaInscrita.ingresarAlumno(alumno);
					return alumno.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita);
					
				} 
				if(a instanceof AsignaturaOpcional) 
				{
					AsignaturaOpcional asig2 = (AsignaturaOpcional)a;
					AsignaturaOpcional asignaturaInscrita2 = new AsignaturaOpcional(asig2.getCodigo(),asig2.getNombre(),asig2.getCreditos(),asig2.getTipo(),asig2.getCreditosPre());
					asignaturaInscrita2.ingresarParalelo(paralelo);
					asignaturaInscrita2.ingresarAlumno(alumno);
					return alumno.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita2);

				} 
				
			}else {
				return false;
			}
			
		}
		
		return false;
	}

	@Override
	public String obtenerAsignaturasDisponibles(String correo) {
		//solo mostrar las asignaturas que el alumno no tenga inscritas
		int contador = 0;
		String out = "";
		String codigoAlumno = "";
		Alumno alumno = generalAlumnos.buscarAlumnoCorreo(correo);
		if (alumno!=null) {
			out+= "asignaturas disponibles:\n";
			for (int i = 0; i < generalAsignaturas.getCant(); i++) {
				contador = 0;
				for (int j = 0; j < alumno.getListaAsignaturas().getCant(); j++) {
					codigoAlumno = alumno.getListaAsignaturas().buscarAsignaturaI(j).getCodigo();
					if(generalAsignaturas.buscarAsignaturaI(i).getCodigo().equalsIgnoreCase(codigoAlumno)) 
					{
						contador++;
						//Asignatura asignaturaCorrecta = generalAsignaturas.buscarAsignaturaI(i);
						//out+= asignaturaCorrecta.getNombre()+" codigo: "+asignaturaCorrecta.getCodigo()+"\n";
					}else {
						
					}
					
				}
				if(contador == 0) 
				{
					Asignatura asignaturaCorrecta = generalAsignaturas.buscarAsignaturaI(i);
					out+= asignaturaCorrecta.getNombre()+" codigo: "+asignaturaCorrecta.getCodigo()+" paralelos: "+asignaturaCorrecta.getParalelos()+"\n";
				}
				
			}
			if(contador != 0) 
			{
				return "no hay asignaturas disponibles para inscribir";
			}else {
				return out;
			}	
		}else {
			return "";
		}			
			
		
		
	}

	@Override
	public boolean eliminarAsignatura(String correo, String codigo) {
		Alumno alumno = generalAlumnos.buscarAlumnoCorreo(correo);
		Asignatura asignatura = alumno.getListaAsignaturas().buscarAsignaturaCode(codigo);
		if(alumno!= null && asignatura!=null) 
		{
			return alumno.getListaAsignaturas().elimianarAsignatura(codigo);
			
		}
		return false;
	}

	@Override
	public String obtenerAsignaturasInscritas(String correo) {
		String out = "";
		Alumno a = generalAlumnos.buscarAlumnoCorreo(correo);
		for (int i = 0; i < a.getListaAsignaturas().getCant(); i++) {
			Asignatura asignatura = a.getListaAsignaturas().buscarAsignaturaI(i);
			if(asignatura.getNotaFinal()==0) 
			{
				out+= asignatura.getNombre()+" codigo "+asignatura.getCodigo()+"\n";
			}
			
		}
		return out;
		
	}

	@Override
	public String chequeoAlumnos(String correo,String codigo,String paralelo) {
		String out = "";
		Profesor p = generalProfesores.buscarProfesorCorreo(correo);
		Asignatura a = p.getListaAsignaturas().buscarAsignaturaCode(codigo);
		System.out.println("---check objetos");

		System.out.println(p);
		System.out.println(a);

		//if(p!=null && a!=null) {
		
		Asignatura asig = p.getListaAsignaturas().buscarAsignaturaCode(codigo);
		
		System.out.println("antes del for");
		System.out.println("check cantidad:");
		System.out.println(a.getListaAlumnos().getCant());
		for(int j = 0; j < a.getListaAlumnos().getCant(); j++){
			System.out.println("despues del for");

			Alumno alumno = a.getListaAlumnos().buscarAlumnoI(j);
			System.out.println(alumno);
			System.out.println(alumno.getRut());
			System.out.println(alumno.getCorreo());


			out+= "rut alumno: "+alumno.getRut()+" correo alumno: "+alumno.getCorreo()+"\n";
			
		}
			
			
		
		//}
		return out;
	}

	@Override
	public String obtenerParalelosInscritosP(String correo) {
		Profesor p = generalProfesores.buscarProfesorCorreo(correo);
		String out = "";
		for (int i = 0; i < p.getListaAsignaturas().getCant(); i++) {
			Asignatura a = p.getListaAsignaturas().buscarAsignaturaI(i);
			out+= "codigo: "+a.getCodigo()+" paralelo: "+a.getParalelos()+"\n";
			
		}
		return out;
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

	@Override
	public void asociarEstudianteAsignaturaInscrita(String rutEstudiante, String codigoAsignatura, String paralelo) {
		Alumno alumno = generalAlumnos.buscarAlumnoRut(rutEstudiante);
		Asignatura a = generalAsignaturas.buscarAsignaturaCode(codigoAsignatura);
		if(alumno!=null && a!=null) 
		{
			a.getListaAlumnos().agregarAlumno(alumno);
			if(a instanceof AsignaturaObligatoria) 
			{
				AsignaturaObligatoria asig = (AsignaturaObligatoria)a;
				AsignaturaObligatoria asignaturaInscrita = new AsignaturaObligatoria(asig.getCodigo(),asig.getNombre(), asig.getCreditos(), asig.getTipo(), asig.getNivel(), asig.getCantPre());
				asignaturaInscrita.ingresarParalelo(paralelo);
				alumno.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita);
			}
			if(a instanceof AsignaturaOpcional) 
			{
				AsignaturaOpcional asig2 = (AsignaturaOpcional)a;
				AsignaturaOpcional asignaturaInscrita2 = new AsignaturaOpcional(asig2.getCodigo(),asig2.getNombre(),asig2.getCreditos(),asig2.getTipo(),asig2.getCreditosPre());
				asignaturaInscrita2.ingresarParalelo(paralelo);
				alumno.getListaAsignaturas().ingresarAsignatura(asignaturaInscrita2);
			}
			
		}
		
	}

}
