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
	
	protected int szogAmibeNez;
	
	
	public boolean tartAKore;
	
	
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
	int Munkadb,
	int testho)
	{
		this.jegmezo = jegmezo;
		this.aktjegtabla = null;
		this.jelzopisztolydb = 0;
		this.Munkadb = Munkadb;
		this.testho = testho;
		this.targyak = new ArrayList<>();
		
		this.jegmezo.addFrissitheto(this);
		this.jegmezo.addJatekos(this);
		tartAKore = false;
		Global.out.println("Jatekos sikeresen letrehozva. Most van: "+jegmezo.GetJatekosSzam()+
				" jatekos. Munka db: "+Munkadb+" ,testho: "+testho);
	}
	
	
	/**
	 * A J�t�kos �s 1-et azon a J�gt�bl�n, amin �ll
	 */
	public void asas()
	{
		
		if(Munkadb>0) {
			boolean sikeres = aktjegtabla.asas(1);
			if(sikeres)
			{
				this.MunkaDBcsokkentese(1);
				Global.out.print("Asas sikeresen elvegezve. ");
			}
			else
				Global.out.print("Asas nem sikerult. ");
		}
		
	}
	
	
	/**
	 * @param i - i ir�nyban l�v� szomsz�dos j�gmez�re helyezi �t a j�t�kost.
	 * @return Visszaadja, hogy sikeres volt-e az �thelyez�s
	 */
	public boolean athelyez(int szogbe)
	{
		
		Jegtabla szomszed = aktjegtabla.szomszedKerdez(szogbe);
		if (szomszed!=null) {
			aktjegtabla.jatekosEltavolit(this);
			szomszed.ralep(this);
			Global.out.print("Jatekos sikeresen athelyezve");
			return true;
		}
		else 
		{
			Global.out.print("Nem sikerult athelyezni a jatekost");
			return false;
		}
	}
	
	
	
	
	/**
	 * @param i cs�kkenti a testh�t a megadott mennyis�ggel
	 */
	public void fazas(int i)
	{
		
		testho-=i;
		Global.out.print("Testho sikeresen csokkentve. ");
		
		if(testho<=0) {
			Global.out.print("Elfogyott a jatekos testhoje. ");
			jegmezo.meghalt(this);
		}
		
	}
	
	/**
	 *Az �j k�r elej�n vissza�ll�tjuk a Munkadb-j�t 4-re
	 */
	public void frissit()
	{
		Munkadb = 4;
		Global.out.print("A jatekosnak "+Munkadb+ " munkaja van.");
		
	}
	
	
	
	
	/**
	 * ha nincs v�delem a j�gt�bl�n ahol van, akkor megh�vja a f�z�s f�ggv�nyt, ha a testh�je 0-ra 
	 * cs�kken meghal, ezt jelzi a j�gmez�nek
	 */
	public void hovihar()
	{
		
		Vedelem  v = aktjegtabla.getjegtablaVedelme();
		
		
		if(v != null)
		{
			Global.out.print("A hovihar lezajlott, a jatekos megmenekult a hovihar elol. ");
			v.hovihar();
		}
		else {
			System.out.println("\n mukodik");
			Global.out.print("A hovihar lezajlott, a jatekos testhoje csokkent egyet. ");
			fazas(1);
		}
	}
	
	
	
	
	/**
	 * N�veli eggyel a jelzopisztolydb-t.
	 */
	public void jelzopisztolyDarabokNovelese()
	{
		
		jelzopisztolydb++;
		Global.out.print("JelzopisztolyDB-ok szama sikeresen novelve. ");
	}
	
	
	/**
	 * A j�t�kos k�pess�ge, amit a lesz�rmazottak val�s�tanak meg
	 */
	public abstract void kepesseg();
	
	
	
	
	
	/**
	 * Akkor fut amikor a j�t�kos k�re van. Megk�rdezi a felhaszn�l�t, hogy mit akar tenni, am�g tart a k�re
	 */
	public void KoreVan()
	{
		tartAKore = true;
		
		//what?
		/*while(tartAKore)
		{
			
		}*/
		
	}
	
	
	
	/**
	 * Akkor h�v�dik meg, ha nul�ra cs�kkent a J�t�kos Munkadb-je
	 */
	public void korVege()
	{
		Global.out.print("A jatekos vegzett a korevel. ");
		tartAKore = false;
	}
	
	
	/**
	 * Ezzel a f�ggv�nnyeltud majd l�pni a j�t�kos arra a j�gt�bl�ra, ami arra van, amerre n�z
	 */
	public boolean lepes()
	{
		if(Munkadb>0) {
				boolean ellephet=false;
				Jegtabla szJegtabla = aktjegtabla.szomszedKerdez(szogAmibeNez);
				if(szJegtabla != null ) {
					ellephet = aktjegtabla.ellep(this);
					Global.out.print("Van szomszed ebbe az iranyban.");
				}
				else
					Global.out.print("Nem sikerult az ellepes, mert ebbe az iranyba nincs jegtabla");
				
				if(ellephet)
				{
					
					String atfordulva=aktjegtabla.getAtVanFordulva() ? "at van fordulva" : "nincs atfordulva";
					Global.out.print("A jegtabla "+atfordulva+" .");
					if(szJegtabla != null )
					{
						szJegtabla.ralep(this);
						Global.out.print("Sikerult az ellepes. ");
						MunkaDBcsokkentese(1);
						return true;
					}
					else
					{
						Global.out.print("Nem sikerult az ellepes, mert ebbe az iranyba nincs jegtabla");
						return false;
					}
				}
				else {
					Global.out.print("Nem sikerult az ellepes, mert a jegtabla at van fordulva. ");
					return false;
				}
			}
		return false;
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
			Global.out.print("Elfogytak a munkaim. ");
			
			korVege();
		}
		else
		{
			Munkadb -= mennyivel;
			Global.out.print("MunkaDB sikeresen cs�kkentve. ");
		}
	}
	
	
	
	
	/**
	 * @return Visszaadja a j�t�kos aktj�gt�bla attrib�tum�t
	 */
	public Jegtabla JegtablaLekerdez()
	{
		return aktjegtabla;
	}
	
	
	
	
	/**
	 * Elt�vol�tja a param�terben megadott t�rgyat
	 * @param t - a t�rgy, amit el akarunk t�vol�tani
	 */
	public void targyEltavolitasa(Targy t)
	{
		this.TargyakListazasa();
		targyak.remove(t);
		Global.out.print("Targy eltavolitva. ");
		this.TargyakListazasa();
		
	}
	
	/**
	 * Megpr�b�lja felvenni a t�rgyat a j�gt�bl�r�l, amin �ll
	 */
	public boolean targyFelvetel()
	{
		Global.out.print(" A jatekos MunkaDB-ja: "+Munkadb+". ");
		boolean sikeres =false;
		if(Munkadb>0)
			sikeres = aktjegtabla.targyFelvesz(this);
		if(sikeres)
		{
			Global.out.print(" A targyfelvetel sikerult");
			this.MunkaDBcsokkentese(1);
		}
		else
			Global.out.print("A targyfelvetel nem sikerult");
		Global.out.print(" A jatekos MunkaDB-ja: "+Munkadb+". ");
		return sikeres;
	}
	
	
	/**
	 * Megh�vja a megadott index� t�rgyra a haszn�l f�ggv�nyt
	 * @param idx - annak a T�rgynak az indexe, amit haszn�lni akarunk
	 */
	public boolean targyHasznalat(int idx)
	{
		Global.out.print("A jatekosnak MunkaDB-ja: "+Munkadb+". ");
		if(targyak != null && Munkadb>0)
		{
			if(targyak.size() > idx)
			{
				boolean sikeres = targyak.get(idx).hasznal(this);
				if(sikeres)System.out.println("igen");
				if(sikeres)
				{
					Global.out.print("A targyhasznalat sikerult. ");
					Munkadb--;
					return true;
				}
				else 
					Global.out.print("A targy hasznalat nem sikerult. ");
			}
			else
			{
				Global.out.print("A targy hasznalat nem sikerult, mert nincsenen ilyen indexu targya a jatekosnak. ");
			}
		}
		else
		{
			Global.out.print("A targy hasznalat nem sikerult, mert nincsenek targyai a jatekosnak, vagy nincs eleg munkaDB-ja. ");
		}
		Global.out.print("A jatekosnak MunkaDB-ja: "+Munkadb+". ");
		return false;
			
	}
	
	
	
	/**
	 * @param t - t�rgyat hozz�adja a j�t�kos t�rgyaihoz
	 */
	public boolean targyHozzadasa(Targy t)
	{
		if(targyak == null)
			targyak = new ArrayList<>();
		
		targyak.add(t);
		Global.out.print("Targy hozzaadva. ");
		return true;
	}
	
	
	
	/**
	 * @param mennyivel - noveli a testhot ezzel az �rt�kkel, de a testh�t 
	 * max 6-ig tudjuk n�velni.
	 * @return visszat�r azzal, hogy 
	 */
	public boolean testhoNovelese(int mennyivel)
	{
		Global.out.print("Jatekos testhoje: "+testho+". ");
		testho+= mennyivel;
		if (testho > 6) {
			testho=6;
			Global.out.print(" Nem sikerult a noveles, mert a testhot 6-ig lehet csak n�velni.");
			Global.out.print("Jatekos testhoje: "+testho+". ");
			return false;
		}
		else
		{
			Global.out.print("Testho sikeresen novelve. ");
			Global.out.print("Jatekos testhoje: "+testho+". ");
			return true;
		}
	}
	
	
	
	/**
	 * @return Visszaadja a j�gmez�t, amin a j�t�kos van
	 */
	public Jegmezo getJegmezo()
	{
	
		return jegmezo;
	}
	
	/**
	 * �t�ll�tja a j�t�kos aktjegtabla attrib�tum�t
	 * @param jt - A j�gt�bla, amire �t akarjuk �ll�tani
	 */
	public void setaktjegtabla(Jegtabla jt)
	{
		
		aktjegtabla  = jt;
	}
	
	
	/**
	 * Kilist�zza a konzolra a j�t�kos t�rgyait
	 */
	public void TargyakListazasa()
	{
		if(targyak != null)
		{
			Global.out.print("A jatekos targyai: ");
			for(int i = 0; i < targyak.size(); i++)
				Global.out.println((i + 1) + ". - " + targyak.get(i).toString()+ " ");
		}
		else
		{
			Global.out.print("Nincsenek targyai a jatekosnak. ");
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
	

	
	/**
	 * @return Visszaadja a J�t�kos iranyAmibeNez-�t
	 */
	/*public Irany getIranyAmibeNez()
	{
		System.out.println("Engem, mint jatekost, epp arrol kerdeznek, hogy merre nezek");
		return iranyAmibeNez;
	}*/
	
	/**
	 * @return Visszaadja a J�t�kos �ltal t�rolt jelz�pisztoly darabok sz�m�t
	 */
	public int getjelzopisztolydb()
	{
		
		return jelzopisztolydb;
	}
	
	
	/**
	 * Be�ll�tja a j�t�kost, hogy abba az ir�nyba n�zzen, amit megadunk
	 * @param i - Az ir�ny, amibe szeretn�nk, hogy n�zzen a J�t�kos
	 */
	/*public void setIranyAmibeNez(Irany i)
	{
		System.out.println("Most epp a jatekos iranyAmibeNez tulajdonsagat allitjak");
		
		iranyAmibeNez = i;
	}*/
	
	public int getSzogAmibeNez()
	{
		return this.szogAmibeNez;
	}
	
	public void setSzogAmibeNez(int szog)
	{
		this.szogAmibeNez = szog;
		
	}
	
	public void Fordul(boolean Jobbra)
	{
		
		szogAmibeNez = aktjegtabla.adottSzogbeLevoSzomszedMellettiSzomszedSzoge(szogAmibeNez, Jobbra);
		
	}
	
	
	/** Be�ll�tja a megadott �rt�kre a j�t�kos tartAKore attrib�tum�t
	 * @param tk - az �rt�k, amire a j�t�kos tartAKore attrib�tum�t �ll�tani szeretn�nk
	 */
	public void setTartAKore(boolean tk)
	{
		tartAKore = tk;
	}
	
	public List<Targy> getTargyak()
	{
		return targyak;
	}
	
}
