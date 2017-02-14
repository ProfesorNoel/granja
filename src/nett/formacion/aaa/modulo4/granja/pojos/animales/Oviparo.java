/**
 * 
 */
package nett.formacion.aaa.modulo4.granja.pojos.animales;

import nett.formacion.aaa.modulo4.granja.pojos.animales.productos.Huevo;

/**
 * @author Noel
 *
 */
public interface Oviparo 
{
	public void ponerHuevos();
	public Huevo [] recogerHuevos();
	public Huevo [] recogerHuevos(int numeroHuevos);
}
