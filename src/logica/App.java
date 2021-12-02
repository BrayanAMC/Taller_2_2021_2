package logica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;


public class App {
	
	

	public static void main(String[] args) throws IOException {
		Sistema s = new SistemaIMPL();
		leerAsignaturas(s);
		leerProfesores(s);
		leerParalelos(s);
		leerEstudiantes(s);
		inicioSesion(s);

	}
	private static void inicioSesion(Sistema s) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("ingrese una opcion\n 1) inicio sesion \n2)cerrar sesion");
		int opcion = -1;
		boolean repetir = true;
		while(repetir)//controla que el dato ingresado sea un int
		{
			try 
			{
				opcion = entrada.nextInt();
				repetir = false;
			}catch(Exception e){
				System.out.println("dato mal ingresado,intente nuevamente");
        		System.out.println("ingrese una opcion\n1)iniciar sesion \n2)cerrar");
        		entrada.nextLine();
			}
		}
		while(opcion!=2) 
		{
			switch(opcion) {
			case 1:
				//eligio iniciar sesion
				System.out.println("ingrese su correo");
				String correo = StdIn.readString();
				System.out.println("ingrese su contrasena");
				String contrasena = StdIn.readString();
				if(correo.equalsIgnoreCase("Admin")&& contrasena.equalsIgnoreCase("GHI_789")) 
				{
					//se a logeado un admin
					System.out.println("usted a entrado como admin");
				}
				else {
					try {
						
						String registro = s.login(correo, contrasena);
						if(registro.equalsIgnoreCase("0")) 
						{
							System.out.println("contrasena o correo incorrectos");
						}else {
							//desplegar menu
							System.out.println("todo correcto debe ingresar una fecha");
							System.out.println("ingrese la fecha actual:");
							int dia = -1;
							int mes = -1;
							int anio = -1;
							boolean repetir2 = true;
							while(repetir2) {
								try {
									System.out.println("ingrese el dia:");
									dia = entrada.nextInt();
									System.out.println("ingrese mes:");
									mes = entrada.nextInt();
									System.out.println("ingrese año");
									anio = entrada.nextInt();
									repetir2 = false;
									
								}catch(Exception e){
									System.out.println("dato mal ingresado,intente nuevamente");
					        		System.out.println("ingrese una opciones de meses validas");
					        		//System.out.println("ingrese el dia:");
					        		entrada.nextLine();
								}
							}
							//definir con los datos de fechas en que periodo de semestre nos encontramos
							int periodoActual = definirPeriodo(dia,mes,anio);
							// 1---> inicio semestre
							// 2---> mitad semestre
							// 3---> final semestre
							// 4---> cierre sistema
							//-1---> feliz vacaciones
							if(registro.equalsIgnoreCase("1")) 
							{
								System.out.println("menu para estudiante");
								if(periodoActual == 1) 
								{
									menuEstudianteInicioSemestre(correo,s);
								}
								if(periodoActual == 2) 
								{
									menuEstudianteMitadSemestre(correo,s);
								}
								if(periodoActual == 3) 
								{
									System.out.println("un estudiante no tiene menu para finales de semestre");
								}
								
								
						
							}
							if(registro.equalsIgnoreCase("2")) 
							{
								System.out.println("menu para profesores");
								if(periodoActual == 1) 
								{
									menuProfesorInicioSemestre(correo,s);
								}
								if(periodoActual == 2) 
								{
									System.out.println("los profesores no tienen menu para mitad de semestre");
								} 
								if(periodoActual == 3) 
								{
									menuProfesorFinalSemestre(correo,s);
								}
								
							}
						}
						
					}catch(Exception e){
						System.out.println("error al verificar usuario en el catch");
						
					}
				}
				
				break;
			default:
				System.out.println("dato mal ingresado");
			
			}
			System.out.println("ingrese una opcion\n 1) inicio sesion \n2)cerrar sesion");
			opcion = -1;
			repetir = true;
			while(repetir)//controla que el dato ingresado sea un int
			{
				try 
				{
					opcion = entrada.nextInt();
					repetir = false;
				}catch(Exception e){
					System.out.println("dato mal ingresado,intente nuevamente");
	        		System.out.println("ingrese una opcion\n1)iniciar sesion \n2)cerrar");
	        		entrada.nextLine();
				}
			}
			
		}
		
		
	}
	private static void menuProfesorFinalSemestre(String correo, Sistema s) {
		
		
	}
	private static void menuProfesorInicioSemestre(String correo, Sistema s) {
		Scanner entrada = new Scanner(System.in);
		boolean repetir = true;
		int opcion = -1;
        System.out.println("1)Chequeo Alumnos\n2)Salir");
        while(repetir) 
        {
        	try {
        		opcion = entrada.nextInt();
        		repetir = false;
        	}catch(Exception e) 
        	{
        		System.out.println("opcion no valida");
                System.out.println("1)Chequeo Alumnos\n2)Salir");
                entrada.nextLine();
        	}
        }
        while(opcion!=2) 
        {
        	switch(opcion) {
        	case 1:
	        	System.out.println("se eligio chequeo alumnos");
	        	String paralelosIns = s.obtenerParalelosInscritosP(correo);
	        	if(paralelosIns.equalsIgnoreCase("")) 
	        	{
	        		System.out.println("no hay paralelos para mostrar");
	        		break;
	        	}
	        	else {
	        		System.out.println("sus paralelos son:");
	        		System.out.println(paralelosIns);
	        		
	        	}
	        	//seguir aqui<----
	        	System.out.println("ingrese el codigo de la asignatura a revisar: ");
        		boolean repetir2 = true;
        		int opcion2 = -1;
        		int opcion3 = -1;
        		while(repetir2) 
        		{
        			try {
        				opcion2 = entrada.nextInt();
        				System.out.println("ingrese el paralelo: ");
        				opcion3 = entrada.nextInt();
        				repetir2 = false;
        				
        			}catch(Exception e) {
        				System.out.println("codigo o paralelo  mal ingresado");
        				entrada.nextLine();
        			}
        		}
        		String auxOpcion2 = Integer.toString(opcion2);
        		String auxOpcion3 = Integer.toString(opcion3);
        		String revision = s.chequeoAlumnos(correo,auxOpcion2,auxOpcion3);
        		System.out.println("-----correo es ");
        		System.out.println(correo);
        		System.out.println("-----revidion es ");
        		System.out.println(revision);
        		if(revision.equalsIgnoreCase("")) 
        		{
        			System.out.println("en el paralelo: "+auxOpcion3+" de codigo: "+auxOpcion2+" no hay estudiantes inscritos");
        		}else {
        			System.out.println("los estudiantes inscriyos en la asignatura de codigo: "+auxOpcion2+" en el paralelo: "+auxOpcion3+" son:");
        			System.out.println(revision);
        		}
        		
        		
	        	break;
	        default:
	        	System.out.println("mal ingreso de datos");
        	}
	    	System.out.println("1)Chequeo Alumnos\n2)Salir");
	    	repetir =true;
	        while(repetir) 
	        {
	        	try {
	          		opcion = entrada.nextInt();
	          		repetir = false;
	          	}catch(Exception e) 
	          	{
	          		System.out.println("opcion no valida");
	                  System.out.println("1)Chequeo Alumnos\n2)Salir");
	                  entrada.nextLine();
	          	}
	        }
        }

		
		
	}
	private static void menuEstudianteMitadSemestre(String correo, Sistema s) {
		Scanner entrada = new Scanner(System.in);
		boolean repetir = true;
		int opcion = -1;
        System.out.println("1)eliminarAsignatura\n2)Salir");
        while(repetir) {
        	try {
        		opcion = entrada.nextInt();
        		repetir = false;	
        		
        	}catch(Exception e) {
    			System.out.println("dato mal ingresado");
    			System.out.println("1)eliminarAsignatura\n2)Salir");
    			entrada.nextLine();
    		}
        }
        while(opcion!=2 && opcion >0 && opcion<2) {
        	
        	switch(opcion) {
        	case 1:
        		System.out.println("estamos en case 1 de menu estudiante mitad semestre");
           		System.out.println("se eligio eliminar Asignatura");        		
        		String disponibles2 = s.obtenerAsignaturasInscritas(correo);
        		if(disponibles2.equalsIgnoreCase("")) 
        		{
        			System.out.println("usted no tiene asignaturas inscritas");
        			break;
        		}else {
        			System.out.println("asignaturas inscritas:");
        			System.out.println(disponibles2);
        		}
        		System.out.println("ingrese el codigo de la asignatura que desea eliminar: ");
        		boolean repetir3 = true;
        		int opcion4 = -1;
        		while(repetir3) 
        		{
        			try {
        				opcion4 = entrada.nextInt();
        				repetir3 = false;
        			}catch(Exception e){
        				System.out.println("codigo mal ingresado");
        				entrada.nextLine();
        			}
        		}
        		String auxOpcion4 = Integer.toString(opcion4);
        		boolean eliminarAsig = s.eliminarAsignatura(correo,auxOpcion4);
        		if(eliminarAsig) 
        		{
        			System.out.println("se ha eliminado la asignatura perteneciente al codigo: "+auxOpcion4);
        		}else {
        			System.out.println("no se ha podido eliminar la asignatura "+auxOpcion4);
        		}
        	
        		break;
        	
        	
        	
        	}
        	
        	System.out.println("1)eliminarAsignatura\n2)Salir");
        	repetir = true;
            while(repetir) {
            	
            	try {
            		opcion = entrada.nextInt();
            		repetir = false;	
          		
            	}catch(Exception e) {
      			System.out.println("dato mal ingresado");
      			System.out.println("1)eliminarAsignatura\n2)Salir");
      			entrada.nextLine();
            	}
            }
        }
        
		
	}
	private static void menuEstudianteInicioSemestre(String correo, Sistema s) {
		Scanner entrada = new Scanner(System.in);
		boolean repetir = true;
        int opcion =-1;
        System.out.println("1)Inscripcion Asignatura\n2)Eliminar Asignatura\n3)Salir");
        while(repetir) 
        {
        	try 
			{
				opcion = entrada.nextInt();
				repetir = false;
			}catch(Exception e){
				System.out.println("dato mal ingresado,intente nuevamente");
        		System.out.println("1)Inscripcion Asignatura\n2)Eliminar Asignatura\n3)Salir");
        		entrada.nextLine();
			}
        }
        while(opcion!=3) 
        {
        	switch(opcion) 
        	{
        	case 1:
        		System.out.println("se eligio inscripcion asignatura");
        		String disponibles = s.obtenerAsignaturasDisponibles(correo);
        		System.out.println(disponibles);
        		if(disponibles.equalsIgnoreCase("no hay asignaturas disponibles para inscribir")) 
        		{
        			break;
        		}
        		System.out.println("ingrese el codigo de la asignatura que desea inscribir: ");
        		boolean repetir2 = true;
        		int opcion2 = -1;
        		int opcion3 = -1;
        		while(repetir2) 
        		{
        			try {
        				opcion2 = entrada.nextInt();
        				System.out.println("ingrese el paralelo: ");
        				opcion3 = entrada.nextInt();
        				repetir2 = false;
        				
        			}catch(Exception e) {
        				System.out.println("codigo o paralelo  mal ingresado");
        				entrada.nextLine();
        			}
        		}
        		String auxOpcion2 = Integer.toString(opcion2);
        		String auxOpcion3 = Integer.toString(opcion3);

        		boolean inscribirAsig = s.inscribirAsignaturas(auxOpcion2,correo,auxOpcion3);
        		if(inscribirAsig) 
        		{
        			System.out.println("se ha inscrito en el paralelo "+auxOpcion3+" de la asignatura: "+auxOpcion2);
        		}else {
        			System.out.println("no ha podido inscribir el paralelo "+auxOpcion3+" de la asignatura: "+auxOpcion2);

        		}
        		break;
        	case 2:
        		System.out.println("se eligio eliminar Asignatura");        		
        		String disponibles2 = s.obtenerAsignaturasInscritas(correo);
        		if(disponibles2.equalsIgnoreCase("")) 
        		{
        			System.out.println("usted no tiene asignaturas inscritas");
        			break;
        		}else {
        			System.out.println("asignaturas inscritas:");
        			System.out.println(disponibles2);
        		}
        		System.out.println("ingrese el codigo de la asignatura que desea eliminar: ");
        		boolean repetir3 = true;
        		int opcion4 = -1;
        		while(repetir3) 
        		{
        			try {
        				opcion4 = entrada.nextInt();
        				repetir3 = false;
        			}catch(Exception e){
        				System.out.println("codigo mal ingresado");
        				entrada.nextLine();
        			}
        		}
        		String auxOpcion4 = Integer.toString(opcion4);
        		boolean eliminarAsig = s.eliminarAsignatura(correo,auxOpcion4);
        		if(eliminarAsig) 
        		{
        			System.out.println("se a eliminado la asignatura perteneciente al codigo: "+auxOpcion4);
        		}else {
        			System.out.println("no se a podido eliminar la asignatura "+auxOpcion4);
        		}
        		break;
        	}
        	System.out.println("1)Inscripcion Asignatura\n2)Eliminar Asignatura\n3)Salir");
			opcion = -1;
			repetir = true;
			while(repetir)//controla que el dato ingresado sea un int
			{
				try 
				{
					opcion = entrada.nextInt();
					repetir = false;
				}catch(Exception e){
					System.out.println("dato mal ingresado,intente nuevamente");
	        		System.out.println("ingrese una opcion\n1)iniciar sesion \n2)cerrar");
	        		entrada.nextLine();
				}
			}
        }
		
	}
	private static int definirPeriodo(int dia, int mes, int anio) {
		if(anio != 2021) 
		{
			System.out.println("feliz vacaciones");
			return -1;
		}
		if(mes<=2 || mes >=8) 
		{
			//no hay acciones disponibles
			System.out.println("feliz vacaciones");
			return -1;
		}
		if(mes == 4) 
		{
			//inicio semestre
			System.out.println("inicio semestre");
			return 1;
		}
		if(mes ==6) 
		{
			//mitad semestre
			System.out.println("mitad semestre");
			return 2;
		}
		if(mes == 5 ) 
		{
			if(dia >= 3) 
			{
				//mitad semestre
				System.out.println("mitad semestre");
				return 2;
			}else {
				//inicio semestre
				System.out.println("inicio semestre");
				return 1;
			}
		}
		if(mes == 7) 
		{
			if(dia<=11) 
			{
				//mitad semestre
				System.out.println("mitad semestre");
				return 2;
			}
			if(dia >=12 && dia<=25) {
				//final semestre
				System.out.println("final semestre");
				return 3;
			}
			if(dia == 26) 
			{
				System.out.println("cierre sistema");
				return 4;
			}
			if(dia >26) 
			{
				System.out.println("feliz vacaciones");
				return -1;
			}
		}
		if(mes == 3) 
		{
			if(dia >=8) 
			{
				//inicio semestre
				System.out.println("inicio semestre");
				return 1;
			}else {
				System.out.println("feliz vacaciones");
				return -1;
			}
		}
		return 0;
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
