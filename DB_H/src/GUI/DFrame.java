package GUI;

import javax.swing.JFrame;

public class DFrame extends JFrame 
{
	public DFrame() 
	{
		setTitle("Db Job");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);		
		add(new DPanel());
		setVisible(true);
	}
}
