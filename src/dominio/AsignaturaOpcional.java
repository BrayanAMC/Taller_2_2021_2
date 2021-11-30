package dominio;

public class AsignaturaOpcional extends Asignatura{

	private int creditosPre;
	public AsignaturaOpcional(String codigo,String nombre,int creditos,String tipo,int creditosPre)
	{
		super(codigo,nombre,creditos,tipo);
		this.creditosPre = creditosPre;
	}
	public int getCreditosPre() {
		return creditosPre;
	}
	public void setCreditosPre(int creditosPre) {
		this.creditosPre = creditosPre;
	}
	
}
