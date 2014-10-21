import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Dot {

	private float x, y, weight;
	private Color color;
	private int m;
	public Dot(float x, float y, float weight, Color color)
	{
		this.x = x;
		this.y = y;
		this.weight = Math.abs(weight);
		this.color = color;
		m = 300;
		
	}

	public void draw(Graphics g)  {
		g.setColor(color);
		g.fillOval((int) x+300, (int) (600-y) , (int)(weight*100), (int)(weight*100));
	}
}
