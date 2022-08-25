import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Frame extends JFrame {
    public void start(){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(950,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Panel panel = new Panel();
        frame.add(panel);

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Rectangle area = panel.getBounds();
                Point cursor = new Point(e.getX(),e.getY());
                if(area.contains(cursor)) panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                else panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        frame.setVisible(true);
        frame.pack();
    }
}
