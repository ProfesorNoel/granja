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
	
	//Numero máximo de huevos que una gallina puede poner al día
	private final static Integer NUMERO_MAXIMO_HUEVOS_DIA = 2;
	//Probabilidad de poner huevos de 2 yemas
	private final static Integer PROBABILIDAD_DOS_YEMAS = 10;
	//Probabilidad de poner huevos de 3 yemas
	private final static Integer PROBABILIDAD_TRES_YEMAS = 3;
	
	//Atributo de color de la Gallina
	private Color color = Color.BLANCA;
	
	/**
	 * Constructor sin parámetros 
	 */
	public Gallina() 
	{
		System.out.println("Creando Gallina...");
	}
	
	/**
	 * Constructor de un parámetro especificando el color de la Gallina
	 * 
	 * @param color, tipo enumerado que representa el color de la gallina
	 */
	public Gallina(Color color) 
	{
		System.out.println("Creando Gallina... de color: " + color.value);
		this.color = color;
	}

	/**
	 * Método encargado de generar huevos
	 * Implementación del método ponerHuevos() 
	 * del contrato Oviparo, para una Gallina
	 */
	@Override
	public void ponerHuevos() 
	{	
		
		/*
		 * Se incrementa el número de huevos basándonos en un numero aleatorio entre
		 * 0 y el numero máximo de huevos que puede poner una gallina.
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
	 * Método encargado de recoger huevos
	 * Implementación del método recogerHuevos() del contrato Oviparo
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
				 * Creación de una instancia de huevo utilizando 
				 * el constructor de un parámetro al que le pasamos 
				 * el número de yemas.
				 * 
				 * El número de yemas se consigue a través del
				 * metod privado numeroYemas()
				 */
				Huevo huevo = new Huevo(this.numeroYemas());
				
				/*
				 * Agregamos el huevo al array en la posición 
				 * determinada por índice i
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
	 * Metodo para recoger un número determinado de huevos.
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
			 * Crea un array de huevos del tamaño especificado
			 * por el parámetro del método numeroHuevos 
			 */
			huevos =  new Huevo [numeroHuevos];
			
			//Por cada unidad creamos un huevo
			for (int i = 0; i < numeroHuevos; i++)
			{
				/*
				 * Creación de una instancia de huevo utilizando 
				 * el constructor de un parámetro al que le pasamos 
				 * el número de yemas.
				 * 
				 * El número de yemas se consigue a través del
				 * metodo privado numeroYemas()
				 */
				Huevo huevo = new Huevo(this.numeroYemas());
				
				/*
				 * Agregamos el huevo al array en la posición 
				 * determinada por índice i
				 */
				huevos[i] = huevo;
			}
			
			//Restamos a la gallina el número de huevos extraído.
			this.numeroHuevos -= numeroHuevos;
		}
		
		//Devolvemos el array de huevos (Huevo[])
		return huevos;
	}
	
	/*
	 * Método para crear aleatoriamente el número de yemas de un huevo
	 */
	private Integer numeroYemas()
	{
		//Creamos un número entero aleatorio entre 0 y 99
		Integer yemas = new Random(UUID.randomUUID().getMostSignificantBits())
				.nextInt(100);
		
		/*
		 * Si el numero generado es menor 
		 * que la probabilidad más baja
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
		 * Devuelve de forma estática el tipo enumerado 
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
