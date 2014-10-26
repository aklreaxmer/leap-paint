import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;


public class DrawPanel extends JPanel
{
	public int WIDTH, HEIGHT;
	private ArrayList<Dot> dots = new ArrayList<Dot>();
	public DrawPanel(int w, int h)
	{
		WIDTH = w;
		HEIGHT = h;	
		setBackground(Color.WHITE);
	}
	
	public void addDot(Dot dot)
	{
		dots.add(dot);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(dots.get(0) != null)
		{
			for(int i = 0; i < dots.size(); i++)
			{
				dots.get(i).draw(g);
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