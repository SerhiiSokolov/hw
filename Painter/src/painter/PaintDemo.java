package painter;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
 
public class PaintDemo extends JPanel  {
    public final int LIMIT = 500;
    JFrame jf;
    BufferedImage bi;
    int count;
 
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Rectangle r = g.getClipBounds();
        g.drawImage(bi, r.x, r.y, r.x + r.width, r.y + r.height, r.x, r.y, r.x + r.width, r.y + r.height, null);
    }
 
 
    PaintDemo(String title, int x, int y) {
        bi = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
 
        jf = new JFrame(title);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Rectangle r = ((Component)e.getSource()).getBounds();
                BufferedImage biNew = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_RGB);
                biNew.getGraphics().drawImage(bi,0,0, null);
                bi = biNew;
            }
        });
        jf.add(this);
        jf.setSize(x, y);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public void start() {
        jf.setVisible(true);
        //noinspection InfiniteLoopStatement
        while (true) {
            int x = (int)(Math.random()* bi.getWidth());
            int y = (int)(Math.random()* bi.getHeight());
            bi.setRGB(x, y, 0xffffff);
            ++count;
            if (count > LIMIT) {
                count = 0;
                bi.getGraphics().clearRect(0, 0, bi.getWidth(), bi.getHeight());
                super.repaint(x, y, bi.getWidth(), bi.getHeight());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.repaint(x, y, 1, 1);
       }
 
    }
 
    public static void main(String[] args) {
        PaintDemo pd = new PaintDemo("Paint demo", 400, 300);
        pd.start();
    }
}
