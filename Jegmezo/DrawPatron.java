package Jegmezo;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : DrawPatron.java
//  @ Date : 2020. 05. 05.
//  @ Author : 
//
//

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class DrawPatron extends Drawable {
	private Image patronImage;
	
	public DrawPatron() 
	{
		try {
			patronImage=ImageIO.read(new File("./Jegmezo/image/patron.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		
		g.drawImage(patronImage, getPositionX(), getPositionY(), null);
	}
	
	public void setPosition(int px, int py) 
	{
		super.setPosition(px, py);
	}
	public void setPositionX(int px) 
	{
		super.setPositionX(px);
	}
	public void setPositionY(int py) 
	{
		super.setPositionY(py);
	}
	public int getPositionX() 
	{
		return super.getPositionX();
	}
	public int getPositionY() 
	{
		return super.getPositionY();
	}
}
