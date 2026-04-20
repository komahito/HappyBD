
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable {
    int width = 600, height = 500;
    JFrame frame = null;
    Simulation sim = null;
    ArrayList<Letter> letterArr = null;
    String letters = "HAPPYBD-BD!";
    KeyHandler keyH = null;

    public MainPanel() {}

    @Override
    public void run() {
        // init panel
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        // init frame
        frame = new JFrame("HappyBD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        frame.pack();
        
        // visable frame
        frame.setVisible(true);


        // construct simulator
        sim = new Simulation();
        // construct letter obj list
        letterArr = new ArrayList<>();
        int letterWidth = Letter.calcWidth(this);
        for (int i = 0; i < Letter.letternum; i++) {
            int x = Letter.mergin + i * letterWidth;
            letterArr.add(new Letter(this, String.valueOf(letters.charAt(i)),x));
        }
        // construct keyHandller.
        keyH = new KeyHandler(sim, letterArr);
        this.addKeyListener(keyH);

        while (true) {
            update();
            repaint();
            try{
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    void update () {
        for (int i = 0; i < Letter.letternum; i++) {
            sim.simulateFalling(letterArr.get(i));
        }
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        int letterHeight = Letter.calcWidth(this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.ORANGE);
        g2.fillRect(0, height - letterHeight, frame.getWidth(), frame.getHeight()); // draw ground
        for (int i = 0; i < Letter.letternum; i++) {
            Letter l = letterArr.get(i);
            int x = (int) l.getX();
            int y = (int) l.getY();
            g2.setFont(new Font("SansSerif", Font.BOLD, l.getLetterWidth()));
            g2.drawString(l.getLetterType(), x, height-y-letterHeight);
        }
        g2.dispose();
    }
    
}
