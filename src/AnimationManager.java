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
	private Color[] colors = {Color.RED, Color.BLACK, Color.BLUE, Color.RED, Color.CYAN, Color.GREEN, Color.PINK};
	private static int colorNum = 0;
	private int colorCount = 0;
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
			int extendCount = 0;
			float fingerX = fingerTip.getX();
			float fingerY = fingerTip.getY();
			float fingerZ = fingerTip.getZ();
			for(int i = 0; i < fingers.count(); i++)
				if(fingers.get(i).isExtended())
					extendCount++;
			if(extendCount == 0)
			{
				colorCount++;
				if(colorNum == 6)
					colorNum = 0;
				else if(colorCount > 20)
					{
						colorNum++;
						colorCount = 0;
					}
			}
			if(extendCount == 5)
			{
				p.addDot(new Dot(fingerTip.getX(), fingerTip.getY(), fingerTip.getZ()/500, Color.WHITE));
			}
			else
			{
				dot = new Dot(fingerX/10 * 10, fingerY/10 * 10, fingerZ/500, colors[colorNum]);
				p.addDot(dot);
			}
			
			
				
		
			mainWindow.repaint();
			
			timeAtEndOfLoop = System.currentTimeMillis();
			pause = DESIRED_DELAY - (timeAtEndOfLoop - timeAtBeginningOfLoop);
			if(pause < 0) pause = 1;
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
