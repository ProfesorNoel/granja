/**
 * 
 */
package nett.formacion.aaa.modulo4.granja;

import nett.formacion.aaa.modulo4.granja.pojos.Granja;
import nett.formacion.aaa.modulo4.granja.pojos.Granjero;

/**
 * Clase que arranca la ejecuci�n del programa
 * 
 * @author Noel
 *
 */
public class AppGranja {

	/**
	 * Constructor �nico sin par�metros
	 * 
	 * ( No es necesario indicarlo porque al no 
	 *  ponerlo Java proveer�a uno, pero no es mala
	 *  practica el indicarlo espec�ficamente ) 
	 */
	public AppGranja() {
		//Llamada a super ( tampoco es necesaria )
		super();
	}

	/**
	 * M�todo est�tico de arranque
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* A trav�s del constructor se crea 
		 * un granjero llamado Donald y se le 
		 * asigna tambi�n mediante constructor una Granja
		 */
		Granjero granjero = new Granjero ("Donald", new Granja());
		
		/* Se invoca al m�todo de granjero getGranja 
		 * que recupera la granja asociada al granjero y
		 * se invoca al evento nuevo d�a
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
