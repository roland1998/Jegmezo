package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Eszkim�.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//

import java.util.List;

public class Eszkimo extends Jatekos
{	
	/**
	 * Konstruktor, ami l�trehozza a J�t�kost a medadott param�terekkel
	 * @param jegmezo - a j�gmez�, amin a J�t�kos van
	 * @param aktjegtabla - a J�gt�bla, amin a J�t�kos �ll
	 * @param jelzopisztolydb - a J�t�kos jelz�pisztoly darabjainak sz�ma
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
	 * @param targyak - a J�t�kos �ltal t�rolt t�rgyak
	 * @param iranyAmibeNez - az Irany, amibe a J�t�kos n�z
	 */
	public Eszkimo(Jegmezo jegmezo,
	Jegtabla aktjegtabla,
	int jelzopisztolydb,
	int Munkadb,
	int testho,
	List<Targy> targyak,
	Irany iranyAmibeNez)
	{
		super(jegmezo,
				aktjegtabla, 
				jelzopisztolydb,
				Munkadb,
				testho,
				targyak,
				iranyAmibeNez);
	}
	/**
	 * �p�t egy iglut a megadott J�gt�bl�ra
	 */
	public void kepesseg(Jegtabla j)
	{
		boolean sikeres = j.iglutEpit();
		
		if(sikeres)
		{
			Munkadb--;
			System.out.println("Iglu epitese sikeres");
		}
		else
		{
			System.out.println("Iglu epitese sikertelen");
		}
		
		
		
	}
	
}
