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
	int Munkadb,
	int testho)
	{
		super(jegmezo,
				Munkadb,
				testho);
		
		Global.out.println("Jatekos tipusa eszkimo.");
	}
	
	
	/**
	 * �p�t egy iglut arra J�gt�bl�ra, amerre nez
	 */
	public void kepesseg()
	{
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		if (Munkadb>0) {
			Iglu i = new Iglu();
			
			aktjegtabla.setjegtablaVedelme(i);
				
			System.out.println("Iglu epitese sikeres.");
			this.MunkaDBcsokkentese(1);
		}
		else
			Global.out.print("Iglu epitese sikertelen. ");
		Global.out.print("A jatekos MunkaDB-ja: "+Munkadb+". ");
		
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Eszkimo";
	}
	
}
