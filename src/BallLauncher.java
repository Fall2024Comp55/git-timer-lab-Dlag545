import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallLauncher extends GraphicsProgram implements ActionListener{
	//Placeholder
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int SIZE = 25;
	public static final int SPEED = 2;
	public static final int MS = 50;
	private ArrayList<GOval> balls;
	private Timer movement;
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
		
	public void actionPerformed(ActionEvent e) {
		for(GOval ball:balls) {
			ball.move(SPEED, 0);
		}
	}
	
	public void run() {
		balls = new ArrayList<GOval>();
		movement = new Timer(MS, this);
		movement.start();
		addMouseListeners();
		
	}
	
	public void mousePressed(MouseEvent e) {
		for(GOval b:balls) {
			if(b.getX() < SIZE * 2.5) {
				return;
			}
		}
		GOval ball = makeBall(SIZE/2, e.getY());
		add(ball);
		movement.start();
	}
	
	
	
	
	public GOval makeBall(double x, double y) {
		GOval temp = new GOval(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
		temp.setColor(Color.RED);
		temp.setFilled(true);
		balls.add(temp);
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		new BallLauncher().start();
	}

}
