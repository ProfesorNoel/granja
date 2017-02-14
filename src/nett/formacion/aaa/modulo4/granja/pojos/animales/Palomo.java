/**
 * 
 */
package nett.formacion.aaa.modulo4.granja.pojos.animales;

import java.util.Random;
import java.util.UUID;

import nett.formacion.aaa.modulo4.granja.pojos.animales.productos.Huevo;

/**
 * Clase Palomo que extiende de Animal e implementa la interfaz Oviparo
 * 
 * @author Noel
 *
 */
public class Palomo extends Animal implements Oviparo {

	private Integer numeroHuevos = 0;
	private final static Integer NUMERO_MAXIMO_HUEVOS_DIA = 4;
	private final static Integer PROBABILIDAD_DOS_YEMAS = 2;
	private final static Integer PROBABILIDAD_TRES_YEMAS = 1;
	
	/**
	 * Constructor sin par�metros 
	 */
	public Palomo() 
	{
		System.out.println("Creando Palomo...");
	}
	
	/**
	 * M�todo encargado de generar huevos
	 * Implementaci�n del m�todo ponerHuevos() 
	 * del contrato Oviparo para un Palomo.
	 */
	@Override
	public void ponerHuevos() 
	{	
		/*
		 * Se incrementa el n�mero de huevos bas�ndonos en un numero aleatorio entre
		 * 0 y el numero m�ximo de huevos que puede poner un palomo.
		 * 
		 * UUID.randomUUID().getMostSignificantBits() es para generar
		 * una semilla y que la secuencia sea realmente aleatoria.
		 */
		this.numeroHuevos += new Random(UUID.randomUUID().getMostSignificantBits())
								.nextInt(Palomo.NUMERO_MAXIMO_HUEVOS_DIA);
		
		//Mensaje que imprime por pantalla los huevos que la gallina ha puesto
		System.out.println(this.getClass().getSimpleName() + " poniendo " + 
								this.numeroHuevos + " huevo(s)");
	}
	
	/**
	 * M�todo encargado de recoger huevos
	 * Implementaci�n del m�todo recogerHuevos() 
	 * del contrato Oviparo para un Palomo
	 */
	@Override
	public Huevo[] recogerHuevos() 
	{
		//Define el array de huevos a devolver
		Huevo [] huevos = null;
		
		//Comprobamos si el palomo tiene huevos
		if(this.numeroHuevos > 0)
		{
			//Creamos el array de huevos
			huevos = new Huevo [this.numeroHuevos];
			
			/* 
			 * Por cada huevo creado instanciamos un huevo y
			 * lo agregamos al array de huevos.
			 */
			for (int i = 0; i < this.numeroHuevos; i++)
			{
				/*
				 * Creaci�n de una instancia de huevo utilizando 
				 * el constructor de un par�metro al que le pasamos 
				 * el n�mero de yemas.
				 * 
				 * El n�mero de yemas se consigue a trav�s del
				 * metod privado numeroYemas()
				 */
				Huevo huevo = new Huevo(this.numeroYemas());
				
				/*
				 * Agregamos el huevo al array en la posici�n 
				 * determinada por �ndice i
				 */
				huevos[i] = huevo;
			}
			
			/*
			 * Como todos los huevos son entregados 
			 * se restablece a 0 el contador de huevos de la Gallina
			 */
			this.numeroHuevos = 0;
		}
		
		//Devolvemos el array de huevos (Huevo[])
		return huevos;
	}
	
	/**
	 * Metodo para recoger un n�mero determinado de huevos.
	 * 
	 * Si no hay suficientes huevos no recoge ninguno.
	 */
	@Override
	public Huevo[] recogerHuevos(int numeroHuevos) {
		
		//Define el array de huevos a devolver
		Huevo [] huevos = null;
		
		//Comprueba que hay suficientes huevos para servir
		if (numeroHuevos <= this.numeroHuevos)
		{
			/*
			 * Crea un array de huevos del tama�o especificado
			 * por el par�metro del m�todo numeroHuevos 
			 */
			huevos =  new Huevo [numeroHuevos];
			
			//Por cada unidad creamos un huevo
			for (int i = 0; i < numeroHuevos; i++)
			{
				/*
				 * Creaci�n de una instancia de huevo utilizando 
				 * el constructor de un par�metro al que le pasamos 
				 * el n�mero de yemas.
				 * 
				 * El n�mero de yemas se consigue a trav�s del
				 * metodo privado numeroYemas()
				 */
				Huevo huevo = new Huevo(this.numeroYemas());
				
				/*
				 * Agregamos el huevo al array en la posici�n 
				 * determinada por �ndice i
				 */
				huevos[i] = huevo;
			}
			
			//Restamos a la gallina el n�mero de huevos extra�do.
			this.numeroHuevos -= numeroHuevos;
		}
		
		//Devolvemos el array de huevos (Huevo[])
		return huevos;
	}
	
	/*
	 * M�todo para crear aleatoriamente el n�mero de yemas de un huevo
	 */
	private Integer numeroYemas()
	{
		//Creamos un n�mero entero aleatorio entre 0 y 99
		Integer yemas = new Random(UUID.randomUUID().getMostSignificantBits())
				.nextInt(100);
		
		/*
		 * Si el numero generado es menor 
		 * que la probabilidad m�s baja
		 * devolvemos 3 yemas
		 */
		if (yemas < Palomo.PROBABILIDAD_TRES_YEMAS)
		{
			return 3;
		}
		/*
		 * Si el numero generado es menor 
		 * que la probabilidad asigana a las dos yemas
		 * devolvemos 2 yemas
		 */
		else if(yemas < Palomo.PROBABILIDAD_DOS_YEMAS)
		{
			return 2;
		}
		//sino devolvemos una yema
		else
		{
			return 1;
		}
	}
}
