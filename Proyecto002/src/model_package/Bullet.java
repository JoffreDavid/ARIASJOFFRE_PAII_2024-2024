package model_package;

import java.awt.Color;
import java.awt.Graphics;

import model_package.Hero;



public class Bullet implements Drawable, Movable {
    private int x, y;
    public int speed;
    private boolean isFromOpponent;

    public Bullet(int x, int y, boolean isFromOpponent) {
        this.x = x;
        this.y = y;
        this.speed = 5; // Velocidad de la bala
        this.isFromOpponent = isFromOpponent;
    }

    @Override
    public void moveUp(int variable) {
        if (!isFromOpponent) {
            y -= variable;
        }
    }

    @Override
    public void moveDown(int variable) {
        if (isFromOpponent) {
            y += variable;
        }
    }

    @Override
    public void moveLeft(int variable) {
  
    }

    @Override
    public void moveRight(int variable) {
       
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(isFromOpponent ? Color.RED : Color.WHITE);
        graphics.fillOval(x, y, 10, 10);
    }

    @Override
    public void draw(Graphics graphics, Drawable drawable) {
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return 10;
    }

    public int getHeight() {
        return 10;
    }
}