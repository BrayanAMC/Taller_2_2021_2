package dominio;

import logica.ListaAsignaturas;

public class Profesor {

	private String rut;
	private String correo;
	private String contrasena;
	private int salario;
	private ListaAsignaturas lista;
	
	public Profesor(String rut,String correo,String contrasena,int salario)
	{
		this.rut = rut;
		this.correo = correo;
		this.contrasena = contrasena;
		this.salario = salario;
		lista = new ListaAsignaturas(10);
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
		this.correo = c;
	}
	public String getContrasena() 
	{
		return contrasena;
	}
	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	public int getSalario() 
	{
		return salario;
	}
	public void setSalario(int salario) 
	{
		this.salario = salario;
	}
	
	public ListaAsignaturas getListaAsignaturas() 
	{
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
