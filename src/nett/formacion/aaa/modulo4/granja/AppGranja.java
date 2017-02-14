/**
 * 
 */
package nett.formacion.aaa.modulo4.granja;

import nett.formacion.aaa.modulo4.granja.pojos.Granja;
import nett.formacion.aaa.modulo4.granja.pojos.Granjero;

/**
 * Clase que arranca la ejecución del programa
 * 
 * @author Noel
 *
 */
public class AppGranja {

	/**
	 * Constructor único sin parámetros
	 * 
	 * ( No es necesario indicarlo porque al no 
	 *  ponerlo Java proveería uno, pero no es mala
	 *  practica el indicarlo específicamente ) 
	 */
	public AppGranja() {
		//Llamada a super ( tampoco es necesaria )
		super();
	}

	/**
	 * Método estático de arranque
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* A través del constructor se crea 
		 * un granjero llamado Donald y se le 
		 * asigna también mediante constructor una Granja
		 */
		Granjero granjero = new Granjero ("Donald", new Granja());
		
		/* Se invoca al método de granjero getGranja 
		 * que recupera la granja asociada al granjero y
		 * se invoca al evento nuevo día
		 */
		granjero.getGranja().nuevoDia();
		
		// El granjero realiza su tarea de alimentar animales
		granjero.alimentarAnimales();
		
		// El granjero realiza su tarea de recoger huevos
		granjero.recogerHuevos();
		
		// El granjero realiza su tarea de contar huevos
		granjero.contarHuevos();
	}
}
