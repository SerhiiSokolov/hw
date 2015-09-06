package myPainter;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import myPainter.Painting.MyShape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class myFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4593302136334193661L;
	private File fileName;
	Painting canvas=new Painting();
	public myFrame() {
		JFrame gui=new JFrame("My Painter");
		gui.setSize(500, 500);		
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar mainBar=new JMenuBar();
		setJMenuBar(mainBar);
		mainBar.setLayout(new FlowLayout());;
		mainBar.setPreferredSize(new Dimension(gui.getWidth(), 35));
		
		JMenu fileMenu=new JMenu("File");
		fileMenu.setMnemonic('F');
		fileMenu.setPreferredSize(new Dimension(30, 20));
		
		JMenuItem saveAsMenuItem 	= new JMenuItem("Save As");		
		saveAsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SaveAsToFile();
			}
		});
		fileMenu.add(saveAsMenuItem);
		
		JMenuItem exitMenuItem	= new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});		
		fileMenu.add(exitMenuItem);
		mainBar.add(fileMenu);
		
		JButton color=new JButton("Color");
		color.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				canvas.setColor(JColorChooser.showDialog(null,"ForeGround Color",canvas.getColor()));
			}
		}
				);
		mainBar.add(color);		
		
		JLabel lineWidth=new JLabel("Line width, px");
		lineWidth.setPreferredSize(new Dimension(100, 20));
		mainBar.add(lineWidth);
		
		Integer[] selectWidth={1,2,3,4,5,10,20,30};
		JComboBox boxSelectWidth=new JComboBox(selectWidth);		
		boxSelectWidth.setEditable(true);
		boxSelectWidth.setPreferredSize(new Dimension(50, 20));
		boxSelectWidth.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try{
					canvas.setWidth((int)boxSelectWidth.getSelectedItem());
				}
				catch (ClassCastException err){

				}
			}
		});
		mainBar.add(boxSelectWidth);
		new BorderLayout();
		gui.add(mainBar, BorderLayout.PAGE_START);
		gui.add(canvas, BorderLayout.CENTER);
		gui.setVisible(true);
	}

	public void SaveAsToFile()
	{		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("d:\\"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);		

		String[] formats = getFormats();
		for(String s:formats){
			fileChooser.addChoosableFileFilter(new ExtFileFilter(s, "*."+s+" Рисунке в формате "+s));
		}

		int result = fileChooser.showSaveDialog(null);	
		if(result == JFileChooser.CANCEL_OPTION) return;			
		fileName = fileChooser.getSelectedFile();
		if(fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(null,"Invalid File Name","Painter",JOptionPane.ERROR_MESSAGE);
		else
		{
			RenderedImage img=createImage();
			String ext="jpg";
			String defext="";
			try {
				if (fileName.getName().toLowerCase().endsWith("jpg"))ext="jpg";
				else if (fileName.getName().toLowerCase().endsWith("bmp"))ext="bmp";
				else if (fileName.getName().toLowerCase().endsWith("jpeg"))ext="jpeg";
				else if (fileName.getName().toLowerCase().endsWith("gif"))ext="gif";
				else if (fileName.getName().toLowerCase().endsWith("png"))ext="png";
				else defext=".jpg";
				File file = new File(fileName.toString()+defext);        		
				ImageIO.write(img, ext, file);
			}catch (IOException e) {}
		}
	}

	public String[] getFormats() {
		String[] formats = ImageIO.getWriterFormatNames();
		TreeSet<String> formatSet = new TreeSet<String>();
		for (String s : formats) {
			formatSet.add(s.toLowerCase());
		}
		return formatSet.toArray(new String[0]);
	}

	private RenderedImage createImage() 
	{
		System.out.println(canvas.getWidth()+", "+canvas.getHeight());
		BufferedImage bufferedImage = new BufferedImage(canvas.getWidth(),canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bufferedImage.createGraphics();
		g2.setColor(canvas.getBackgroundPanel());
		g2.fillRect(0, 0, 500, 500);

		for (MyShape s : canvas.list) {
			g2.setColor(s.getForeground());
			g2.setStroke(new BasicStroke(s.getLineWidth()));
			g2.drawLine(s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
		}
		g2.dispose();
		return bufferedImage;
	}

	class ExtFileFilter extends javax.swing.filechooser.FileFilter {

		String ext;
		String description;

		public ExtFileFilter(String ext, String descr) {
			this.ext = ext;
			description = descr;
		}

		public boolean accept(File f) {
			if (f != null) {
				if (f.isDirectory()) {
					return true;
				}
				String extension = getExtension(f);
				if (extension == null)
					return (ext.length() == 0);
				return ext.equals(extension);
			}
			return false;
		}

		public String getExtension(File f) {
			if (f != null) {
				String filename = f.getName();
				int i = filename.lastIndexOf('.');
				if (i > 0 && i < filename.length() - 1) {
					return filename.substring(i + 1).toLowerCase();
				}				
			}
			return null;
		}

		public String getDescription() {
			return description;
		}
	}
}
