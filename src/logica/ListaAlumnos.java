package logica;

import dominio.Alumno;

public class ListaAlumnos {

	private int max;
	private int cant;
	private Alumno [] lista;
	
	public ListaAlumnos(int max) 
	{
		this.cant = 0;
		this.max = max;
		lista = new Alumno[max];
	}
	public int getMax() 
	{
		return max;
	}
	public void setMax(int max) 
	{
		this.max = max;
	}
	public int getCant() 
	{
		return cant;
	}
	public void setCant(int cant) 
	{
		this.cant = cant;
	}
	public Alumno[] getListaAlumnos() 
	{
		return lista;
	}
	public boolean agregarAlumno(Alumno a) 
	{
		if(cant<max) 
		{
			lista[cant] = a;
			cant++;
			return true;
		}
		return false;
	}	
	public Alumno buscarAlumnoI(int i) 
	{
		if(i <= cant) 
		{
			return lista[i];
		}
		else 
		{
			return null;
		}
	}
	public Alumno buscarAlumnoRut(String rut) 
	{
		for (int i = 0; i < cant; i++) {
			if(lista[i].getRut().equalsIgnoreCase(rut))
			{
				return lista[i];
				
			}
		}
		return null;
	}
	public Alumno buscarAlumnoCorreo(String correo) 
	{
		for (int i = 0; i < cant; i++) {
			if(lista[i].getCorreo().equalsIgnoreCase(correo))
			{
				return lista[i];
				
			}
		}
		return null;
	}
	
	
	
	
	
	
}