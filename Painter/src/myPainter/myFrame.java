package myPainter;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
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
		JButton color=new JButton("Color");
		color.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						JColorChooser.showDialog(null,"ForeGround Color",null);
					}
				}
			);
		pane.add(color);
		gui.setVisible(true);
	}
}
