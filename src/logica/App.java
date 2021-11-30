package logica;

import java.io.IOException;

import ucn.ArchivoEntrada;
import ucn.Registro;


public class App {
	
	

	public static void main(String[] args) throws IOException {
		Sistema s = new SistemaIMPL();
		leerAsignaturas(s);

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
				s.ingresarAsignaturaOpcional(codigoAsig, nomAsig, creditos, tipoAsig, creditosAsigPre);
			}
			
			
			
		}
	}

}
