package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawRaketa.java
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
 * A rak�ta kirajzol�s�t val�sitja meg
 */
public class DrawRaketa extends Drawable {
	
	/**
	 * Bet�lti a rak�ta k�p�t
	 */
	public DrawRaketa() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/light.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja a rak�t�t
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80, getPositionY()*80+40, null);
	}
	
}
