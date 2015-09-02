package myPainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Painting extends JPanel implements MouseListener, MouseMotionListener {
	boolean flag=false;
	int x=0;
	int y=0;
	Graphics2D g;
	public Painting() {
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g){
		
		this.g = (Graphics2D)g;
//		super.paintComponent(g);
//		g.setColor(Color.BLACK);		
		this.g.drawLine(10, 10, 100, 100);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{	
		Graphics2D g = (Graphics2D) super.getGraphics();
//		gg.setColor(c);
//		gg.setStroke(new BasicStroke(lineWidth));
		g.drawLine(x, y, e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
		
	}

	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		flag = true;
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		flag = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
}
