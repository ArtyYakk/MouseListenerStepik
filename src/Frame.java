import javax.swing.*;
import java.awt.*;

public class Panel extends JFrame {
    public void start(){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(1000,800));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.pack();
    }
}
