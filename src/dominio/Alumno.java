package dominio;

import logica.ListaAsignaturas;

public class Alumno {

	private String rut;
	private String correo;
	private int nivel;
	private String contrasena;
	private ListaAsignaturas lista;
	
	public Alumno(String rut,String correo,int nivel,String contrasena) 
	{
		this.rut = rut;
		this.correo = correo;
		this.nivel = nivel;
		this.contrasena = contrasena;
		lista = new ListaAsignaturas(999);
	}
	
	public String getRut() 
	{
		return rut;
	} 
	public void setRut(String rut) 
	{
		this.rut = rut;
	}
	public String getCorreo() 
	{
		return correo;
	}
	public void setCorreo(String c) 
	{
		correo = c;
	}
	public int getNivel() 
	{
		return nivel;
	}
	public void setNivel(int nivel) 
	{
		this.nivel = nivel;
	}
	public String getContrasena()
	{
		return contrasena;
	}
	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	
	public ListaAsignaturas getListaAsignatura() 
	{
		return lista;
	}
	
}
