package nett.formacion.aaa.modulo4.granja.pojos.animales.productos;

public class Huevo {

	private Integer yemas = 1;
	
	public Huevo() 
	{
		super();
		System.out.println("Invocando constructor de la clase " + Huevo.class + " sin parámetros");
	}
	
	public Huevo(Integer yemas) 
	{
		super();
		this.yemas = yemas;
		System.out.println("Creando huevo con #" + yemas + " yema(s)");
	}

	public Integer getYemas() {
		return yemas;
	}

	public void setYemas(Integer yemas) {
		this.yemas = yemas;
	}
}
