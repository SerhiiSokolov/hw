package painter;

import java.lang.reflect.Constructor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PMenuBar extends JMenuBar {
	public PMenuBar() {
		JMenuBar mainBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem closeMenuItem = new JMenuItem("Close"); 
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem saveAsMenuItem = new JMenuItem("Save As");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		
		newMenuItem.addActionListener(new MenuButtonListener());
		openMenuItem.addActionListener(new MenuButtonListener());
		saveMenuItem.addActionListener(new MenuButtonListener());
		saveAsMenuItem.addActionListener(new MenuButtonListener());
		closeMenuItem.addActionListener(new MenuButtonListener());
		exitMenuItem.addActionListener(new MenuButtonListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(closeMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(saveMenuItem);
		fileMenu.add(saveAsMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
	}

}
