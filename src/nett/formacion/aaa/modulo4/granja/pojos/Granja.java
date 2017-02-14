package nett.formacion.aaa.modulo4.granja.pojos;

import nett.formacion.aaa.modulo4.granja.pojos.animales.Animal;
import nett.formacion.aaa.modulo4.granja.pojos.animales.Conejo;
import nett.formacion.aaa.modulo4.granja.pojos.animales.Gallina;
import nett.formacion.aaa.modulo4.granja.pojos.animales.Oviparo;
import nett.formacion.aaa.modulo4.granja.pojos.animales.Palomo;

/**
 * Clase Granja
 * 
 * @author Noel
 *
 */
public class Granja {

	//Numero de gallinas de la granja
	public final static Integer NUMERO_GALLINAS = 5;
	//Numero de palomos de la granja
	public final static Integer NUMERO_PALOMOS = 12;
	//Numero de conejos de la granja
	public final static Integer NUMERO_CONEJOS = 8;
	
	//Atributo que representa los animales que hay en la granja
	private  Animal [] animales;
	
	/**
	 * Constructor sin argumentos de Granja
	 * 
	 * Se encarga de crear una granja con un numero 
	 * predeterminado de cata tipo de animal.
	 */
	public Granja() 
	{
		System.out.println("Construyendo la Granja...");
		
		//Animales totales
		Integer numeroAnimales = Granja.NUMERO_CONEJOS + Granja.NUMERO_GALLINAS + Granja.NUMERO_PALOMOS;
		
		//Se instancia el array de animales
		animales = new Animal[numeroAnimales];
		
		//indice para bucles
		int indice = 0;
		//indice para array de animales creados
		int animalesCreados = 0;
		
		//Creamos las gallinas y las agregamos al array de animales
		for (indice = 0; indice < Granja.NUMERO_GALLINAS; indice++)
		{
			//Uso de polimorfismo
			animales[animalesCreados] = new Gallina(); 
			//Se incrementa el contador de animales creados
			animalesCreados++;
		}
		
		//Se resetea el indice de bucles para crear los conejos
		indice = 0;
		
		for (indice = 0; indice < Granja.NUMERO_CONEJOS; indice++)
		{
			//Uso de polimorfismo
			animales[animalesCreados] = new Conejo();
			//Se incrementa el contador de animales creados
			animalesCreados++;
		}
		
		//Se resetea el indice de bucles para crear los palomos
		indice = 0;
		
		for (indice = 0; indice < Granja.NUMERO_PALOMOS; indice++)
		{
			//Uso de polimorfismo
			animales[animalesCreados] = new Palomo();
			//Se incrementa el contador de animales creados
			animalesCreados++;
		}
	}
	
	/**
	 * Metodo getter para recuperar los animales
	 * @return animales en forma de array Animal []
	 */
	public Animal [] getAnimales()
	{
		return this.animales;
	}
	
	/**
	 * Evento nuevo dia por el que todos los animales ovíparos ponen huevos
	 */
	public void nuevoDia ()
	{
		//Se recorre el array de animales
		for (int indice = 0; indice < this.animales.length; indice++)
		{
			//Se recupera un animal
			Animal animal = this.animales[indice];
			
			//Se comprueba si es una instancia de Oviparo ( polimorfismo )
			if (animal instanceof Oviparo)
			{
				//Se hace un casting específico y se invoca al método ponerHuevos()
				((Oviparo)animal).ponerHuevos();
			}
		}
	}
}
