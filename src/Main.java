import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class Main extends JFrame
{
	private JPanel drawingArea;
	
	private Dot d;
	
	private Thread animationThread;
	private AnimationManager aniManager;
	
	public Main()
	{	
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(600, 600);
		
		drawingArea = new DrawPanel(600, 600);		

		aniManager = new AnimationManager(this, drawingArea);
		animationThread = new Thread(aniManager);
		animationThread.start();

		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add( drawingArea, BorderLayout.CENTER );
	
		setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new Main();
	}
	
}
