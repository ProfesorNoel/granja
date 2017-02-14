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
	 *  Constructor sin par�metros
	 */
	public Animal() 
	{
		super();
		System.out.println("Invocando constructor de la clase " 
				+ Animal.class.getSimpleName() + " sin par�metros");
	}
	
	/**
	 * M�todo gen�rico para indicar que un animal est� comiendo
	 */
	public void comer()
	{
		System.out.println("Soy un animal de tipo " 
				+ this.getClass().getSimpleName() + " y estoy comiendo...");
	}
	
	/**
	 * M�todo gen�rico para indicar que un animal est� durmindo
	 */
	public void dormir()
	{
		System.out.println("Soy un animal de tipo " 
				+ this.getClass().getSimpleName() + " y estoy comiendo...");
	}
	
}
