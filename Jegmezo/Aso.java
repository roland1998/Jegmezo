package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : �s�.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//


public class Aso implements Targy
{
	
	/**
	 * Hozz�adja az �s�t a J�t�kos t�rgyaihoz �s visszaadja, hogy siker�lt-e
	 */
	public boolean felvesz(Jatekos j) {
		
		boolean sikeres = j.targyHozzadasa(this);
		
		if(sikeres)
		{
			System.out.println("Aso sikeresen felveve");
			
		}
		else 
			System.out.println("Az asot nem sikerult felvenni");
	
		
		return sikeres;
	}

	
	/**
	 *	Az �s� haszn�l tev�kenys�g�t val�s�tja meg. Cs�kkenti a a h� mennyis�g�t 2-vel annak
	 *J�gt�bl�nak,ami abba az ir�nyba van, amibe a J�t�kos, aki az �s�t haszn�lja, n�z. Es visszaadja, hogy siker�lt-e
	 */
	public boolean hasznal(Jatekos j) {
		
		Irany i = j.getIranyAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(i);
		
		boolean sikeres = szJegtabla.asas(2);
		
		if(sikeres)
			System.out.println("Aso sikeresen hasznalva");
		else
			System.out.println("Aso sikertelenul hasznalva");
		
		
		return sikeres;
		
	}
}
