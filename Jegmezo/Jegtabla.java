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

import java.util.TreeMap;

public class Jegtabla implements Frissitheto
{
	private Jegmezo jegmezo;
	private boolean atVanFordulva;
	private int ho;
	private int tartokepesseg;
	
	private TreeMap<Integer, Integer> szomszedokSorszambolSzogge;
	private TreeMap<Integer, Integer> szomszedokSzogbolSorszamma;
	private List<Jegtabla> szomszedokASorszamhoz;
	
	private int szomszedokSzama;
	
	private Vedelem jegtablaVedelme;
	private List<Jatekos> jatekosok;
	private List<Jegesmedve> jegesmedvek;
	private Targy targy;
	
	public String ID;
	
	
	/**
	 * A j�gt�bla konstruktora, ami l�trehozza j�gt�bl�t, a megadott param�terekkel
	 * @param jegmezo - A j�gmez�, amin van
	 * @param atVanFordulva - azt adja meg, hogy �t van-e fordulva
	 * @param ho - a kezdeti h�mennyis�get adja meg
	 * @param tartokepesseg - a tart�k�pess�g�t adja meg
	 * @param targy - a benne l�v� t�rgyat adja meg. Ha nincs benne t�rgy, akkor null legyen az �rt�ke
	 */
	public Jegtabla(Jegmezo jegmezo,
	boolean atVanFordulva,
	int ho,
	int tartokepesseg,
	int szomszedokSzama)
	{
		this.jegmezo = jegmezo;
		
		this.atVanFordulva =atVanFordulva;
		this.ho = ho;
		this.tartokepesseg = tartokepesseg;
		
		this.szomszedokSzama = szomszedokSzama;
		
		szomszedokSorszambolSzogge = new TreeMap<>(); 
		szomszedokSzogbolSorszamma = new TreeMap<>(); 
		
		szomszedokASorszamhoz  = new ArrayList<>(this.szomszedokSzama);
	
		for(int i  = 0; i < this.szomszedokSzama; i++)
			szomszedokASorszamhoz.add(null);
		
		jegtablaVedelme = null;
		
		jatekosok = new ArrayList<>(); 
		this.targy = null;
		this.jegmezo.addFrissitheto(this);
		jegesmedvek = new ArrayList<>();
		
		Global.out.print("Jegtabla siekresen letrehozva. ");
	}
	
	
	public Jegtabla(String id,
			Jegmezo jegmezo,
			boolean atVanFordulva,
			int ho,
			int tartokepesseg,
			int szomszedokSzama)
			{
		ID = id;
				this.jegmezo = jegmezo;
				
				this.atVanFordulva =atVanFordulva;
				this.ho = ho;
				this.tartokepesseg = tartokepesseg;
				
				this.szomszedokSzama = szomszedokSzama;
				
				szomszedokSorszambolSzogge = new TreeMap<>(); 
				szomszedokSzogbolSorszamma = new TreeMap<>(); 
				
			
				szomszedokASorszamhoz = new ArrayList<>(this.szomszedokSzama);
			
				for(int i  = 0; i < this.szomszedokSzama; i++)
					szomszedokASorszamhoz.add(null);
				
				jegtablaVedelme = null;
				
				jatekosok = new ArrayList<>(); 
				this.targy = null;
				this.jegmezo.addFrissitheto(this);
				jegesmedvek = new ArrayList<>();
				
				Global.out.print("Jegtabla sikeresen letrehozva. ");
			}
	
	
	/**
	 * Felveszi a j�t�kost a t�bl�ra �s �t�ll�tja az aktjegtabla attrib�tum�t
	 * @param j - a j�t�kos, akit hozz� akarunk adni a t�bl�hoz
	 * @return visszaadja, hogy siker�lt-e felvenni a j�t�kost a j�gt�bl�ra
	 */
	public void addJatekos(Jatekos j)
	{
		
			Global.out.print("A jegtablan "+jatekosok.size()+" jatekos all. ");
			j.setaktjegtabla(this);
			if(this.szomszedokSorszambolSzogge.get(0) != null)
				j.setSzogAmibeNez(this.szomszedokSorszambolSzogge.get(0));
			else
			{
				j.setSzogAmibeNez(0);
				
				System.out.println("Nincs 0 szomszed beallitva");
				System.out.println("Nincs 0 szomszed beallitva");
				System.out.println("Nincs 0 szomszed beallitva");
				System.out.println("Nincs 0 szomszed beallitva");
				System.out.println("Nincs 0 szomszed beallitva");
			}
			jatekosok.add(j);
			Global.out.print("Jatekos sikeresen hozzaadva a jegtablahoz. ");
			Global.out.print("A jegtablan "+jatekosok.size()+" jatekos all. ");
	}
	
	/**
	 * Hozz�adja a param�terben megadott jegesmedv�t a j�gt�bl�hoz �s be�ll�tja a jegesmedbe jegtablaAminAll attrib�tum�t
	 * @param j - A jegesmedve, akot hozz� akarunk adni a J�g�bl�hoz
	 */
	public void addJegesmedve(Jegesmedve j)
	{
			Global.out.print("A jegtablan "+jegesmedvek.size()+" jatekos all. ");
			j.setjegtablaAminAll(this);
			if(this.szomszedokSorszambolSzogge.get(0)!=null)
				j.setSzogAmibeNez(this.szomszedokSorszambolSzogge.get(0));
			else
				j.setSzogAmibeNez(this.szomszedokSorszambolSzogge.get(2));
			jegesmedvek.add(j);
			Global.out.print("Jegesmedve siekresen hozzaadva a jegtablahoz. ");
			Global.out.print("A jegtablan "+jegesmedvek.size()+" jatekos all. ");
	}
	
	/**
	 * Cs�kkenti a J�gt�bla h� mennyis�g�t i-vel, ha nulla al� megy a h�, akkor -1-re �ll�tjuk a h�mennyis�get �s a rajta l�v� t�rgyat ki�sottnak tekintj�k.
	 * Ha -1 vagy az alatti a h� mennyis�g nem t�rt�nik semmi
	 * @param i - A mennyis�g, amivel a havat cs�kkenteni szeretn�nk
	 * @return Visszaadja, hogy t�rt�nt-e �s�s
	 */
	public boolean asas(int i)
	{
		Global.out.print("A ho mennyisege a jegtablan: "+ho+" .");
		if(ho >= 0)
		{
			//int tempHo = ho;
			
			ho -= i;
			if(ho <= -1)
			{
				ho = -1;
			}
			Global.out.print("A ho mennyisege a jegtablan: "+ho+" .");
			return true;
		}
		else
		{
			Global.out.print(" Nincs ho a jegtablan, nem sikerult az asas. A hoszint maradt: " + ho);
			return false;
		}
		
		
	}
	

	
	/**
	 * �tford�tja a t�bl�t �s t�rli a rajta l�v� v�delmet
	 */
	public void atfordit()
	{
		atVanFordulva = true;
		this.jegtablaVedelme = null;
		Global.out.print("Jegtabla atfordult. ");
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
			Global.out.print("A jegtabla at van fordulva, ellepes siekrtelen. ");
			return false;
		}
		else
		{
			this.jatekosEltavolit(j);
			Global.out.print("A jatekos sikeresen ellepett. ");
			return true;
		}
	}

	
	
	/**
	 * �j k�r elej�n megn�zi, hogy �t van-e fordulva �s ha igen �s vannak rajta j�t�kosok, akkor sz�l a j�gmez�nek, 
	 * hogy ezek a j�t�kosok meghaltak.
	 * Ha �t van fordulva �s nincs rajta senki akkor visszaford�tjuk a j�gt�bl�t
	 * Megh�vja a rajtal�v� v�delem frissites f�ggv�ny�t
	 */
	public void frissit()
	{	
		Global.out.print("A jegtabla tartokepessege: "+tartokepesseg+
				" , a rajta levo jateksok szama: "+ jatekosok.size()+", a vedelme: ");
				//+jegtablaVedelme.toString()+". ");
		if(jegtablaVedelme != null)
			jegtablaVedelme.frissit();
		
		
		if(atVanFordulva) {
			Global.out.print("Jegtabla at van fordulva. ");
			for(int i = 0; i < jatekosok.size(); i++)
			{
				
				jegmezo.meghalt(jatekosok.get(i));
			}
				
		
			if(jatekosok.size() == 0)
			{
				Global.out.print("Jegtabla sikeresen visszafordulva. ");
				visszaFordit();
			}
		}
		
		String vedelem = jegtablaVedelme == null? "Semmi": jegtablaVedelme.toString();
		Global.out.print("Jegtabla sikeresen frissitve. ");
		Global.out.print("A jegtabla tartokepessege: "+tartokepesseg+
				" , a rajta levo jateksok szama: "+ jatekosok.size()+", a vedelme: "+
				vedelem +". ");
	}
	


	
	/**
	 * n�veli a havat a j�gt�bl�n
	 */
	public void hoNovelese()
	{
		
		ho++;
		Global.out.print("Ho mennyisege siekresen megnovelve. ");
	}
	
	
	/**
	 *megh�vja a honoveles f�gv�nyt
	 */
	public void hovihar()
	{
		Global.out.print("A tablan levo ho: "+ho+". ");
		
		this.hoNovelese(); 
		
		if(jegtablaVedelme!=null){
			jegtablaVedelme.hovihar();
		}
		Global.out.print("A tablan levo ho: "+ho+". ");
		
	}
	

	
	
	/**
	 * Elt�vol�tja param�terben megadott j�t�kost a j�gt�bla j�t�kosai k�z�l
	 * @param j - A J�t�kos, akit el akarunk t�vol�tni
	 */
	public void jatekosEltavolit(Jatekos j)
	{
		jatekosok.remove(j);
		Global.out.print("Jatekos siekresen eltavolitva a tablarol. ");
	}
	
	

	
	public List<Jatekos> jatekosokLekerdez()
	{
		return jatekosok;
	}
	
	
	
	/**
	 * Elt�vol�tja a param�terben megadott jegesmedv�t a j�gt�bl�r�l
	 * @param j - A jegesmedve, akit el akarunk t�vol�tani a J�gt�bl�r�l
	 */
	public void JegesmedveEltavolit(Jegesmedve j)
	{
		jegesmedvek.remove(j);
		Global.out.print("Jegesmedve sikeresen eltavolitva a tablarol. ");
	}
	
	
	/**
	 * Elt�vol�tja a J�gt�bl�n l�v� v�delmet
	 */
	public void jegtablaVedelmenekEltavolitasa()
	{
		jegtablaVedelme = null;
		Global.out.print("Jegtabla vedelme sikeresen eltavolitva. ");
	}
	
	
	/**
	 * R�l�pteti a megadott j�t�kost a t�bl�ra �s ha j�t�kosok sz�ma �gy meghaladja a tart�k�pess�get, �tford�tja a t�bl�t
	 * @param j - A J�t�kos, aki r�l�p a t�bl�ra 
	 */
	public void ralep(Jatekos j)
	{
		j.setaktjegtabla(this);
		if(this.szomszedokSorszambolSzogge.get(0) != null)
		j.setSzogAmibeNez(this.szomszedokSorszambolSzogge.get(0));
		else
		{
			System.out.println("\n\n\n relep: Null a szomszed\n\n\n\n");
		}
		jatekosok.add(j);
		Global.out.print("A jegtablahoz a jatekos sikeresen hozzaadva. ");
		
		
		if(jatekosok.size() > tartokepesseg)
			atfordit();
			
	}
	

	
	/**
	 * visszaadja a j�gt�bla i ir�nyban l�v� szomsz�dj�t 
	 * @param i - az ir�ny amibe tudni szeretn�nk a szomsz�dot
	 * @return visszaadja az i ir�nyban l�v� szomsz�dot
	 */
	//�j
	public Jegtabla szomszedKerdez(Integer szogbe)
	{
		
		if(this.szomszedokSzogbolSorszamma == null)
			System.out.println("\n\n\n szomszedokSzogbolSorszamma null \n\n\n");
		
		System.out.println("\nszog: " + szogbe);
		System.out.println("\n sorszam: " + this.szomszedokSzogbolSorszamma.get(szogbe));
		
		
		return this.szomszedokASorszamhoz.get(
				this.szomszedokSzogbolSorszamma.get(szogbe));
	}
	
	//�j
	public Integer adottSzogbeLevoSzomszedMellettiSzomszedSzoge(Integer szog, boolean jobbra)
	{
		Integer sorszam = this.szomszedokSzogbolSorszamma.get(szog);
		if(sorszam == null)
			System.out.println("\n\n\nadottSzogbeLevoSzomszedMellettiSzomszedSzoge: null a sorszam \n\n\n");
		if(jobbra)
		{
			
			Integer jobbraLevoSzomszedSorszama = (sorszam == szomszedokSzama - 1)? 0: sorszam + 1;
			
			return this.szomszedokSorszambolSzogge.get(jobbraLevoSzomszedSorszama);
				
		}
		else
		{
			Integer balraLevoSzomszedSorszama = (sorszam == 0)? szomszedokSzama - 1: sorszam - 1;
			return this.szomszedokSorszambolSzogge.get(balraLevoSzomszedSorszama);
		}
	}
	
	
	
	/**
	 * Megh�vja a rajtal�v� t�rgy felvesz f�ggv�ny�t, ha a h� rajta -1
	 * @param j - a J�t�kos, aki fel akarja venni a t�rgyat
	 * @return Visszaadja, hogy sikeres volt-e a t�rgyfelv�tel
	 */
	public boolean targyFelvesz(Jatekos j)
	{
		Global.out.print("A jegtablan levo ho mennyisege: "+ho+". ");
		if(ho == -1)
		{
			if(targy != null)
			{
				boolean sikeres =  targy.felvesz(j);
				if(sikeres)
				{
					Global.out.print("A jegtablarol valo targy felvetel sikeres volt. ");
					targy = null; // t�r�lj�k a t�rgyat a t�bl�r�l
					
				}
				
				else 
					Global.out.print("A jegtablarol valo targy felvetel nem volt sikeres. ");
				
				
				return sikeres;
			}
			else
			{
				Global.out.print("A jegtablan nincs targy. ");
				return false;
			}
		
		}
		else
		{
			Global.out.print("A jegtablan levo targyat meg ho takarja. ");
			return false;
		}
	}
	
	
	/**
	 * Visszaford�tja a t�bl�t
	 */
	public void visszaFordit()
	{
		atVanFordulva = false;
		Global.out.print("A jegtabla sikeresen visszafordult. ");
	}
	
		
	
	/**
	 * @return Visszaadja, hogy a j�gt�bla �t van-e fordulva
	 */
	public boolean getAtVanFordulva()
	{
		
		return atVanFordulva;
	}
	
	
	
	
	/**
	 * @return Visszadja a jegtabla homennyiseget
	 */
	public int getHo()
	{
		
		return ho;
	}
	
	

	/**
	 * @return Visszaadja a j�gt�bl�n l�v� v�delmet vagy nullt, ha nincs rajta v�delem
	 */
	public Vedelem getjegtablaVedelme()
	{
		
		return jegtablaVedelme;
	}
	
	
	
	/**
	 * @return Visszaadja, hogy h�ny j�t�kost b�r el a J�gt�bla
	 */
	public int gettartokepesseg()
	{
		
		return tartokepesseg;
	}
	

	/**
	 * Be�ll�tja a j�gt�bla v�delm�t a megadott V�delemre
	 * @param v - A v�delem, amit be akarunk �ll�tani a J�gt�bl�ra
	 */
	public void setjegtablaVedelme(Vedelem v)
	{
		if(jegtablaVedelme!=null)
			Global.out.print("A jegtabla vedelme: "+jegtablaVedelme.toString()+". ");
		else
			Global.out.print("A jegtablan nincs vedelem. ");
		v.setJegtablaAminVan(this);
		
		jegtablaVedelme = v;
		Global.out.print("A jegtabla vedelme sikeresen atallitva. ");
		Global.out.print("A jegtabla vedelme: "+jegtablaVedelme.toString()+". ");
	}

	/**
	 * Hozz�adja a megadott ir�ny� szomsz�daihoz a megadott j�gt�bl�t
	 * @param j - a j�gt�bla, amit fel akarunk venni a szomsz�dok k�z�
	 * @param i - azt adja meg, hogy a j�gt�bl�nak melyik ir�nyba lesz a szomsz�dja
	 */
	public void setSzomszed(Jegtabla j, Integer hanyadikSzomszed, Integer melyikSzogbol)
	{
		
		
		szomszedokSorszambolSzogge.put(hanyadikSzomszed, melyikSzogbol);
		szomszedokSzogbolSorszamma.put(melyikSzogbol, hanyadikSzomszed);
		
		szomszedokASorszamhoz.add(hanyadikSzomszed, j);
		
		//(Jobb(0), Bal(1), Fel(2),Le(3))
		/*switch(i) {
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
			
		szomszedok.set(idx, j);*/
		Global.out.print("Szomszed sikeresen beallitva. ");
	}
	
	
	/**
	 * �t�ll�tja a j�gt�bla t�rgy�t a megadott t�rgyra
	 * @param t - a t�rgy, amire �t akarjuk �ll�tani
	 */
	public void setTargy(Targy t)
	{
		
		targy = t;
		Global.out.print("A jegtablahoz a targy sikeresen at lett allitva. ");
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jegtabla";
	}
	
	public int getJatekosokSzama()
	{
		if(this.jatekosok != null)
			return this.jatekosok.size();
		else
			return 0;
	}
	
	public Targy getTargy()
	{
		return this.targy;
	}
	
	public int getSzomszedokSzama()
	{
		return szomszedokSzama;
	}
	

}
