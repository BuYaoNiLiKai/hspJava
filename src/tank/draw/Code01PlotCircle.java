package tank.draw;

import javax.swing.*;
import java.awt.*;

public class Code01PlotCircle {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new MyPanel());
        frame.setSize(2000, 2000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("方法调用");
        g.drawOval(100, 100, 100, 100);
        g.drawRect(500, 100, 200, 100);
        g.setColor(Color.RED);
        g.fillRect(300, 100, 200, 100);
        g.drawLine(100, 300, 200, 100);
//        Image img = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/img.png"));
//        g.drawImage(img, 0, 0, 603, 1304, this);

        g.setFont(new Font("隶书", Font.BOLD, 50));
        g.drawString("hello world", 300, 500);


    }
}