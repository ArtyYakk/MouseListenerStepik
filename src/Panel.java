import javax.swing.*;
import javax.swing.text.StringContent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Panel extends JPanel {
    private ArrayList objects;
    private ArrayList colors;
    private Rectangle2D current;

    public Panel(){
        objects = new ArrayList();
        colors = new ArrayList();
        current = null;
        addMouseListener(new MyMouse());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0; i<objects.size(); i++){
            g2.setColor((Color)colors.get(i));
            g2.fill((Rectangle2D)objects.get(i));
        }
    }

    private void add(Point p){
        current = new Rectangle2D.Double(p.getX()-10,p.getY()-10,20,20);
        objects.add(current);
        colors.add(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        repaint();
    }
    private void delete(Point p){
        for(int i=0; i<objects.size(); i++){
            if(((Rectangle2D)objects.get(i)).contains(p)){
                objects.remove(objects.get(i));
                colors.remove((colors.get(i)));
                repaint();
            }
        }
    }

    private class MyMouse extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == 1) add(e.getPoint());
            else if(e.getButton() == 3) delete(e.getPoint());
        }

    }

}
