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
	private FelveszVisitor felveszVisitor;
	private HasznalVisitor hasznalVisitor;
	private int jelzopisztolydb;
	protected int Munkadb;
	private int testho;
	private List<Targy> targyak;
	protected Irany iranyAmibeNez;
	
	
	/**
	 * Konstruktor, ami l�trehozza a J�t�kost a medadott param�terekkel
	 * @param aktjegtabla - a J�gt�bla, amin a J�t�kos �ll
	 * @param felveszVisitor - a J�t�kos felvesz tev�kenys�g�t kezel� visitor
	 * @param hasznalVisitor - a J�t�kos hasznal tev�kenys�g�t kezel� visitor
	 * @param jelzopisztolydb - a J�t�kos jelz�pisztoly darabjainak sz�ma
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
	 * @param targyak - a J�t�kos �ltal t�rolt t�rgyak
	 * @param iranyAmibeNez - az Irany, amibe a J�t�kos n�z
	 */
	public Jatekos(Jegtabla aktjegtabla,
	FelveszVisitor felveszVisitor,
	HasznalVisitor hasznalVisitor,
	int jelzopisztolydb,
	int Munkadb,
	int testho,
	List<Targy> targyak,
	Irany iranyAmibeNez)
	{
		this.aktjegtabla = aktjegtabla;
		this.felveszVisitor = felveszVisitor;
		this.hasznalVisitor = hasznalVisitor;
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
	 * @param i i ir�nyban l�v� szomsz�dos j�gmez�re helyezi �t a j�t�kost.
	 */
	public void athelyez(Irany i)
	{
		Jegtabla szomszed=aktjegtabla.szomszedKerdez(i);
		if (szomszed!=null) {
			aktjegtabla=szomszed;
			System.out.println("Sikeresen athelyezve");
		}
		else 
			System.out.println("Nem sikerult athelyezni");
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
	
	/* (non-Javadoc)
	 * @see Jegmezo.Frissitheto#hovihar()
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
	
	public void lepes()
	{
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
	
	
	public void targyfelvetel(Targy t)
	{
		int i=targyak.size();
		targyak.add(t);
		int j=targyak.size();
		if (i==j) {
			System.out.println("Targy hozzaadva");
		}
		else 
			System.out.println("Nem sikerult felvenni a targyat");
	}
	
	public void testhoNovelese(int mennyivel)
	{
		
		testho+= mennyivel;
		System.out.println("Testho novelve");
	}
}
