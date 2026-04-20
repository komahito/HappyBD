public class Simulation {
    private static final double g = -3;

    public void simulateFalling (Letter l) {
        double oldV = l.getV();
        double oldY = l.getY();
        if (oldY <= 0) {
            l.onGround = true;
            l.setV(0);
            l.setY(0);
            return;
        }
        double newV = oldV + g;
        l.setV(newV);
        double newY = oldY + newV;
        l.setY(newY);
    }

    public void simulateLaunch (Letter l, double a) {
        if (l.onGround == false) {
            System.err.println("onGround false");
            return;
        }
        double newV = a;
        l.setV(newV);
        double newY = newV;
        l.setY(newY);
    }
    
}
