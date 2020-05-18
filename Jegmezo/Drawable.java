package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Drawable.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.awt.Graphics;
import java.awt.Image;

/**
 * @author Henrik
 * A kirajzolhat� objektumok absztrakt �soszt�lya
 */
public abstract class Drawable {
	
	/**
	 * A kirajzoland� poz�ci�j�nk x koordin�t�ja
	 */
	private int positionx;
	
	/**
	 * A kirajzoland� poz�ci�j�nk y koordin�t�ja
	 */
	private int positiony;
	
	/**
	 * A kirajzolad� k�p
	 */
	protected Image img;
	/**
	 * Kirajzolja a megadott graphics objectre mag�t
	 * @param g - a graphics object, amire rajzolunk
	 */
	public abstract void draw(Graphics g);
	
	/** Be�ll�tja a kirajzolhat� pozici�j�t a megadott koordin�t�ba
	 * @param px - a Pont x koordin�t�ja
	 * @param py - a Pont y koordin�t�ja
	 */
	public void setPosition(int px, int py) {
		positionx=px;
		positiony=py;
	}
	
	/**
	 * A poz�ci� x koordin�t�j�t �ll�tja 
	 * @param px - amire az x koordin�t�t akarjuk �ll�tani
	 */
	public void setPositionX(int px) {
		positionx=px;
	}
	
	/**
	 * A poz�ci� y koordin�t�j�t �ll�tja 
	 * @param py - amire az ykoordin�t�t akarjuk �ll�tani
	 */
	public void setPositionY(int py) {
		positiony=py;
	}
	
	/**
	 * @return A kirajzolhat� poz�ci�j�nak az x koordin�t�j�t adja vissza
	 */
	public int getPositionX() {
		return positionx;
	}
	
	/**
	 * @return A kirajzolhat� poz�ci�j�nak az y koordin�t�j�t adja vissza
	 */
	public int getPositionY() {
		return positiony;
	}
}
