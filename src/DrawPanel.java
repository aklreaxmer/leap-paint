import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;


public class DrawPanel extends JPanel
{
	public int WIDTH, HEIGHT;
	private Dot dot;
	private BufferedImage previous;
	public DrawPanel(int w, int h)
	{
		WIDTH = w;
		HEIGHT = h;	
		previous = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
		setBackground(Color.WHITE);
	}
	
	public void addDot(Dot dot)
	{
		this.dot = dot;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(dot != null)
		{
			
			try {
				dot.draw(g, previous);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
			}
		}
		
	}
	
	
	
	
	//REQUIRED: the following help fix the size of this JPanel…you will probably have the same 
	//	methods inside any subclass of JPanel that you create.
	public Dimension getSize(){
		return new Dimension( WIDTH, HEIGHT );
	}
	public Dimension getMinimumSize(){
		return getSize();
	}
	public Dimension getMaximumSize(){
		return getSize();
	}
	public Dimension getPreferredSize(){
		return getSize();
	}
	public int getWidth(){
		return WIDTH;
	}
	public int getHeight(){
		return HEIGHT;
	}
}