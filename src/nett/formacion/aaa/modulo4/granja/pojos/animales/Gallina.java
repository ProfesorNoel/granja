/**
 * 
 */
package nett.formacion.aaa.modulo4.granja.pojos.animales;

import nett.formacion.aaa.modulo4.granja.pojos.animales.productos.Huevo;
import java.util.Random;
import java.util.UUID;

/**
 * Clase Gallina que extiende de Animal e implementa la interfaz Oviparo
 * 
 * @author Noel
 *
 */
public class Gallina extends Animal implements Oviparo {

	private Integer numeroHuevos = 0;
	
	//Numero m�ximo de huevos que una gallina puede poner al d�a
	private final static Integer NUMERO_MAXIMO_HUEVOS_DIA = 2;
	//Probabilidad de poner huevos de 2 yemas
	private final static Integer PROBABILIDAD_DOS_YEMAS = 10;
	//Probabilidad de poner huevos de 3 yemas
	private final static Integer PROBABILIDAD_TRES_YEMAS = 3;
	
	//Atributo de color de la Gallina
	private Color color = Color.BLANCA;
	
	/**
	 * Constructor sin par�metros 
	 */
	public Gallina() 
	{
		System.out.println("Creando Gallina...");
	}
	
	/**
	 * Constructor de un par�metro especificando el color de la Gallina
	 * 
	 * @param color, tipo enumerado que representa el color de la gallina
	 */
	public Gallina(Color color) 
	{
		System.out.println("Creando Gallina... de color: " + color.value);
		this.color = color;
	}

	/**
	 * M�todo encargado de generar huevos
	 * Implementaci�n del m�todo ponerHuevos() 
	 * del contrato Oviparo, para una Gallina
	 */
	@Override
	public void ponerHuevos() 
	{	
		
		/*
		 * Se incrementa el n�mero de huevos bas�ndonos en un numero aleatorio entre
		 * 0 y el numero m�ximo de huevos que puede poner una gallina.
		 * 
		 * UUID.randomUUID().getMostSignificantBits() es para generar
		 * una semilla y que la secuencia sea realmente aleatoria.
		 */
		this.numeroHuevos += new Random(UUID.randomUUID().
									getMostSignificantBits()).
										nextInt(Gallina.NUMERO_MAXIMO_HUEVOS_DIA + 1);
		
		//Mensaje que imprime por pantalla los huevos que la gallina ha puesto
		System.out.println(this.getClass().getSimpleName() + " poniendo " 
						+ this.numeroHuevos + " huevo(s)");
	}
	
	/**
	 * M�todo encargado de recoger huevos
	 * Implementaci�n del m�todo recogerHuevos() del contrato Oviparo
	 */
	@Override
	public Huevo[] recogerHuevos() 
	{
		//Define el array de huevos a devolver
		Huevo [] huevos = null;
		
		//Comprobamos si la gallina tiene huevos
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
		if (yemas < Gallina.PROBABILIDAD_TRES_YEMAS)
		{
			return 3;
		}
		/*
		 * Si el numero generado es menor 
		 * que la probabilidad asigana a las dos yemas
		 * devolvemos 2 yemas
		 */
		else if(yemas < Gallina.PROBABILIDAD_DOS_YEMAS)
		{
			return 2;
		}
		//sino devolvemos una yema
		else
		{
			return 1;
		}
	}
	
	/**
	 * Devuelve el color de la Gallina
	 * @return Color
	 */
	public Color getColor() 
	{
		return color;
	}
	
	/**
	 * 
	 * Tipo Enumerado para el color de una Gallina
	 * Los tipos de colores pueden ser:
	 * 
	 * MARRON, ROJA, BLANCA y NEGRA.
	 * 
	 * @author mamoghli
	 *
	 */
	public enum Color
	{
		MARRON ("MARRON"),
		ROJA ("ROJA"),
		BLANCA ("BLANCA"), 
		NEGRA ("NEGRA");
		
		//Guardamos el valor en formato String
		private String value;
		
		//Permite crear un Color desde una cadena
		Color(String value)
		{
			this.value = value;
		}
		
		//Devuelve el color en formato String
		public String getValue()
		{
			return this.value;
		}
		
		/*
		 * Devuelve de forma est�tica el tipo enumerado 
		 * correspondiente a un color, 
		 * sino es un color de la lista devuelve un valor nulo.
		 */
		public static Color get(String internalValue)
		{
			for(Color enumValue : Color.values())
			{
				if(enumValue.getValue().equalsIgnoreCase(internalValue))
				{
					return enumValue;
				}
			}
			
			return null;
		}
	}
}
