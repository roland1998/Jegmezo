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

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;

public class DrawIglu extends Drawable {
	private Image igluImage;
	
	public DrawIglu() 
	{
		try {
			igluImage=ImageIO.read(new File("./Jegmezo/image/iglu.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		
		g.drawImage(igluImage, getPositionX()*80+40, getPositionY()*80, null);
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
