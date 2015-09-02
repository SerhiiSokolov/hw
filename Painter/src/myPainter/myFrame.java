package myPainter;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class myFrame extends JFrame {
	public myFrame() {
		JFrame gui=new JFrame("My Painter");
		gui.setSize(500, 500);
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Painting panel=new Painting();
		Container pane=gui.getContentPane();
		pane.setLayout(new GridLayout(1, 1));
		pane.add(panel);
		gui.setVisible(true);
	}
}
