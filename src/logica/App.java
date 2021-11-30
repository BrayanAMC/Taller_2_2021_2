package logica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import ucn.ArchivoEntrada;
import ucn.Registro;


public class App {
	
	

	public static void main(String[] args) throws IOException {
		Sistema s = new SistemaIMPL();
		leerAsignaturas(s);
		leerProfesores(s);
		leerParalelos(s);
		leerEstudiantes(s);

	}
	private static void leerEstudiantes(Sistema s) throws IOException{
		Scanner scan = new Scanner(new File("estudiantes.txt"));
		int contadorLine = 0;
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String [] partes = line.split(",");
			contadorLine = partes.length;
			String rut = partes[0];
			rut = rut.toLowerCase().replace("-","").replace(".", "");
			String correo = partes[1];
			int nivel = Integer.parseInt(partes[2]);
			String contrasena = partes[3];
			boolean ingreso2 = s.ingresarEstudiante(rut, correo, nivel, contrasena);
			if(ingreso2) 
			{
				System.out.println("el estudiante :"+rut+" se ingreso con exito");
			}else {
				System.out.println("el estudiante :"+rut+" no se pudo ingresar");
			}
			int line2 = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < line2; i++) {
				String line3 = scan.nextLine();
				String [] partes2 = line3.split(",");
				String codigoAsignaturasCursadas = partes2[0];
				double notaFinal = Double.parseDouble(partes2[1]);
				try {
					
					s.asociarEstudianteAsignatura(rut, codigoAsignaturasCursadas,notaFinal);
				}
				catch(Exception e) {
					System.out.println("no se pudo asociar al alumno con la asignatura cursada");
				}
			}
			//otro salto de linea
			String line4 = scan.nextLine();
			int auxLine4 = Integer.parseInt(line4);
			if(line4.equalsIgnoreCase("0")) 
			{
				//estamos a principio de semestre
				System.out.println("el estudiante aun no ha inscrito ninguna asignatura");
			}else {
				for(int j = 0;j<auxLine4;j++) {
					String line5 = scan.nextLine();
					String []partes3 = line5.split(",");
					String codigoAsignaturaInscrita = partes3[0];
					String numeroParalelo = partes3[1];
					
					try {
						
						s.asociarEstudianteAsignaturaInscrita(rut, codigoAsignaturaInscrita, numeroParalelo);
					}
					catch(Exception e) {
						System.out.println("no se pudo asociar al alumno con la asignatura inscrita");
					}
				}	
			}
			
			
		}
	}
	/**
	private static void leerEstudiantes(Sistema s) throws IOException{
		ArchivoEntrada arch = new ArchivoEntrada("estudiantes.txt");
		boolean ingreso= true;
		while(!arch.isEndFile()&&ingreso) {
			Registro reg = arch.getRegistro();
			String rut = reg.getString().toLowerCase().replace("-","").replace(".", "");
			String correo = reg.getString();
			int nivel = reg.getInt();
			String contrasena = reg.getString();
			boolean ingreso2 = s.ingresarEstudiante(rut, correo, nivel, contrasena);
			if(ingreso2) 
			{
				System.out.println("el estudiante :"+rut+" se ingreso con exito");
			}else {
				System.out.println("el estudiante :"+rut+" no se pudo ingresar");
			}
			
			//arch.isEndFile();
			System.out.println("filtro0");
			
			String asignaturasCursadas = reg.getString();
			System.out.println(asignaturasCursadas);//null
			System.out.println("filtro1");
			int contador = Integer.parseInt(asignaturasCursadas);
			System.out.println("filtro2");
			for (int i = 0; i < contador; i++) {
				System.out.println("filtro3");
				String codigoAsignatura = reg.getString();
				System.out.println("filtro4");
				double notaFinal = reg.getDouble();
				System.out.println("filtro5");
				try {
					System.out.println("antes de asociar estudiantes");
					s.asociarEstudianteAsignatura(rut, codigoAsignatura,notaFinal);
				}
				catch(Exception e) {
					System.out.println("no se pudo asociaral alumno con la asignatura cursada");
				}
			}
			
		}
	}**/

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
