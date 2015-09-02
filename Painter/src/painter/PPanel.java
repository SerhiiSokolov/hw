package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PPanel extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 8988796399702810239L;
	boolean flag=false;
	int x=0;
	int y=0;
	private static int lineWidth=1;
	private static Color c=Color.BLACK;

	public PPanel() {
		setPreferredSize(new Dimension(400, 500));
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{		
		Graphics2D gg = (Graphics2D) this.getGraphics();
		gg.setColor(c);
		gg.setStroke(new BasicStroke(lineWidth));
		gg.drawLine(x, y, e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
		//repaint();
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

	public static void setWidth(int width)
	{
		PPanel.lineWidth=width;
	}
	public static void setColor(Color c) {
		PPanel.c = c;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
}
