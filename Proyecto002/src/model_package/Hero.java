package model_package;

import java.awt.Color;
import java.awt.Graphics;

public class Hero implements Drawable,Movable{
	
	public int [] cord_x = {400,450,350};
	public int [] cord_y = {500,550,550};
	
	
	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillPolygon(cord_x, cord_y, 3);
		
	}
	@Override
	public void moveUp(int variable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveDown(int variable) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void moveLeft(int variable) {
		//restar
		for(int i=0; i < cord_x.length;i++) {
			cord_x[i] = cord_x[i] - variable;
		}
		
	}
	@Override
	public void moveRight(int variable) {
		//sumar
		
		for(int i=0; i < cord_x.length;i++) {
			cord_x[i] = cord_x[i] + variable;
		}
	}
	@Override
	public void draw(Graphics graphics, Drawable drawable) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
