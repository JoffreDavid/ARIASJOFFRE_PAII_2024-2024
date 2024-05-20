package view_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controlador_package.Container;

public class GameFrame extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Container container;

    public GameFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        container = new Container();
        contentPane = new JPanel();
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        addKeyListener(this);

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!container.isGameOver()) {
                    container.moveDown(1);
                    container.updateBullets();
                    container.checkCollisions();
                    container.opponentShoot();
                }
                repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        container.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!container.isGameOver()) {
            setFocusable(true);
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    container.moveLeft(10);
                    break;
                case KeyEvent.VK_D:
                    container.moveRight(10);
                    break;
                case KeyEvent.VK_SPACE:
                    container.shoot();
                    break;
            }
        }
        repaint();
    }

  

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	}