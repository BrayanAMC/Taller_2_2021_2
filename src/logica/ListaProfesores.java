package logica;

import dominio.Asignatura;
import dominio.Profesor;

public class ListaProfesores {

	private int max;
	private int cant;
	private Profesor [] lista;

	public ListaProfesores(int max) 
	{
		this.cant = 0;
		this.max = max;
		lista = new Profesor[max];
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Profesor[] getLista() {
		return lista;
	}
	public boolean ingresarProfesor(Profesor p) 
	{
		if(cant < max) {
			lista[cant] = p;
			cant++;
			return true;
		}
		return false;
		
	}
	public Profesor buscarProfesorI(int i) 
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
	public Profesor buscarProfesorRut(String rut) 
	{
		for (int i = 0; i < cant; i++) {
			if(lista[i].getRut().equalsIgnoreCase(rut))
			{
				return lista[i];
			}
		}
		return null;
	}
	
}
