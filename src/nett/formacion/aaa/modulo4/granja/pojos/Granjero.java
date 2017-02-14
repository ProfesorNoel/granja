package nett.formacion.aaa.modulo4.granja.pojos;

import nett.formacion.aaa.modulo4.granja.pojos.animales.Animal;
import nett.formacion.aaa.modulo4.granja.pojos.animales.Oviparo;
import nett.formacion.aaa.modulo4.granja.pojos.animales.productos.Huevo;

/**
 * Clase Granjero
 * 
 * @author Noel
 *
 */
public class Granjero {
	
	//Atributo nombre
	private String nombre;
	//Atributo granja
	private Granja granja;
	
	//Número de huevos totales recogidos
	private Integer numeroHuevos = 0;
	//Número de huevos de dos yemas recogidos
	private Integer numeroHuevosDosYemas = 0;
	//Número de huevos de tres yemas recogidos
	private Integer numeroHuevosTresYemas = 0;
	
	/**
	 * Constructor de un parámetro
	 * Construye un granjero dando un nombre.
	 * 
	 * @param nombre, nombre del granjero
	 */
	public Granjero (String nombre)
	{
		this.nombre = nombre;
	}
	
	/**
	 * Construcotr de dos parámetros.
	 * Construye un granjero asignándole un nombre 
	 * y también una granja
	 * 
	 * @param nombre, nombre del granjero
	 * @param granja, granja asignada
	 */
	public Granjero (String nombre, Granja granja)
	{
		this(nombre);
		this.granja = granja;
	}
	
	/**
	 * Método getter para recuperar la granja asignada al granjero.
	 * 
	 * @return Granja, asignada al granjero.
	 */
	public Granja getGranja() 
	{
		return granja;
	}

	/**
	 * Método setter, para asignarle una granja al granjero.
	 * 
	 * @param granja, granja que se asignará al granjero.
	 */
	public void setGranja(Granja granja) 
	{
		this.granja = granja;
	}
	
	/**
	 * Método getter para recuperar el nombre del granjero.
	 * 
	 * @return nombre, nombre del granjero.
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * Método setter, para asignarle un nombre al granjero.
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * Tarea que realiza el granjero, mediante la cual 
	 * da alimento a todos los animales the su granja.
	 */
	public void alimentarAnimales()
	{
		//Se comprueba si la granja está instanciada y si tiene animales
		if (this.granja != null && granja.getAnimales().length > 0)
		{
			//Se recuperan los animales de la granja 
			Animal [] animales = this.granja.getAnimales();
			
			// Por cada animal se invoca a su método comer
			for (Animal animal : animales)
			{
				animal.comer();
			}
		}
	}
	
	/**
	 * Tarea que realiza el granjero para recoger los huevos de su granja.
	 */
	public void recogerHuevos()
	{
		//Se comprueba si la granja está instanciada y si tiene animales
		if (this.granja != null && granja.getAnimales().length > 0)
		{
			//Se recuperan los animales de la granja 
			Animal [] animales = this.granja.getAnimales();
			
			//Se recorren los animales de la granja
			for (Animal animal : animales)
			{
				/* Se comprueba si el animal implementa la interfaz Oviparo,
				 * ya que solo los animales que implmentan esta interfaz 
				 * pueden poner huevos.
				 */
				if (animal instanceof Oviparo)
				{
					/* Se realiza un casting explícito a Ovíparo utiliando 
					 * el polimorfismo de Java y se invoca al método 
					 * recogerHuevos que nos devuelve un array de huevos 
					 */
					Huevo [] huevos = ((Oviparo) animal).recogerHuevos();
					
					// Se comprueba si el array de huevos tiene elementos
					if (huevos != null && huevos.length > 0)
					{
						//Por cada huevo...
						for (Huevo huevo: huevos)
						{
							//Se incrementa el contador de huevos recogidos en una unidad
							this.numeroHuevos++;
							
							/*
							 * Consultamos si el huevo es de dos yemas 
							 * a través del método getter getYemas
							 */
							if(huevo.getYemas() == 2)
							{
								//Incrementamos el contados de huevos de 2 yemas en una unidad
								this.numeroHuevosDosYemas++;
							}// Si no es de yemas consultamos si es de 3
							else if (huevo.getYemas() == 3)
							{
								//Incrementamos el contados de huevos de 3 yemas en una unidad
								this.numeroHuevosTresYemas++;
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Tarea que realiza el granjero para contar sus huevos.
	 * Cuenta el número total, así como cuantos son 
	 * de 2 yemas y cuantos de 3 yemas.
	 */
	public void contarHuevos()
	{
		System.out.println("Tengo en total: " + this.numeroHuevos + " huevos");
		System.out.println("Entre los cuales  " + this.numeroHuevosDosYemas + " son de 2 yemas y " + this.numeroHuevosTresYemas + " son de 3 yemas");
	}
}
