import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Runner {

    public JFrame frame;
    public JPanel panel;
    public Image X, O;
    public Graphics panelG;
    public Image[] turn;
    public int index;
    public int[][] board;

    public static void main(String[] args) throws InterruptedException {
        new Runner();
    }

    public Runner() throws InterruptedException {
        board = new int[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};

        this.X = Toolkit.getDefaultToolkit().getImage("src/res/X.png");
        this.O = Toolkit.getDefaultToolkit().getImage("src/res/O.png");
        this.turn = new Image[]{X, O};
        this.index = 0;
        setupWindow();
        this.panelG = panel.getGraphics();
        panelG.clearRect(0, 0, 256, 256);

        while (true){
            updater(panelG);
        }
    }

    public void setupWindow(){
        frame = new JFrame("Tic Tac Toe");
        panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                updater(g);
            }
        };

        Dimension expectedDimension = new Dimension(300, 300);

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
        this.panelG = panel.getGraphics();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Working!");
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
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int arrX = 0;
                int arrY = 0;
                int tempX = e.getX();
                int tempY = e.getY();

                if(e.getX() > 0 && e.getX() < panel.getWidth() / 3){
                    tempX = (panel.getWidth() / 3) / 5;
                    arrX = 0;
                }else if(e.getX() > panel.getWidth() / 3 && e.getX() < 2 * panel.getWidth() / 3){
                    tempX = (panel.getWidth() / 3) + (panel.getWidth() / 3) / 5;
                    arrX = 1;
                }else if(e.getX() > 2 * panel.getWidth() / 3 && e.getX() < panel.getWidth()){
                    tempX = (2 * panel.getWidth() / 3) + (panel.getWidth() / 3) / 5;
                    arrX = 2;
                }
                if(e.getY() > 0 && e.getY() < panel.getWidth() / 3){
                    tempY = (panel.getWidth() / 3) / 5;
                    arrY = 0;
                }else if(e.getY() > panel.getWidth() / 3 && e.getY() < 2 * panel.getWidth() / 3){
                    tempY = (panel.getWidth() / 3) + (panel.getWidth() / 3) / 5;
                    arrY = 1;
                }else if(e.getY() > 2 * panel.getWidth() / 3 && e.getY() < panel.getWidth()){
                    tempY = (2 * panel.getWidth() / 3) + (panel.getWidth() / 3) / 5;
                    arrY = 2;
                }

                board[arrY][arrX] = index;

                if(index == 1){
                    index = 0;
                }else {
                    index = 1;
                }

                //Drawinator.DrawQuadIMG(tempX, tempY, turn[index], panelG);
                //Drawinator.DrawQuadIMG(50, 50, turn[index], frame.getGraphics());

                System.out.println(board[0][0]);
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

    public void drawBoard(Graphics g){
        g.drawLine(panel.getWidth() / 3, 0, panel.getWidth() / 3, panel.getHeight());
        g.drawLine(2 * panel.getWidth() / 3, 0, 2 * panel.getWidth() / 3, panel.getHeight());
        g.drawLine(0, panel.getWidth() / 3, panel.getHeight(), panel.getWidth() / 3);
        g.drawLine(0, 2 * panel.getWidth() / 3, panel.getHeight(), 2 * panel.getWidth() / 3);
    }

    public void drawBoardPieces(Graphics g) {

        for (int[] i: board) {
            for (int j: i) {

            }
        }


    }

    public void updater(Graphics g){
        panel.repaint();
        drawBoard(g);

        drawBoardPieces(g);



    }


}
