package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : K�t�l.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//


public class Kotel implements Targy
{
	
	
	/**
	 * Hozz�adja a k�telet a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			System.out.println("Kotel sikeresen felveve");
		}
		else 
			System.out.println("A Kotelet nem sikerult felvenni");	
		
		return sikeres;
	}

	
	/**
	 * Lek�rdezi az ir�nyt, amiben�z, majd lek�ri a szomsz�dosj�gt�bl�t �s   
	 * elkezd v�gig menni a j�t�kosok list�j�n, aki ott van �s �thelyezi �ket �s visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		Jegtabla jt = j.JegtablaLekerdez();						//Komplexit�sa miatt csak azt a r�szt tudjuk 
		boolean sikeres = false;								//tesztelni, hogy lek�rdezi-e a saj�t j�gt�bl�j�t
		if(jt != null)
			sikeres = true;
		
		if(sikeres) 
		{
			System.out.println("Kotel sikeresen hasznalva");
			j.targyEltavolitasa(this);
		}
		else
			System.out.println("Nem sikerult hasznalni a kotelet");
		
		return sikeres;
		
		/*Irany i = j.getIranyAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(i);
		
		List<Jatekos> jatekos = szJegtabla.jatekosokLekerdez();
		for(int jsz = 0; jsz < jatekos.size(); jsz++) {
			jatekos.get(jsz).athelyez(i);
		}
		
		return true;*/
		
	}
	
	
}
