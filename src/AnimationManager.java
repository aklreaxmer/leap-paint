import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.Type;
import com.leapmotion.leap.GestureList;
import com.leapmotion.leap.Vector;

public class AnimationManager implements Runnable
{

	private JFrame mainWindow;	

	private long timeAtEndOfLoop = 0, timeAtBeginningOfLoop = 0, pause = 0;
	private final long DESIRED_DELAY = 40;
	
	private Controller leap;
	private Frame currFrame;
	private DrawPanel p;
	private Dot dot;
	public AnimationManager(JFrame mw, JPanel drawingArea)
	{
		mainWindow = mw;
		leap = new Controller();
		p = (DrawPanel) drawingArea;
	}
	

	public void run()
	{
		
		while(true)	 
		{
			timeAtBeginningOfLoop = System.currentTimeMillis();
			
			
			currFrame = leap.frame();
			FingerList fingers = currFrame.fingers();
			Finger frontFinger = fingers.frontmost();
			Vector fingerTip = frontFinger.tipPosition();
			
			float fingerX = fingerTip.getX();
			float fingerY = fingerTip.getY();
			float fingerZ = fingerTip.getZ();
			dot = new Dot(fingerX/10 * 10, fingerY/10 * 10, fingerZ/500, Color.RED);
			p.addDot(dot);
	
			mainWindow.repaint();
			
			timeAtEndOfLoop = System.currentTimeMillis();
			pause = DESIRED_DELAY - (timeAtEndOfLoop - timeAtBeginningOfLoop);
			if(pause < 0) pause = 1;
			try
			{
				Thread.sleep(pause);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
