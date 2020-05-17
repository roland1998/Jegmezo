package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawIglu.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class DrawIglu extends Drawable {

	/**
	 * Bet�lti az iglu k�p�t
	 */
	public DrawIglu() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/iglu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja az iglut
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80+40, getPositionY()*80, null);
	}
	
	
}
