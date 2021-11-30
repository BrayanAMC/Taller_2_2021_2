package logica;

import java.io.IOException;

import ucn.ArchivoEntrada;
import ucn.Registro;


public class App {
	
	

	public static void main(String[] args) throws IOException {
		Sistema s = new SistemaIMPL();
		leerAsignaturas(s);
		leerProfesores(s);
		leerParalelos(s);

	}

	private static void leerParalelos(Sistema s)throws IOException {
		ArchivoEntrada arch = new ArchivoEntrada("paralelos.txt");
		boolean ingreso= true;
		while(!arch.isEndFile()&&ingreso) {
			Registro reg = arch.getRegistro();
			String numParalelo = reg.getString();
			String codigoParalelo = reg.getString();
			String rutProfesor = reg.getString().toLowerCase().replace("-","").replace(".", "");
			
			try {
				s.asociarAsignaturaProfesor(rutProfesor, codigoParalelo,numParalelo);
			}
			catch(Exception e) {
				System.out.println("no se pudo asociar al profesor con la asignatura");
			}
			
		}
		
	}

	private static void leerProfesores(Sistema s) throws IOException{
		ArchivoEntrada arch = new ArchivoEntrada("profesores.txt");
		boolean ingreso= true;
		while(!arch.isEndFile()&&ingreso) {
			Registro reg = arch.getRegistro();
			String rut = reg.getString().toLowerCase().replace("-","").replace(".", "");
			String correo = reg.getString();
			String contrasena = reg.getString();
			int salario = reg.getInt();
			boolean ingreso2 = s.ingresarProfesor(rut, correo, contrasena, salario);
			if(ingreso2) 
			{
				System.out.println("el profesor con el rut: "+rut+" fue ingresado con exito");
			}else {
				System.out.println("el profesor con el rut: "+rut+" NO se pudo ingresar");
			}
			
			
			
		}
	}

	private static void leerAsignaturas(Sistema s) throws IOException {
		ArchivoEntrada arch = new ArchivoEntrada("asignaturas.txt");
		boolean ingreso= true;
		while(!arch.isEndFile()&&ingreso) {
			Registro reg = arch.getRegistro();
			String codigoAsig = reg.getString();
			String nomAsig = reg.getString();
			int creditos = reg.getInt();
			String tipoAsig = reg.getString();
			if(tipoAsig.equalsIgnoreCase("obligatoria")) 
			{
				int nivelMalla = reg.getInt();
				int cantPre = reg.getInt();
				boolean ingreso2 = s.ingresarAsignaturaObligatoria(codigoAsig,nomAsig,creditos,tipoAsig,nivelMalla,cantPre);
				if(ingreso2) 
				{
					System.out.println("la asignatura: "+nomAsig+" se añadio correctamente");
				}else {
					System.out.println("la asignatura: "+nomAsig+" no se añadio correctamente");
				}
				for(int i = 0; i<cantPre;i++) 
				{
					String codigoAsigPre = reg.getString();
					try {
						s.asociarAsignaturaAsignaturaPre(codigoAsig,codigoAsigPre); 
					}
					catch(Exception e) {
						System.out.println("no existe asignatura a la cual asociar el ramo pre requisito");
					}
					
				}
			}
			if(tipoAsig.equals("opcional")) 
			{	
				int creditosAsigPre = reg.getInt();
				boolean ingreso3 = s.ingresarAsignaturaOpcional(codigoAsig, nomAsig, creditos, tipoAsig, creditosAsigPre);
				if(ingreso3) 
				{
					System.out.println("la asignatura: "+nomAsig+" se añadio correctamente");
				}else {
					System.out.println("la asignatura: "+nomAsig+" no se añadio correctamente");
				}
			}
			
			
			
		}
	}

}
