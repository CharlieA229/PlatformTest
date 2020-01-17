package com.Charlie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener{
	Player player;
	ArrayList<Wall> walls = new ArrayList<>();
	
	int cameraX;
	int offset;
	Timer gameTimer;
	
	
	public GamePanel() {
		
		player = new Player(400,300,this);
		reset();
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				if(walls.get(walls.size()-1).x < 800) {
					offset += 700;
					makeWalls(offset);
					
				}
				
				player.set();
				for(Wall wall : walls) wall.set(cameraX);
				
				for(int i = 0; i < walls.size(); i++) {
					if(walls.get(i).x < -800)walls.remove(i);
				}
				
				repaint();
				
			}
			
		}, 0,17);
	}
	
	public void reset() {
		player.x = 200;
		player.y = 150;
		cameraX = 150;
		player.xspeed = 0;
		player.yspeed = 0;
		walls.clear();
		 offset = -150;
		
		makeWalls(offset);
				
	}
	
	private void makeWalls(int offset) {
		int s = 50;
		Random rand = new Random();
		int index = rand.nextInt(6);
		
		if(index == 0) {
			for(int i=0; i <14; i++) walls.add(new Wall(Color.DARK_GRAY,offset + i*50,600, s, s));
		}
		
		else if(index == 1) {
			for(int i=0; i <5; i++) walls.add(new Wall(Color.white,offset + i*50,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 500,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 550,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 600,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 650,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 700,600, s, s));
			 walls.add(new Wall(Color.WHITE, offset + 750,600, s, s));
			 
		}
		
		else if(index == 2) {
			for(int i=0; i <5; i++) walls.add(new Wall(Color.CYAN,offset + i*50,600, s, s));
			for(int i=0; i <3; i++) walls.add(new Wall(Color.CYAN,offset + 100 + i*50,550, s, s));
			for(int i=0; i <2; i++) walls.add(new Wall(Color.CYAN,offset + 150 + i*50,500, s, s));
			for(int j =0; j < 4; j++) {
				for(int i=0; i <4; i++) walls.add(new Wall(Color.CYAN,offset + 350 + i*50, 450 + 50*j, s, s));
			}
			
		}
		
		else if(index == 3) {
			for(int i=0; i <5; i++) walls.add(new Wall(Color.GREEN,offset + i*50,600, s, s));
			for(int i=0; i <4; i++) walls.add(new Wall(Color.GREEN,offset + 50 + i*50,550, s, s));
			for(int i=0; i <3; i++) walls.add(new Wall(Color.GREEN,offset + 100 + i*50,500, s, s));
			for(int i=0; i <2; i++) walls.add(new Wall(Color.GREEN,offset + 150 + i*50,450, s, s));
			for(int i=0; i <4; i++) walls.add(new Wall(Color.GREEN,offset + 500 + i*50,600, s, s));
			
		}
		
		else if(index == 4) {
			for(int i=0; i <5; i++) walls.add(new Wall(Color.RED,offset + i*50,600, s, s));
			for(int i=0; i <5; i++) walls.add(new Wall(Color.RED,offset + 450 + i*50,600, s, s));
			 walls.add(new Wall(Color.RED, offset + 150,550, s, s));
			 walls.add(new Wall(Color.RED, offset + 200,550, s, s));
			 walls.add(new Wall(Color.RED, offset + 200,500, s, s));
			// walls.add(new Wall(Color.RED, offset + 200,450, s, s));
			 walls.add(new Wall(Color.RED, offset + 500,550, s, s));
			 walls.add(new Wall(Color.RED, offset + 450,550, s, s));
			 walls.add(new Wall(Color.RED, offset + 450,500, s, s));
			// walls.add(new Wall(Color.RED, offset + 450,450, s, s));
			 
		}
		
		else if(index == 5) {
			for(int i=0; i <14; i++) walls.add(new Wall(Color.ORANGE,offset + i*50,600, s, s));
			for(int i=0; i <12; i++) walls.add(new Wall(Color.ORANGE,offset + 50 + i*50,550, s, s));
			for(int i=0; i <10; i++) walls.add(new Wall(Color.ORANGE,offset + 100 + i*50,500, s, s));
			for(int i=0; i <8; i++) walls.add(new Wall(Color.ORANGE,offset + 150 + i*50,450, s, s));
			for(int i=0; i <6; i++) walls.add(new Wall(Color.ORANGE,offset + 200 + i*50,400, s, s));
			
			
			 
		}
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D gtd = (Graphics2D) g;
		
		player.draw(gtd);
		for(Wall wall : walls)wall.draw(gtd);
		
	}
	
	
	

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = true;
		if(e.getKeyChar() == 'w') player.keyUp = true;
		if(e.getKeyChar() == 'd') player.keyRight = true;
		if(e.getKeyChar() == 's') player.keyDown = true;
		
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = false;
		if(e.getKeyChar() == 'w') player.keyUp = false;
		if(e.getKeyChar() == 'd') player.keyRight = false;
		if(e.getKeyChar() == 's') player.keyDown = false;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
