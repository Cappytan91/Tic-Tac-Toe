import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Runner {

    public JFrame frame;
    public JPanel panel;
    public Image X, O;
    public Graphics g;

    public static void main(String[] args) throws InterruptedException {
        new Runner();
    }

    public Runner() throws InterruptedException {
        this.X = Toolkit.getDefaultToolkit().getImage("src/res/X.png");
        this.O = Toolkit.getDefaultToolkit().getImage("src/res/O.png");
        setupWindow();
        this.g = frame.getGraphics();
        g.clearRect(0, 0, 256, 256);
        Drawinator.graphics = panel.getGraphics();
        Thread.sleep(10);
        setupBoard(panel.getGraphics());
    }

    public void setupWindow(){
        frame = new JFrame("Tic Tac Toe");
        panel = new JPanel();
        panel.setSize(400, 400);

        Dimension expectedDimension = new Dimension(400, 400);

        panel.setPreferredSize(expectedDimension);
        panel.setMaximumSize(expectedDimension);
        panel.setMinimumSize(expectedDimension);

        //panel.setBackground(Color.RED); // for debug only

        Box box = new Box(BoxLayout.Y_AXIS);

        box.add(Box.createVerticalGlue());
        box.add(panel);
        box.add(Box.createVerticalGlue());

        frame.add(box);


        frame.setSize(1000, 1000);
        frame.setIconImage(X);
        this.g = panel.getGraphics();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Working!");
                Drawinator.DrawQuadIMG(e.getX(), e.getY(), X);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        frame.setVisible(true);
    }

    public void setupBoard(Graphics g){
        g.drawLine(65, 0, 65, 194);
        g.drawLine(130, 0, 130, 194);
        g.drawLine(0, 65, 194, 65);
        g.drawLine(0, 130, 194, 130);
    }


}
