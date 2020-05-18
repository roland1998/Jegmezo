package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawTorekenyAso.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Henrik
 * A torekenyaso kirajzol�s�t val�sitja meg
 */
public class DrawTorekenyAso extends Drawable {

	/**
	 * Bet�lti a t�r�keny�s� k�p�t
	 */
	public DrawTorekenyAso() {
		try {
			img=ImageIO.read(new File("./Jegmezo/image/tshovel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a t�r�keny�s�t
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80, getPositionY()*80+40, null);
	}
	
}
