package controlador_package;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model_package.Bullet;
import model_package.Hero;
import model_package.Opponents;

public class Container {
    final int SCREEN_WIDTH = 700;
    final int SCREEN_HEIGHT = 600; // Aumentar el tamaño para adaptarlo a la ventana del juego
    Hero hero = new Hero();
    List<Opponents> opponents = new ArrayList<>();
    List<Bullet> heroBullets = new ArrayList<>();
    List<Bullet> opponentBullets = new ArrayList<>();
    Random random = new Random();
    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;

    public Container() {
        for (int i = 0; i < 5; i++) {
            opponents.add(new Opponents(random.nextInt(SCREEN_WIDTH), random.nextInt(SCREEN_HEIGHT)));
        }
    }

    public void draw(Graphics graphics) {
        if (gameOver) {
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Arial", Font.BOLD, 40));
            graphics.drawString("Game Over", SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2);
            graphics.setFont(new Font("Arial", Font.BOLD, 20));
            graphics.drawString("Score: " + score, SCREEN_WIDTH / 2 - 50, SCREEN_HEIGHT / 2 + 50);
        } else {
            hero.draw(graphics);
            for (Opponents opponent : opponents) {
                opponent.draw(graphics);
            }
            for (Bullet bullet : heroBullets) {
                bullet.draw(graphics);
            }
            for (Bullet bullet : opponentBullets) {
                bullet.draw(graphics);
            }
            drawScoreAndLives(graphics);
        }
    }

    private void drawScoreAndLives(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.drawString("Score: " + score, 10, 50);
        graphics.drawString("Lives: " + lives, 10, 80);
    }

    public void moveLeft(int variable) {
        if (!gameOver) hero.moveLeft(variable);
    }

    public void moveRight(int variable) {
        if (!gameOver) hero.moveRight(variable);
    }

    public void moveDown(int variable) {
        for (Opponents opponent : opponents) {
            opponent.moveDown(variable);
        }
    }

    public void shoot() {
        if (!gameOver) {
            heroBullets.add(new Bullet(hero.cord_x[0] + 10, hero.cord_y[0] - 10, false));
        }
    }

    public void updateBullets() {
        for (int i = 0; i < heroBullets.size(); i++) {
            Bullet bullet = heroBullets.get(i);
            bullet.moveUp(bullet.speed);
            if (bullet.getY() < 0) {
                heroBullets.remove(i);
                i--;
            }
        }
        for (int i = 0; i < opponentBullets.size(); i++) {
            Bullet bullet = opponentBullets.get(i);
            bullet.moveDown(bullet.speed);
            if (bullet.getY() > SCREEN_HEIGHT) {
                opponentBullets.remove(i);
                i--;
            }
        }
    }

    public void checkCollisions() {
        // Colisiones de balas del héroe con los oponentes
        for (int i = 0; i < heroBullets.size(); i++) {
            Bullet bullet = heroBullets.get(i);
            for (int j = 0; j < opponents.size(); j++) {
                Opponents opponent = opponents.get(j);
                if (bullet.getX() < opponent.cord_x[1] && bullet.getX() + bullet.getWidth() > opponent.cord_x[0] &&
                    bullet.getY() < opponent.cord_y[2] && bullet.getY() + bullet.getHeight() > opponent.cord_y[0]) {
                    opponents.remove(j);
                    heroBullets.remove(i);
                    score += 10; // Incrementar el puntaje
                    i--;
                    break;
                }
            }
        }
        // Colisiones de balas de los oponentes con el héroe
        for (int i = 0; i < opponentBullets.size(); i++) {
            Bullet bullet = opponentBullets.get(i);
            if (bullet.getX() < hero.cord_x[1] && bullet.getX() + bullet.getWidth() > hero.cord_x[0] &&
                bullet.getY() < hero.cord_y[2] && bullet.getY() + bullet.getHeight() > hero.cord_y[0]) {
                opponentBullets.remove(i);
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                }
                i--;
            }
        }
    }

    public void opponentShoot() {
        for (Opponents opponent : opponents) {
            if (random.nextInt(100) < 3) { // 5% de probabilidad de disparar
                opponentBullets.add(new Bullet(opponent.cord_x[2], opponent.cord_y[2], true));
            }
        }
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}