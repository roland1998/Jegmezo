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

import java.util.ArrayList;
import java.util.List;

public abstract class Jatekos implements Frissitheto
{
	private Jegmezo jegmezo;
	protected Jegtabla aktjegtabla;
	private int jelzopisztolydb;
	protected int Munkadb;
	private int testho;
	private List<Targy> targyak;
	protected Irany iranyAmibeNez;
	
	
	/**
	 * Konstruktor, ami l�trehozza a J�t�kost a medadott param�terekkel
	 * @param jegmezo - a j�gmez�, amin a J�t�kos van
	 * @param jelzopisztolydb - a J�t�kos jelz�pisztoly darabjainak sz�ma
	 * @param Munkadb - A J�t�kos h�tral�v� elv�gezhet� munka sz�ma
	 * @param testho - a J�t�kos h�tral�v� testh�je
	 * @param targyak - a J�t�kos �ltal t�rolt t�rgyak
	 * @param iranyAmibeNez - az Irany, amibe a J�t�kos n�z
	 */
	public Jatekos(Jegmezo jegmezo,
	int jelzopisztolydb,
	int Munkadb,
	int testho,
	List<Targy> targyak,
	Irany iranyAmibeNez)
	{
		this.jegmezo = jegmezo;
		this.aktjegtabla = null;
		this.jelzopisztolydb = jelzopisztolydb;
		this.Munkadb = Munkadb;
		this.testho = testho;
		this.targyak = targyak;
		this.iranyAmibeNez = iranyAmibeNez;
		this.jegmezo.addFrissitheto(this);
		
		System.out.println("Valaki letrehozott egy jatekost");
	}
	
	
	/**
	 * A J�t�kos �s 1-et azon a J�gt�bl�n, amin �ll
	 */
	public void asas()
	{
		System.out.println("En, a jatekos, kezzel asasra keszulok");
		
		boolean sikeres = aktjegtabla.asas(1);
		if(sikeres)
		{
			this.MunkaDBcsokkentese(1);
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
		System.out.println("Valaki engem, a jatekost, epp at akar helyezni");
		Jegtabla szomszed = aktjegtabla.szomszedKerdez(i);
		if (szomszed!=null) {
			aktjegtabla.jatekosEltavolit(this);
			szomszed.ralep(this);
			System.out.println("Sikeresen athelyeztek");
			return true;
		}
		else 
		{
			System.out.println("Nem sikerult athelyezni engem");
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
		System.out.println("Fazom ezert a testhom " + testho + "-rol " + (testho - i) + "-re csokkent");
		testho-=i;
		
		
		if(testho<=0) {
			System.out.println("Elfogyott minden testhom, ezert most meghalok");
			jegmezo.meghalt(this);
		}
		
	}
	
	/**
	 *Az �j k�r elej�n vissza�ll�tjuk a Munkadb-j�t 4-re
	 */
	public void frissit()
	{
		Munkadb = 4;
		System.out.println("Jatekoskent az uj kor elejen megint " + Munkadb + "db munkam van");
		
	}
	
	/**
	 * @return Visszaadja a J�t�kos iranyAmibeNez-�t
	 */
	public Irany getIranyAmibeNez()
	{
		System.out.println("Engem, mint jatekost, epp arrol kerdeznek, hogy merre nezek");
		return iranyAmibeNez;
	}
	
	
	/**
	 * ha nincs v�delem a j�gt�bl�n ahol van, akkor megh�vja a f�z�s f�ggv�nyt, ha a testh�je 0-ra 
	 * cs�kken meghal, ezt jelzi a j�gmez�nek
	 */
	public void hovihar()
	{
		System.out.println("En, a jatekos, epp egy hoviharban vagyok");
		Vedelem  v = aktjegtabla.getjegtablaVedelme();
		
		
		if(v != null)
		{
			System.out.println("Jatekos: Van vedelem a tablan ezert meghivom a hovihar fuggvenyet");
			v.hovihar();
		}
		if(v == null) {
			System.out.println("Jatekos: Nincs vedelem a tablan");
			System.out.println("Durva ez a hovihar, most fazom");
			fazas(1);
		}
	}
	
	/**
	 * @return Visszaadja a J�t�kos �ltal t�rolt jelz�pisztoly darabok sz�m�t
	 */
	public int getjelzopisztolydb()
	{
		System.out.println("Jatekos vagyok es a jelzopisztolydb szamom irant erdeklodnek epp");
		return jelzopisztolydb;
	}
	
	/**
	 * N�veli eggyel a jelzopisztolydb-t.
	 */
	public void jelzopisztolyDarabokNovelese()
	{
		System.out.println("Nekem, a jatekosnak, epp noveltek a jelzopisztolyok darabszamat 1-el");
		jelzopisztolydb++;
	}
	
	public Jegtabla JegtablaLekerdez()
	{
		System.out.println("Jatekos vagyok es azt kerdezik melyik jegtablan allok");
		return aktjegtabla;
	}
	
	/**
	 * A j�t�kos k�pess�ge, amit a lesz�rmazottak val�s�tanak meg
	 */
	public abstract void kepesseg();
	
	
	/**
	 * Ezzel a f�ggv�nnyeltud majd l�pni a j�t�kos arra a j�gt�bl�ra, ami arra van, amerre n�z
	 */
	public void lepes()
	{
		System.out.println("Jatekos vagyok es most probalok lepni egyet");
		boolean ellephet = aktjegtabla.ellep(this);
		
		if(ellephet)
		{
			Jegtabla szJegtabla = aktjegtabla.szomszedKerdez(iranyAmibeNez);
			if(szJegtabla != null )
			{
				szJegtabla.ralep(this);
				System.out.println("Sikerult az ellepes");
				MunkaDBcsokkentese(1);
			}
			else
			{
				System.out.println("Nem sikerult az ellepes, mert ebbe az iranyba nincs jegtabla");
			}
		}
		else {
			System.out.println("Nem sikerult az ellepes, mert nem lephetek el");
		}
		
	}
	
	
	
	/**
	 * Be�ll�tja a j�t�kost, hogy abba az ir�nyba n�zzen, amit megadunk
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a J�t�kos
	 */
	public void setIranyAmibeNez(Irany i)
	{
		System.out.println("Most epp a jatekos iranyAmibeNez tulajdonsagat allitjak");
		
		iranyAmibeNez = i;
	}
	
	
	
	/**
	 * Megh�vja a megadott index� t�rgyra a haszn�l f�ggv�nyt
	 * @param idx - annak a T�rgynak az indexe, amit haszn�lni akarunk
	 */
	public void targyHasznalat(int idx)
	{
		System.out.println("A jatekos epp a " + idx + " indexu targyat probalja hasznalni");
		if(targyak != null)
		{
			if(targyak.size() > idx)
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
			else
			{
				System.out.println("A targy hasznalat nem sikerult, mert nincsenen ilyen indexu targya a jatekosnak");
			}
		}
		else
		{
			System.out.println("A targy hasznalat nem sikerult, mert nincsenek targyai a jatekosnak");
		}
			
	}
	
	/**
	 * Megpr�b�lja felvenni a t�rgyat a j�gt�bl�r�l, amin �ll
	 */
	public void targyFelvetel()
	{
		System.out.println("A jatekos epp egy targyat probal felvenni a jegtablarol, amin all");
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
		if(targyak == null)
			targyak = new ArrayList<>();
		System.out.println("A jatekos targygyujtemenyehez epp egy targyat probalnak hozzaadni");
		targyak.add(t);
		System.out.println("Targy hozzaadva");
		return true;
	}
	
	/**
	 * Elt�vol�tja a param�terben megadott t�rgyat
	 * @param t - a t�rgy, amit el akarunk t�vol�tani
	 */
	public void targyEltavolitasa(Targy t)
	{
		System.out.println("A jatekos targygyujtemenyebol epp egy targyat probalnak eltavolitani");
		targyak.remove(t);
		System.out.println("Targy eltavolitva");
	}
	

	/**
	 * @param mennyivel - noveli a testhot ezzel az �rt�kkel, de a testh�t 
	 * max 6-ig tudjuk n�velni.
	 * @return visszat�r azzal, hogy 
	 */
	public boolean testhoNovelese(int mennyivel)
	{
		System.out.println("Most epp a jatekos testhojet akarjak novelni");
		testho+= mennyivel;
		if (testho > 6) {
			testho=6;
			System.out.println(" Nem sikerult a noveles, mert a testhot 6-ig lehet csak n�velni.");
			return false;
		}
		else
		{
			System.out.println("Testho sikeresen novelve");
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
		System.out.println("Most epp a jatekos munkadbjait probaljak csokkenteni");
		System.out.println("Munkadb csokkentve");
		if(Munkadb - mennyivel < 0)
		{
			Munkadb = 0;
			System.out.println("Elfogytak a munkaim ");
			
			System.out.println("ezert tovabbadom a korom");
			korVege();
		}
		else
		{
			Munkadb -= mennyivel;
		}
	}
	
	/**
	 * Akkor h�v�dik meg, ha nul�ra cs�kkent a J�t�kos Munkadb-je
	 */
	public void korVege()
	{
		System.out.println("a jatekos vegzett a korevel");
	}
	
	/**
	 * @return Visszaadja a j�gmez�t, amin a j�t�kos van
	 */
	public Jegmezo getJegmezo()
	{
		System.out.println("a jatekos jegmezojet kerdezik le epp");
		return jegmezo;
	}
	
	/**
	 * �t�ll�tja a j�t�kos aktjegtabla attrib�tum�t
	 * @param jt - A j�gt�bla, amire �t akarjuk �ll�tani
	 */
	public void setaktjegtabla(Jegtabla jt)
	{
		System.out.println("a jatekosnak epp azt allitjak, hogy melyik jegtablan all");
		aktjegtabla  = jt;
	}
	
	
	/**
	 * Kilist�zza a konzolra a j�t�kos t�rgyait
	 */
	public void TargyakListazasa()
	{
		if(targyak != null)
		{
			System.out.println("A jatekos targyai:");
			for(int i = 0; i < targyak.size(); i++)
				System.out.println((i + 1) + ". - " + targyak.get(i).toString() );
		}
		else
		{
			System.out.println("Nincsenek targyai a jatekosnak");
		}
		
	}
	
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jatekos";
	}
	
	/**
	 * @return Visszaadja a j�t�kos testh�j�t
	 */
	public int getTestho()
	{
		return testho;
	}
	
	/**
	 * @return Visszaadja a j�t�kos Munkadb attrib�tum�t
	 */
	public int getMunkadb()
	{
		return Munkadb;
	}
	
}
