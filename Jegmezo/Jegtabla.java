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

import java.util.ArrayList;
import java.util.List;

public class Jegtabla implements Frissitheto
{
	private Jegmezo jegmezo;
	private boolean atVanFordulva;
	private int ho;
	private int tartokepesseg;
	private List<Jegtabla> szomszedok;
	private boolean vanRajtaIglu;
	private List<Jatekos> jatekosok;
	private Targy targy;
	
	
	/**
	 * A j�gt�bla konstruktora, ami l�trehozza j�gt�bl�t, a megadott param�terekkel
	 * @param jegmezo - A j�gmez�, amin van
	 * @param atVanFordulva - azt adja meg, hogy �t van-e fordulva
	 * @param ho - a kezdeti h�mennyis�get adja meg
	 * @param tartokepesseg - a tart�k�pess�g�t adja meg
	 * @param vanRajtaIglu - azt adja meg, hogy van-e rajta iglu
	 * @param targy - a benne l�v� t�rgyat adja meg. Ha nincs benne t�rgy, akkor null legyen az �rt�ke
	 */
	public Jegtabla(Jegmezo jegmezo,
	boolean atVanFordulva,
	int ho,
	int tartokepesseg,
	boolean vanRajtaIglu,
	Targy targy)
	{
		this.jegmezo = jegmezo;
		
		this.atVanFordulva =atVanFordulva;
		this.ho = ho;
		this.tartokepesseg = tartokepesseg;
		szomszedok = new ArrayList<>(); 
		
		for(int i = 0; i < 4; i++)
			szomszedok.add(null);
		this.vanRajtaIglu = vanRajtaIglu;
		
		jatekosok = new ArrayList<>(); 
		this.targy = targy;
		this.jegmezo.addFrissitheto(this);
	}
	
	/**
	 * Hozz�adja a megadott ir�ny� szomsz�daihoz a megadott j�gt�bl�t
	 * @param j - a j�gt�bla, amit fel akarunk venni a szomsz�dok k�z�
	 * @param i - azt adja meg, hogy a j�gt�bl�nak melyik ir�nyba lesz a szomsz�dja
	 */
	public void setSzomszed(Jegtabla j, Irany i)
	{
		int idx = 0;
		//(Jobb(0), Bal(1), Fel(2),Le(3))
		switch(i) {
			case Jobb:
				idx = 0;
				break;
			case Bal:
				idx = 1;
				break;
			case Fel:
				idx = 2;
				break;
			default:
				idx = 3;
				break;
		}
			
		szomszedok.set(idx, j);
		
	}
	
	
	/**
	 * Felveszi a j�t�kost a t�bl�ra �s �t�ll�tja az aktjegtabla attrib�tum�t
	 * @param j - a j�t�kos, akit hozz� akarunk adni a t�bl�hoz
	 * @return visszaadja, hogy siker�lt-e felvenni a j�t�kost a j�gt�bl�ra
	 */
	public void addJatekos(Jatekos j)
	{
		
		
			j.setaktjegtabla(this);
			jatekosok.add(j);
	}
	
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
	
	/**
	 * Visszaford�tja a t�bl�t
	 */
	public void visszaFordit()
	{
		atVanFordulva = false;
		System.out.println("A jegtabla visszafordult");
	}
	
	/**
	 * �tford�tja a t�bl�t
	 */
	public void atfordit()
	{
		atVanFordulva = true;
		System.out.println("Jaj! Felfordult a t�bla!");
	}
	
	/**
	 * Azt adja meg, hogy a J�tekos elhagyhatja-e a J�gt�bl�t 
	 * @param j - Am j�t�kos aki el akarja hagyni a J�gt�bl�t
	 * @return Visszaadja, hogy a J�t�kos elhagyhatja-e a J�gt�bl�t
	 */
	public boolean ellep(Jatekos j)
	{
		if(atVanFordulva)
		{
			System.out.println("A jegtabla at van fordulva, a jatekos csak buvarruhaval hagyhatja el");
			return false;
		}
		else
		{
			this.jatekosEltavolit(j);
			System.out.println("A jatekos elhagyhatja a jegtablat");
			return true;
		}
	}
	
	/**
	 * �j k�r elej�n megn�zi, hogy �t van-e fordulva �s ha igen �s vannak rajta j�t�kosok, akkor sz�l a j�gmez�nek, 
	 * hogy ezek a j�t�kosok meghaltak.
	 * Ha �t van fordulva �s nincs rajta senki akkor visszaford�tjuk a j�gt�bl�t
	 */
	public void frissit()
	{	
		if(atVanFordulva) {
			for(int i = 0; i < jatekosok.size(); i++)
				jegmezo.meghalt(jatekosok.get(i));
		
			if(jatekosok.size() == 0);
				visszaFordit();
		}
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
		if(vanRajtaIglu) {
			System.out.println("Mar van rajta Iglu. ");
			return false;
		}
		else
		{
			vanRajtaIglu = true;
			return true;
		}
	}
	
	/**
	 * Elt�vol�tja param�terben megadott j�t�kost a j�gt�bla j�t�kosai k�z�l
	 * @param j - A J�t�kos, akit el akarunk t�vol�tni
	 */
	public void jatekosEltavolit(Jatekos j)
	{
		jatekosok.remove(j);
		System.out.println("Jatekos eltavolitva a tablarol");
		/*if(jatekosok.size() <= tartokepesseg)
			visszaFordit();*/
	}
	
	public List<Jatekos> jatekosokLekerdez()
	{
		return jatekosok;
	}
	
	/**
	 * R�l�pteti a megadott j�t�kost a t�bl�ra �s ha j�t�kosok sz�ma �gy meghaladja a tart�k�pess�get, �tford�tja a t�bl�t
	 * @param j - A J�t�kos, aki r�l�p a t�bl�ra 
	 */
	public void ralep(Jatekos j)
	{
		j.setaktjegtabla(this);
		jatekosok.add(j);
		System.out.println("A jatekos ralepett a tablara");
		
		if(jatekosok.size() > tartokepesseg)
			atfordit();
			
	}
	
	/**
	 * visszaadja a j�gt�bla i ir�nyban l�v� szomsz�dj�t 
	 * @param i - az ir�ny amibe tudni szeretn�nk a szomsz�dot
	 * @return visszaadja az i ir�nyban l�v� szomsz�dot
	 */
	public Jegtabla szomszedKerdez(Irany i)
	{
		int idx = 0;
		//(Jobb(0), Bal(1), Fel(2),Le(3))
		switch(i) {
			case Jobb:
				idx = 0;
				break;
			case Bal:
				idx = 1;
				break;
			case Fel:
				idx = 2;
				break;
			default:
				idx = 3;
				break;
		}
			
		return szomszedok.get(idx);
	}
	
	
	/**
	 * Megh�vja a rajtal�v� t�rgy felvesz f�ggv�ny�t, ha a h� rajta -1
	 * @param j - a J�t�kos, aki fel akarja venni a t�rgyat
	 * @return Visszaadja, hogy sikeres volt-e a t�rgyfelv�tel
	 */
	public boolean targyFelvesz(Jatekos j)
	{
		if(ho == -1)
		{
			if(targy != null)
			{
				boolean sikeres =  targy.felvesz(j);
				if(sikeres)
				{
					System.out.println("A jegtablarol valo targy felvetel sikeres volt");
					targy = null; // t�r�lj�k a t�rgyat a t�bl�r�l
				}
				
				else 
					System.out.println("A jegtablarol valo targy felvetel nem volt sikeres");
				
				
				return sikeres;
			}
			else
			{
				System.out.println("A jegtablan nincs targy");
				return false;
			}
		
		}
		else
		{
			System.out.println("A jegtablan levo targyat meg ho takarja");
			return false;
		}
	}
	
	/**
	 * @return visszaadja, hogy van e iglu a j�gt�bl�n
	 */
	public boolean VanRajtaIgluLekerdez()
	{
		return vanRajtaIglu;
	}
	
	
	/**
	 * @return Visszaadja, hogy a j�gt�bla �t van-e fordulva
	 */
	public boolean getAtVanFordulva()
	{
		return atVanFordulva;
	}
	
	/**
	 * �t�ll�tja a j�gt�bla t�rgy�t a megadott t�rgyra
	 * @param t - a t�rgy, amire �t akarjuk �ll�tani
	 */
	public void setTargy(Targy t)
	{
		targy = t;
	}
}
