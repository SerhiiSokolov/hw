package myPainter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Painting extends JPanel implements MouseListener, MouseMotionListener {
	boolean flag=false;
	int x=0;
	int y=0;
	int xEnd=0;
	int yEnd=0;
	private int lineWidth=1;
	private Color foreground=Color.BLACK;
	private Color backgroundPanel=Color.WHITE;

	ArrayList<MyShape> list = new ArrayList<MyShape>();

	public Painting() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(backgroundPanel);
		g2.fillRect(0, 0, 500, 500);
		for (MyShape s : list) {
			g2.setColor(s.getForeground());
			g2.setStroke(new BasicStroke(s.getLineWidth()));
			g2.drawLine(s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
		}
	}
	public void mouseDragged(MouseEvent e) 
	{
		MyShape s= new MyShape(x,y,e.getX(),e.getY(), foreground,lineWidth);
		list.add(s);
		repaint();
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
	public void setWidth(int width)
	{
		lineWidth=width;
	}
	public void setColor(Color c) {
		foreground = c;
	}
	public Color getColor() {
		return foreground;
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	
	public Color getBackgroundPanel() {
		return backgroundPanel;
	}
	public class MyShape{
		private int startX;		
		private int startY;
		private int endX;
		private int endY;
		private Color foreground;
		private int lineWidth;
		public MyShape(int x, int y, int x2, int y2, Color foreground, int lineWidth) {
			this.startX=x;
			this.startY=y;
			this.endX=x2;
			this.endY=y2;
			this.foreground=foreground;
			this.lineWidth=lineWidth;
		}
		public int getStartX() {
			return startX;
		}
		public int getStartY() {
			return startY;
		}
		public int getEndX() {
			return endX;
		}
		public int getEndY() {
			return endY;
		}
		public Color getForeground() {
			return foreground;
		}
		public int getLineWidth() {
			return lineWidth;
		}
	}
}
