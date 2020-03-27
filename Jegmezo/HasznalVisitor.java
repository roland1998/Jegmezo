package Jegmezo;

import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : HasználVisitor.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//




public class HasznalVisitor implements Visitor
{
	/**
	 *	Az ásó használ tevékenységét valósítja meg. Csökkenti a a hó mennyiségét 2-vel annak
	 *Jégtáblának,ami abba az irányba van, amibe a Játékos, aki az ásót használja, néz.
	 */
	public void visit(Aso a, Jatekos j)
	{
		Irany i = j.getIranyAmibeNez();
		Jegtabla jt = j.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(i);
		
		boolean sikeres = szJegtabla.asas(2);
		if(sikeres)
		{
			System.out.println("Aso sikeresen hasznalva");
		}
		else
			System.out.println("Aso sikertelenul hasznalva");
		
	}
	
	public void visit(Kotel k, Jatekos j)
	{
	}
	
	/**
	 * a játékost áthelyezi a kapott irányba.
	 */
	public void visit(Buvarruha b, Jatekos j)
	{
		j.athelyez(j.getIranyAmibeNez());
	}
	
	/* (non-Javadoc)
	 * @see Jegmezo.Visitor#visit(Jegmezo.Elelem, Jegmezo.Jatekos)
	 * a játékos testhőjét növeli azzal, hogy megeszi, azaz felhasználja az élelmet.
	 */
	public void visit(Elelem e, Jatekos j)
	{
		j.testhoNovelese(1);
	}
	
	/**
	 *	A jelzőpisztoly használ tevékenységét valósítja meg. Megpróbálja összeszerelni a jelzőpisztoly és kiírja, hogy sikeres volt-e avagy sem
	 */
	public void visit(Jelzopisztoly jp, Jatekos j)
	{
		int jelzopisztolyDB = j.getjelzopisztolydb();
		List<Jatekos> jatekosok = j.aktjegtabla.jatekosokLekerdez();
		
		for(int i = 0; i < jatekosok.size(); i++)
			jelzopisztolyDB += jatekosok.get(i).getjelzopisztolydb();
		
		if(jelzopisztolyDB == 3)
		{
			System.out.println("Sikeres összeszerelés ┌( ͝° ͜ʖ͡°)=ε/̵͇̿̿/’̿’̿ ");
			jm.jatekvege(true);
		}
		else
			System.out.println("Sikertelen összeszerelés :/");
	}
}
