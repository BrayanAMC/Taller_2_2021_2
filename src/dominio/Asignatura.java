package dominio;
import logica.ListaAlumnos;
public class Asignatura {

	private String codigo;
	private String nombre;
	private int creditos;
	private String tipo;
	private Profesor profesor;
	private ListaAlumnos lista;
	private String paralelo;
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
		paralelo = null;
		notaFinal = 0;
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
	public String getParalelo() {
		return paralelo;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	
	
	
	
}
