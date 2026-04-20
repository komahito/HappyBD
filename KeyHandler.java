import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyHandler implements KeyListener {
    private Simulation sim = null;
    private ArrayList<Letter> letterArr = null;
    private int keyNum = 9;

    private boolean aPressed = false;
    private boolean sPressed = false;
    private boolean dPressed = false;
    private boolean fPressed = false;
    private boolean gPressed = false;
    private boolean hPressed = false;
    private boolean jPressed = false;
    private boolean kPressed = false;
    private boolean lPressed = false;

    public KeyHandler(Simulation sim, ArrayList<Letter> letterArr) {
        this.sim = sim;
        this.letterArr = letterArr;
        if (Letter.letternum != keyNum)
            System.err.println("KeyHandler handle only " + keyNum + " while letter num is " + Letter.letternum);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                if (aPressed) break;
                sim.simulateLaunch(letterArr.get(0), 30);
                aPressed = true;
                break;
            case KeyEvent.VK_S:
                if (sPressed) break;
                sim.simulateLaunch(letterArr.get(1), 25);
                sPressed = true;
                break;
            case KeyEvent.VK_D:
                if (dPressed) break;
                sim.simulateLaunch(letterArr.get(2), 40);
                dPressed = true;
                break;
            case KeyEvent.VK_F:
                if (fPressed) break;
                sim.simulateLaunch(letterArr.get(3), 20);
                fPressed = true;
                break;
            case KeyEvent.VK_G:
                if (gPressed) break;
                sim.simulateLaunch(letterArr.get(4), 25);
                gPressed = true;
                break;
            case KeyEvent.VK_H:
                if (hPressed) break;
                sim.simulateLaunch(letterArr.get(5), 30);
                hPressed = true;
                break;
            case KeyEvent.VK_J:
                if (jPressed) break;
                sim.simulateLaunch(letterArr.get(6), 25);
                jPressed = true;
                break;
            case KeyEvent.VK_K:
                if (kPressed) break;
                sim.simulateLaunch(letterArr.get(7), 15);
                kPressed = true;
                break;
            case KeyEvent.VK_L:
                if (lPressed) break;
                sim.simulateLaunch(letterArr.get(8), 40);
                lPressed = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                aPressed = false;
                break;
            case KeyEvent.VK_S:
                sPressed = false;
                break;
            case KeyEvent.VK_D:
                dPressed = false;
                break;
            case KeyEvent.VK_F:
                fPressed = false;
                break;
            case KeyEvent.VK_G:
                gPressed = false;
                break;
            case KeyEvent.VK_H:
                hPressed = false;
                break;
            case KeyEvent.VK_J:
                jPressed = false;
                break;
            case KeyEvent.VK_K:
                kPressed = false;
                break;
            case KeyEvent.VK_L:
                lPressed = false;
                break;
            default:
                break;
        }
        return;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }
    
}
