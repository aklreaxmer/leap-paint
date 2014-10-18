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
	private File f;
	public Dot(float x, float y, float weight, Color color)
	{
		this.x = x;
		this.y = y;
		this.weight = Math.abs(weight);
		this.color = color;
		m = 300;
		
	}

	public void draw(Graphics g, BufferedImage previous)  {
		g.drawImage(previous, 0, 0, null);
		Graphics2D imageG = previous.createGraphics();
		imageG.drawImage(previous, 0, 0, null);
		imageG.setColor(color);
		imageG.translate(0, m);
		imageG.scale(1, -1);
		imageG.translate(0, -m);
		imageG.fillOval((int) x*2 + 400, (int) y*2 , (int)(weight*60), (int)(weight*60));
		f.delete();
		f = new File("f.jpg");
		try {
			ImageIO.write(previous, "JPG", f);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
