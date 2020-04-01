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
	private Vedelem jegtablaVedelme;
	private List<Jatekos> jatekosok;
	private List<Jegesmedve> jegesmedvek;
	private Targy targy;
	
	
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
	Targy targy)
	{
		this.jegmezo = jegmezo;
		
		this.atVanFordulva =atVanFordulva;
		this.ho = ho;
		this.tartokepesseg = tartokepesseg;
		szomszedok = new ArrayList<>(); 
		
		for(int i = 0; i < 4; i++)
			szomszedok.add(null);
		
		jegtablaVedelme = null;
		
		jatekosok = new ArrayList<>(); 
		this.targy = targy;
		this.jegmezo.addFrissitheto(this);
		jegesmedvek = new ArrayList<>();
		
		System.out.println("Letrehoztak egy jegtablat");
	}
	
	/**
	 * Hozz�adja a megadott ir�ny� szomsz�daihoz a megadott j�gt�bl�t
	 * @param j - a j�gt�bla, amit fel akarunk venni a szomsz�dok k�z�
	 * @param i - azt adja meg, hogy a j�gt�bl�nak melyik ir�nyba lesz a szomsz�dja
	 */
	public void setSzomszed(Jegtabla j, Irany i)
	{
		System.out.println("Nekem a jegtablanak epp a szomszedjat allitjak be ");
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
		System.out.println("Szomszed beallitva ");
	}
	
	
	/**
	 * Felveszi a j�t�kost a t�bl�ra �s �t�ll�tja az aktjegtabla attrib�tum�t
	 * @param j - a j�t�kos, akit hozz� akarunk adni a t�bl�hoz
	 * @return visszaadja, hogy siker�lt-e felvenni a j�t�kost a j�gt�bl�ra
	 */
	public void addJatekos(Jatekos j)
	{
		
		System.out.println("Jegtabla: Epp egy jatekost adnak hozzam ");
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
		System.out.println("Jegtabla: Epp asni akarnak rajtam " + i + " mennyisegu havat");
		if(ho >= 0)
		{
			int tempHo = ho;
			
			ho -= i;
			if(ho <= -1)
			{
				ho = -1;
				System.out.println("Jegtabla: Kiastad a rajtam levo targyat");
			}
			System.out.println("Jegtabla: Van rajtam ho szoval ezt megtehetik a hoszintem " + tempHo + "-rol " +  ho + "-ra csokkent");
			
			return true;
		}
		else
		{
			System.out.println("Jegtabla: Nincs rajtam ho szoval ezt nem tehetik meg a hoszintem maradt: " + ho);
			return false;
		}
		
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
	 * �tford�tja a t�bl�t �s t�rli a rajta l�v� v�delmet
	 */
	public void atfordit()
	{
		atVanFordulva = true;
		System.out.println("Jaj! Felfordult a t�bla!");
		this.jegtablaVedelme = null;
	}
	
	/**
	 * Azt adja meg, hogy a J�tekos elhagyhatja-e a J�gt�bl�t 
	 * @param j - Am j�t�kos aki el akarja hagyni a J�gt�bl�t
	 * @return Visszaadja, hogy a J�t�kos elhagyhatja-e a J�gt�bl�t
	 */
	public boolean ellep(Jatekos j)
	{
		System.out.println("Jegtabla: egy jatekos megproba ellepni rolam");
		if(atVanFordulva)
		{
			System.out.println("A jegtabla at van fordulva, a jatekos csak buvarruhaval hagyhatja el");
			return false;
		}
		else
		{
			this.jatekosEltavolit(j);
			System.out.println("A jatekos elhagyhatja a jegtablat es el lett tavoitva innen");
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
		System.out.println("Jegtabla: epp frissitenek");
		System.out.println("Jegtabla: frissitem a vedelmemet is");
		if(jegtablaVedelme != null)
			jegtablaVedelme.frissit();
		
		
		if(atVanFordulva) {
			System.out.println("Jegtabla: epp frissitenek es at vagyok fordulva");
			for(int i = 0; i < jatekosok.size(); i++)
			{
				System.out.println("Jegtabla: ezert a jatekosok, akik rajtam vannak halalnak fiai");
				jegmezo.meghalt(jatekosok.get(i));
			}
				
		
			if(jatekosok.size() == 0)
			{
				System.out.println("Jegtabla: Nincs rajtam senki ezert visszafordulok");
				visszaFordit();
			}
		}
	}
	
	/**
	 * @return Visszaadja, hogy h�ny j�t�kost b�r el a J�gt�bla
	 */
	public int gettartokepesseg()
	{
		System.out.println("Jegtabla: epp a tartokepessegem kerdezik");
		return tartokepesseg;
	}
	
	/**
	 * n�veli a havat a j�gt�bl�n
	 */
	public void hoNovelese()
	{
		System.out.println("Jegtabla: epp a hoszintemet novelik");
		ho++;
		System.out.println("Ho mennyisege megnovelve");
	}
	
	
	/**
	 *megh�vja a honoveles f�gv�nyt
	 ** Megh�vja a rajtal�v� v�delem hovihar f�ggv�ny�t
	 */
	public void hovihar()
	{
		System.out.println("Jegtabla: epp hoviharban vagyok");
		
		System.out.println("Jegtabla: a hovihar kovetkezteben no rajtam a ho");
		this.hoNovelese();
	}
	

	
	/**
	 * Elt�vol�tja param�terben megadott j�t�kost a j�gt�bla j�t�kosai k�z�l
	 * @param j - A J�t�kos, akit el akarunk t�vol�tni
	 */
	public void jatekosEltavolit(Jatekos j)
	{
		System.out.println("Jegtabla: epp eltavolitanak rolam egy jatekost");
		jatekosok.remove(j);
		System.out.println("Jatekos eltavolitva a tablarol");
	}
	
	
	
	/**
	 * Hozz�adja a param�terben megadott jegesmedv�t a j�gt�bl�hoz �s be�ll�tja a jegesmedbe jegtablaAminAll attrib�tum�t
	 * @param j - A jegesmedve, akot hozz� akarunk adni a J�g�bl�hoz
	 */
	public void addJegesmedve(Jegesmedve j)
	{
		System.out.println("Jegtabla: epp hozzamadnak egy jegesmedvet");
		System.out.println("Jegesmedve a jegtablara elhelyezve");
			j.setjegtablaAminAll(this);
		
			jegesmedvek.add(j);
	}
	
	
	
	/**
	 * Elt�vol�tja a param�terben megadott jegesmedv�t a j�gt�bl�r�l
	 * @param j - A jegesmedve, akit el akarunk t�vol�tani a J�gt�bl�r�l
	 */
	public void JegesmedveEltavolit(Jegesmedve j)
	{
		System.out.println("Jegtabla: epp eltavolitanak rolam egy jegesmedvet");
		jegesmedvek.remove(j);
		System.out.println("Jegesmedve eltavolitva a tablarol");
	}
	
	public List<Jatekos> jatekosokLekerdez()
	{
		System.out.println("Jegtabla: epp a jatekosaimat kerdezik le");
		return jatekosok;
	}
	
	/**
	 * R�l�pteti a megadott j�t�kost a t�bl�ra �s ha j�t�kosok sz�ma �gy meghaladja a tart�k�pess�get, �tford�tja a t�bl�t
	 * @param j - A J�t�kos, aki r�l�p a t�bl�ra 
	 */
	public void ralep(Jatekos j)
	{
		System.out.println("Jegtabla: epp ram lep egy jatekos");
		j.setaktjegtabla(this);
		System.out.println("Jegtabla: hozzaadom a jatekos gyujtemenyembe");
		jatekosok.add(j);
		System.out.println("Jegtabla: A jatekos ralepett a tablara");
		
		System.out.println("Jegtabla: Most megnezem, hogy nincsenek-e rajtam sokan es ha igen, akkor atforditom magam");
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
		System.out.println("Jegtabla: Epp a szomszedomat kerdezik");
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
		System.out.println("Jegtabla: megadom nekik a szomszedomat");
		return szomszedok.get(idx);
	}
	
	
	/**
	 * Megh�vja a rajtal�v� t�rgy felvesz f�ggv�ny�t, ha a h� rajta -1
	 * @param j - a J�t�kos, aki fel akarja venni a t�rgyat
	 * @return Visszaadja, hogy sikeres volt-e a t�rgyfelv�tel
	 */
	public boolean targyFelvesz(Jatekos j)
	{
		System.out.println("Jegtabla: megprobaljak felvenni rolam a targyat");
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
	 * @return Visszaadja, hogy a j�gt�bla �t van-e fordulva
	 */
	public boolean getAtVanFordulva()
	{
		System.out.println("Jegtabla: most azt kerdzik, hogy at vagyo-e forditva");
		return atVanFordulva;
	}
	
	/**
	 * �t�ll�tja a j�gt�bla t�rgy�t a megadott t�rgyra
	 * @param t - a t�rgy, amire �t akarjuk �ll�tani
	 */
	public void setTargy(Targy t)
	{
		System.out.println("Jegtabla: most epp a rajtam levo targyat akarjak allitani");
		targy = t;
		System.out.println("Jegtabla: Targy atallitva");
	}
	
	
	/**
	 * Be�ll�tja a j�gt�bla v�delm�t a megadott V�delemre
	 * @param v - A v�delem, amit be akarunk �ll�tani a J�gt�bl�ra
	 */
	public void setjegtablaVedelme(Vedelem v)
	{
		v.setJegtablaAminVan(this);
		System.out.println("Jegtabla: most epp a rajtam levo vedelemet allitjak at");
		jegtablaVedelme = v;
		System.out.println("Jegtabla: Vedelem atallitva");
	}
	
	
	/**
	 * Elt�vol�tja a J�gt�bl�n l�v� v�delmet
	 */
	public void jegtablaVedelmenekEltavolitasa()
	{
		System.out.println("Jegtabla: most epp a rajtam levo vedelmet eltavolitjak");
		jegtablaVedelme = null;
		System.out.println("Jegtabla vedelme eltavolitva");
	}
	
	
	/**
	 * @return Visszaadja a j�gt�bl�n l�v� v�delmet vagy nullt, ha nincs rajta v�delem
	 */
	public Vedelem getjegtablaVedelme()
	{
		System.out.println("Jegtabla: most epp a rajtam levo vedelemet kerdezik le");
		return jegtablaVedelme;
	}
	
	/**
	 * @return Visszadja a jegtabla homennyiseget
	 */
	public int getHo()
	{
		System.out.println("Jegtabla: most epp a rajtam levo homennyiseget kerdezik");
		return ho;
	}
	
	/**
	 * Visszaadja, hogy mi ez az objektum
	 */
	public String toString()
	{
		return "Jegtabla";
	}
	
}
