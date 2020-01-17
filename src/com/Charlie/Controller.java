package com.Charlie;


import java.awt.Dimension;
import java.awt.Toolkit;

public class Controller {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		
		frame.setSize(700,700);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
		
		frame.setResizable(false);
		frame.setTitle("Platform Game");
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

}
