package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Sarkkutat�.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//

import java.util.List;

public class Sarkkutato extends Jatekos
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
	public Sarkkutato(Jegmezo jegmezo,
	int jelzopisztolydb,
	int Munkadb,
	int testho,
	List<Targy> targyak,
	Irany iranyAmibeNez)
	{
		super(jegmezo,
				jelzopisztolydb,
				Munkadb,
				testho,
				targyak,
				iranyAmibeNez);
	}

	
	/**
	 * A sarkutat� megvizsg�lja a megadott J�gt�bla tart�k�pess�g�t
	 */
	public void kepesseg(Jegtabla j)
	{
		System.out.println("A jegtabla tartokepessege: " + j.gettartokepesseg());
	}
	
}
