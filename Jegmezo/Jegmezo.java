package Jegmezo;

import java.util.List;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : J�gmezo.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//





public class Jegmezo
{
	private int hoviharCnt;
	private List<Frissitheto> frissithetok;
	
	public void hovihar()
	{
	}
	
	
	/**
	 * @param nyert  ha igaz �rt�ket kap nyert�nk, ha hamisat vesztett�nk, a j�t�knak v�ge.
	 */
	public void jatekvege(boolean nyert)
	{
		if(!nyert) 
			System.out.println("Sajnos vesztettetek.");
		else 
			System.out.println("Nyertetetek!");
	}
	
	/**
	 * A frisi�thet�ket friss�ti, �s ha a h�vihar sz�m�l� null�ra v�lt megh�vja a h�vihar f�ggv�ny�t 
	 * a frisi�thet�knek.
	 */
	public void leptet()
	{
		for(int i=0;i<frissithetok.size();i++) {
			frissithetok.get(i).frissit();
			if(hoviharCnt==0)
				frissithetok.get(i).hovihar();
		}
	}
	
	/**
	 * @param j ha meghalt egy j�t�kos v�ge a j�t�knak, megh�vja ezt a f�ggv�nyt false �rt�kkel
	 */
	public void meghalt(Jatekos j)
	{
		this.jatekvege(false);
	}
	
	public void setup()
	{
	}
}