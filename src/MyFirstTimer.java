import acm.graphics.*;
import acm.program.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private int numTimes;
	Timer someTimerVar = new Timer(1000, this);
	private GLabel myLabel;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		numTimes++;
		myLabel.setLabel("times called? " + numTimes);
		myLabel.move(5, 0);
		
		if(numTimes >= 10) {
			someTimerVar.stop();
		}
	}
	
	public void run() {
		numTimes = 0;
		myLabel = new GLabel("# of times called? ", 0, 100);
		add(myLabel);
		someTimerVar.setInitialDelay(3000);
		someTimerVar.start();
		
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}