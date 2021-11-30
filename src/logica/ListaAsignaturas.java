package logica;

import dominio.Alumno;
import dominio.Asignatura;

public class ListaAsignaturas {

	private int max;
	private int cant;
	private Asignatura [] lista;
	
	public ListaAsignaturas(int max) 
	{
		this.cant = 0;
		this.max = max;
		lista = new Asignatura[max];
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
	public Asignatura[] getListaAsignatura() 
	{
		return lista;
	}
	public boolean ingresarAsignatura(Asignatura a) 
	{
		if(cant < max) {
			lista[cant] = a;
			cant++;
			return true;
		}
		return false;
	}
	public Asignatura buscarAsignaturaI(int i) 
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
	public Asignatura buscarAsignaturaCode(String code) 
	{
		for (int i = 0; i < cant; i++) {
			if(lista[i].getCodigo().equalsIgnoreCase(code))
			{
				return lista[i];
			}
		}
		return null;
	}
	public boolean elimianarAsignatura(String code) 
	{
		
	    int i = 0;
        while(i<cant && !lista[i].getCodigo().equalsIgnoreCase(code)) {
            i++;
        }
        if(i==cant) {
            return false;
        }
        else {
            for(int j=i;j<cant-1;j++) {
                lista[j] = lista[j+1];
            }
            cant--;
            return true;
        }
	}
	
	
	
	
	
	
	
	
	
	

}
