package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawElelem.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawElelem extends Drawable {
	
	/**
	 * Bet�lti az �lelem k�p�t
	 */
	public DrawElelem() 
	{
		try {
			img=ImageIO.read(new File("./Jegmezo/image/fish.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Kirajzolja az �lelemet
	 */
	public void draw(Graphics g) {
		
		g.drawImage(img, getPositionX()*80, getPositionY()*80+40, null);
	}
	
}
