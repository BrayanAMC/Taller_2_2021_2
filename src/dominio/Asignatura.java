package dominio;
import logica.ListaAlumnos;
public class Asignatura {

	private String codigo;
	private String nombre;
	private int creditos;
	private String tipo;
	private Profesor profesor;
	private ListaAlumnos lista;
	private String[] paralelo;
	private int contadorParalelo;
	private double notaFinal; //si es 0 significa que es una asignatura inscrita , de lo contrario
				              //es una asignatura cursada
	
	public Asignatura(String codigo,String nombre,int creditos,String tipo)
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.tipo = tipo;
		lista = new ListaAlumnos(100);
		profesor = null;
		paralelo = new String[20];
		notaFinal = 0;
		contadorParalelo = 0;
	}
	public boolean ingresarAlumno(Alumno a) 
	{
		return lista.agregarAlumno(a);
	}

	public String getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String n) 
	{
		nombre = n;
	}
	public int getCreditos() 
	{
		return creditos;
	}
	public void setCreditos(int creditos)
	{
		this.creditos = creditos;
	} 
	public String getTipo() 
	{
		return tipo;
	}
	public Profesor getProfesor() 
	{
		return profesor;
	}
	public ListaAlumnos getListaAlumnos() 
	{
		return lista;
	}
	public void ingresarParalelo(String paraleloNuevo) {
		if(contadorParalelo<paralelo.length) {
			paralelo[contadorParalelo] = paraleloNuevo;
			contadorParalelo++;
		}
	}
	public String getParalelos() 
	{
		String out = " ";
		for (int i = 0; i < contadorParalelo; i++) {
			out+= paralelo[i]+" ";
		}
		return out;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public boolean setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
		return true;
	}
	public String getParaleloUnico() 
	{
		return paralelo[0];
	}
	
	
	
	
	
}
