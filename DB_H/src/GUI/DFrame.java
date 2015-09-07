package gui;

import javax.swing.JFrame;

public class DFrame extends JFrame 
{
	private static final long serialVersionUID = 5536355761486196118L;

	public DFrame() 
	{
		setTitle("Db Job");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);		
		add(new DPanel());
		setVisible(true);
	}
}
