package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : J�gt�bla.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//

import java.util.List;

public class Jegtabla implements Frissitheto
{
	private int ho;
	private int tartokepesseg;
	private List<Jegtabla> szomszedok;
	private boolean vanRajtaIglu;
	private List<Jatekos> jatekosok;
	private Targy targy;
	
	
	/**
	 * Cs�kkenti a J�gt�bla h� mennyis�g�t i-vel, ha nulla al� megy a h�, akkor -1-re �ll�tjuk a h�mennyis�get �s a rajta l�v� t�rgyat ki�sottnak tekintj�k.
	 * Ha -1 vagy az alatti a h� mennyis�g nem t�rt�nik semmi
	 * @param i - A mennyis�g, amivel a havat cs�kkenteni szeretn�nk
	 * @return Visszaadja, hogy t�rt�nt-e �s�s
	 */
	public boolean asas(int i)
	{
		if(ho >= 0)
		{
			ho -= i;
			if(ho < -1)
				ho = -1;
			
			return true;
		}
		else
			return false;
		
	}
	
	public void atfordit()
	{
	}
	
	public boolean ellep(Jatekos j)
	{
	}
	
	public void frissit()
	{
	}
	
	/**
	 * @return Visszaadja, hogy h�ny j�t�kost b�r el a J�gt�bla
	 */
	public int gettartokepesseg()
	{
		return tartokepesseg;
	}
	
	/**
	 * n�veli a havat a j�gt�bl�n
	 */
	public void hoNovelese()
	{
		ho++;
		System.out.println("Ho mennyisege megnovelve");
	}
	
	
	/**
	 *megh�vja a honoveles f�gv�nyt
	 */
	public void hovihar()
	{
		this.hoNovelese();
	}
	
	/**
	 * �p�t egy iglut mag�ra, ha m�r nincs rajta egy iglu
	 * @return Visszat�r azzal, hogy �p�tetet-e iglut mag�ra
	 */
	public boolean iglutEpit()
	{
		if(vanRajtaIglu)
			return false;
		else
		{
			vanRajtaIglu = true;
			return true;
		}
	}
	
	public void jatekosEltavolit(Jatekos j)
	{
	}
	
	public List<Jatekos> jatekosokLekerdez()
	{
		return jatekosok;
	}
	
	public void ralep(Jatekos j)
	{
	}
	
	/**
	 * @param i
	 * @return visszaadja az i ir�nyban l�v� szomsz�dot
	 */
	public Jegtabla szomszedKerdez(Irany i)
	{
		return szomszedok.get(i);
	}
	
	public void targyFelvesz(Jatekos j)
	{
	}
	
	/**
	 * @return visszaadja, hogy van e iglu a j�gt�bl�n
	 */
	public boolean VanRajtaIgluLekerdez()
	{
		return vanRajtaIglu;
	}
}
