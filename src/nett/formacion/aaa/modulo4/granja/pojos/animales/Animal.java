/**
 * 
 */
package nett.formacion.aaa.modulo4.granja.pojos.animales;

/**
 * Calse Abstracta Animal
 * @author Noel
 *
 */
public abstract class Animal {

	/**
	 *  Constructor sin parámetros
	 */
	public Animal() 
	{
		super();
		System.out.println("Invocando constructor de la clase " 
				+ Animal.class.getSimpleName() + " sin parámetros");
	}
	
	/**
	 * Método genérico para indicar que un animal está comiendo
	 */
	public void comer()
	{
		System.out.println("Soy un animal de tipo " 
				+ this.getClass().getSimpleName() + " y estoy comiendo...");
	}
	
	/**
	 * Método genérico para indicar que un animal está durmindo
	 */
	public void dormir()
	{
		System.out.println("Soy un animal de tipo " 
				+ this.getClass().getSimpleName() + " y estoy comiendo...");
	}
	
}
