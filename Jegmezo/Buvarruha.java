package Jegmezo;

import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : B�v�rruha.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//




public class Buvarruha implements Targy
{
	
	
	public Buvarruha()
	{
		Global.out.print("Sikeresen letrehoztak egy buvarruhat. ");
	}
	
	/**
	 * Hozz�adja a b�v�rruh�t a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
			Global.out.print("Buvarruha sikeresen felveve. ");
		
		else 
			Global.out.print("A buvarruhat nem sikerult felvenni. ");
			
		
		return sikeres;
	}

	
	/**
	 * a j�t�kost �thelyezi a kapott ir�nyba �s visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		int szog = j.getSzogAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(szog);
		//List<Jatekos> kihuz=szJegtabla.jatekosokLekerdez();
		
		Global.out.print("Ez egy buvarruha. ");
		
		//int szogvissza=j.getSzogAmibeNez()-180;
		//if (szogvissza<0) szogvissza+=360;
		boolean sikeres =false;
		
		sikeres=j.athelyez(szog);
		//sikeres = kihuz.get(i).athelyez(szogvissza);
		
		
		if(sikeres)
			Global.out.print("Buvarruha sikeresen hasznalva. ");
		else
			Global.out.print("A buvarruhat nem sikertelenul hasznalni. ");
		
		
		return sikeres;
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Buvarruha";
	}
}
