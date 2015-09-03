package painter;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class PFrame extends JFrame {

	private static final long serialVersionUID = -9123744224775738800L;

	public PFrame() {
		setTitle("My painter");
		setBounds(50, 50, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JMenuBar menuBar=new PMenuBar();

		setJMenuBar(menuBar);		
//		add(new PMenuBar(),BorderLayout.LINE_END);
//		add(new ToolPanel(),BorderLayout.LINE_START);
//		add(new PPanel(), BorderLayout.CENTER);

		setVisible(true);
		
	}
}
