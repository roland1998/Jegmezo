package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : J�t�kos.java
//  @ Date : 25/03/2020
//  @ Author : 
//
//

import java.util.List;

public abstract class Jatekos implements Frissitheto
{
	protected Jegtabla aktjegtabla;
	private int jelzopisztolydb;
	protected int Munkadb;
	private int testho;
	private List<Targy> targyak;
	protected Irany iranyAmibeNez;
	
	
	/**
	 * Konstruktor, ami l�trehozza a J�t�kost a medadott param�terekkel
	 * @param aktjegtabla - a J�gt�bla, amin a J�t�kos �ll
	 * @param jelzopisztolydb - a J�t�kos jelz�pisztoly darabjainak sz�ma
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
	 * @param targyak - a J�t�kos �ltal t�rolt t�rgyak
	 * @param iranyAmibeNez - az Irany, amibe a J�t�kos n�z
	 */
	public Jatekos(Jegtabla aktjegtabla,
	int jelzopisztolydb,
	int Munkadb,
	int testho,
	List<Targy> targyak,
	Irany iranyAmibeNez)
	{
		this.aktjegtabla = aktjegtabla;
		this.jelzopisztolydb = jelzopisztolydb;
		this.Munkadb = Munkadb;
		this.testho = testho;
		this.targyak = targyak;
		this.iranyAmibeNez = iranyAmibeNez;
	}
	
	
	/**
	 * A J�t�kos �s 1-et azon a J�gt�bl�n, amin �ll
	 */
	public void asas()
	{
		
		boolean sikeres = aktjegtabla.asas(1);
		if(sikeres)
		{
			Munkadb--;
			System.out.println("Asas sikeresen elvegezve");
		}
		else
			System.out.println("Asas sikertelenul elvegezve");
		
	}
	
	
	/**
	 * @param i - i ir�nyban l�v� szomsz�dos j�gmez�re helyezi �t a j�t�kost.
	 * @return Visszaadja, hogy sikeres volt-e az �thelyez�s
	 */
	public boolean athelyez(Irany i)
	{
		Jegtabla szomszed=aktjegtabla.szomszedKerdez(i);
		if (szomszed!=null) {
			aktjegtabla=szomszed;
			System.out.println("Sikeresen athelyezve");
			return true;
		}
		else 
		{
			System.out.println("Nem sikerult athelyezni");
			return false;
		}
	}
	
	public void kilep(Jegtabla j)
	{
	}
	
	/**
	 * @param i cs�kkenti a testh�t a megadott mennyis�ggel
	 */
	public void fazas(int i)
	{
		testho-=i;
		System.out.println("Testho csokkentve");
	}
	
	public void frissit()
	{
	}
	
	/**
	 * @return Visszaadja a J�t�kos iranyAmibeNez-�t
	 */
	public Irany getIranyAmibeNez()
	{
		return iranyAmibeNez;
	}
	
	
	/**
	 * ha nincs iglu a j�gt�bl�n ahol van, akkor megh�vja a f�z�s f�ggv�nyt, ha a testh�je 0-ra 
	 * cs�kken meghal, ezt jelzi a j�gmez�nek
	 */
	public void hovihar()
	{
		boolean iglu=aktjegtabla.VanRajtaIgluLekerdez();
		if(!iglu) {
			this.fazas(1);
		}
		if(testho==0) {
			jm.meghalt();
		}
	}
	
	/**
	 * @return Visszaadja a J�t�kos �ltal t�rolt jelz�pisztoly darabok sz�m�t
	 */
	public int getjelzopisztolydb()
	{
		return jelzopisztolydb;
	}
	
	/**
	 * N�veli eggyel a jelzopisztolydb-t.
	 */
	public void jelzopisztolyDarabokNovelese()
	{
		jelzopisztolydb++;
	}
	
	public Jegtabla JegtablaLekerdez()
	{
		return aktjegtabla;
	}
	
	/**
	 * A j�t�kos k�pess�ge, amit a lesz�rmazottak val�s�tanak meg
	 * @param j - a j�gt�bla, amin a k�pess�get v�gezz�k
	 */
	public abstract void kepesseg(Jegtabla j);
	
	
	/**
	 * Ezzel a f�ggv�nnyeltud majd l�pni a j�t�kos, azaz az adott ir�nyba es� 
	 * j�gt�bl�ra l�pni. 
	 * @param i - ir�ny, amit kap, ahova l�pni akarunk
	 */
	public void lepes(Irany i)
	{
		this.setIranyAmibeNez(i);
		Jegtabla jt = this.JegtablaLekerdez();
		Jegtabla szJegtabla = jt.szomszedKerdez(i);
		...?
		
	}
	
	public void pisztolyepit()
	{
		
	}
	
	
	/**
	 * Be�ll�tja a j�t�kost, hogy abba az ir�nyba n�zzen, amit megadunk
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a J�t�kos
	 */
	public void setIranyAmibeNez(Irany i)
	{
		iranyAmibeNez = i;
	}
	
	
	
	/**
	 * Megh�vja a megadott index� t�rgyra a haszn�l f�ggv�nyt
	 * @param idx - annak a T�rgynak az indexe, amit haszn�lni akarunk
	 */
	public void targyHasznalat(int idx)
	{
		if(targyak != null)
		{
			boolean sikeres = targyak.get(idx).hasznal(this);
			if(sikeres)
			{
				System.out.println("A targyhasznalat sikerult");
				this.MunkaDBcsokkentese(1);
			}
			else 
				System.out.println("A targy hasznalat nem sikerult");
		}
			
	}
	
	/**
	 * Megpr�b�lja felvenni a t�rgyat a j�gt�bl�r�l, amin �ll
	 */
	public void targyFelvetel()
	{
		
		boolean sikeres = aktjegtabla.targyFelvesz(this);
		if(sikeres)
		{
			System.out.println("A targyfelvetel sikerult");
			this.MunkaDBcsokkentese(1);
		}
		else
			System.out.println("A targyfelvetel nem sikerult");
		
			
	}
	
	/**
	 * @param t - t�rgyat hozz�adja a j�t�kos t�rgyaihoz
	 */
	public boolean targyHozzadasa(Targy t)
	{
		�t kell n�zni
		
		int i=targyak.size();
		targyak.add(t);
		int j=targyak.size();
		if (i==j) {
			System.out.println("Targy hozzaadva");
			return true;
		}
		else 
		{
			System.out.println("Nem sikerult felvenni a targyat");
			return false;
		}
	}
	
	/**
	 * Elt�vol�tja a param�terben megadott t�rgyat
	 * @param t - a t�rgy, amit el akarunk t�vol�tani
	 */
	public void targyEltavolitasa(Targy t)
	{
		targyak.remove(t);
	}
	

	/**
	 * @param mennyivel - noveli a testhot ezzel az �rt�kkel, de a testh�t 
	 * max 6-ig tudjuk n�velni.
	 * @return visszat�r azzal, hogy 
	 */
	public boolean testhoNovelese(int mennyivel)
	{
		testho+= mennyivel;
		if (testho > 6) {
			testho=6;
			System.out.println("Testhot 6-ig lehet csak n�velni.");
			return false;
		}
		else
		{
			System.out.println("Testho novelve");
			return true;
		}
	}
	
	/**
	 * cs�kkenti a megadott mennyis�ggel a j�t�kos munkaDB-j�t
	 * Ha null�ra cs�kken �tadjuk a k�rt a k�vetkez� j�t�kosnak
	 * @param mennyivel - mennyivel cs�kkents�k a MunkaDB-t
	 */
	public void MunkaDBcsokkentese(int mennyivel)
	{
		
		if(Munkadb - mennyivel < 0)
		{
			Munkadb = 0;
			System.out.println("Elfogytak a munkaid pajtas :)) ");
			korVege();
		}
		else
			Munkadb -= mennyivel;
			
		
		
	}
	
	/**
	 * Akkor h�v�dik meg, ha nul�ra cs�kkent a J�t�kos Munkadb-je
	 */
	public void korVege()
	{
		
	}
	
}
