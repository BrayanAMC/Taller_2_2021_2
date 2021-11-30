package logica;

import dominio.Asignatura;

public class AsignaturaObligatoria extends Asignatura {

	private int nivel;
	private int cantPre;
	private ListaAsignaturas listaPre;
	
	public AsignaturaObligatoria(String codigo,String nombre,int creditos,String tipo,int nivel,int cantPre)
	{
		super(codigo,nombre,creditos,tipo);
		this.nivel = nivel;
		this.cantPre = cantPre;
		listaPre = new ListaAsignaturas(999);
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

	public ListaAsignaturas getListaPre() {
		return listaPre;
	}
	
	
}
