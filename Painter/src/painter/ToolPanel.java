package painter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToolPanel extends JPanel {

	private static final long serialVersionUID = -8065162356222669106L;
	public static int lineWidth=1;
	Color c=Color.BLACK;
	public ToolPanel() {
		setPreferredSize(new Dimension(100,100));
		setLayout(new FlowLayout());

		String[] selectWidth={
				"1px",
				"2px",
				"3px",
				"4px"
		};

		JComboBox boxSelectWidth=new JComboBox(selectWidth);
		boxSelectWidth.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String db=(String)boxSelectWidth.getSelectedItem();
				switch (db) {
				case "1px":
					PPanel.setWidth(1);
					break;
				case "2px":
					PPanel.setWidth(2);
					break;
				case "3px":
					PPanel.setWidth(3);
					break;
				case "4px":
					PPanel.setWidth(4);
					break;
				default:
					break;
				}
			}
		});
		add(boxSelectWidth);

		String[] selectColor={
				"BLACK",
				"BLUE",
				"CYAN",
				"GREEN",
				"RED",
				"DARK_GRAY",
				"GRAY"
		};

		JComboBox boxSelectColor=new JComboBox(selectColor);
		boxSelectColor.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String db=(String)boxSelectColor.getSelectedItem();
				switch (db) {
				case "BLACK":
					PPanel.setColor(Color.BLACK);
					break;
				case "BLUE":
					PPanel.setColor(Color.BLUE);
					break;
				case "CYAN":
					PPanel.setColor(Color.CYAN);
					break;
				case "GREEN":
					PPanel.setColor(Color.GREEN);
					break;
				case "RED":
					PPanel.setColor(Color.RED);
					break;
				case "GRAY":
					PPanel.setColor(Color.GRAY);
					break;
				case "DARK_GRAY":
					PPanel.setColor(Color.DARK_GRAY);
					break;
				default:
					PPanel.setColor(Color.BLACK);
					break;
				}
			}
		});
		add(boxSelectColor);

		JComboBox formats = new JComboBox(getFormats());
		formats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String format = (String)cb.getSelectedItem();
				File saveFile = new File("savedimage."+format);
				JFileChooser chooser = new JFileChooser();
				chooser.setSelectedFile(saveFile);
			}
		});

		add(new JLabel("Save As"));
		add(formats);

	}
	public String[] getFormats() {
		String[] formats = ImageIO.getWriterFormatNames();
		TreeSet<String> formatSet = new TreeSet<String>();
		for (String s : formats) {
			formatSet.add(s.toLowerCase());
		}
		return formatSet.toArray(new String[0]);
	}
}
