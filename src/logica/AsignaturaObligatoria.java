package logica;

import dominio.Asignatura;

public class AsignaturaObligatoria extends Asignatura {

	private int nivel;
	private int cantPre;
	private String[] listaPre;
	private int posicionListaPre;
	
	public AsignaturaObligatoria(String codigo,String nombre,int creditos,String tipo,int nivel,int cantPre)
	{
		super(codigo,nombre,creditos,tipo);
		this.nivel = nivel;
		this.cantPre = cantPre;
		listaPre = new String[cantPre];
		posicionListaPre = 0;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getCantPre() {
		return cantPre;
	}

	public void setCantPre(int cantPre) {
		this.cantPre = cantPre;
	}

	public String[] getListaPre() {
		return listaPre;
	}
	public void ingresarListaPre(String codigoPre) 
	{
		listaPre[posicionListaPre] = codigoPre;
		posicionListaPre++;
	}
	public String obtenerCodigoAsigPre(int i) 
	{
		if(i<cantPre) {
			return listaPre[i];
		}	
		else {
			return "hola";
		}
	}
	
	
}
