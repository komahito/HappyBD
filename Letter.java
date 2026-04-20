
public class Letter { //refKeyHandler.
    private String letterType = null;
    private int letterWidth = 0, letterHeight = 0;
    public static final int letternum = 9;
    public static final int mergin = 10;
    private double x = 0, y = 0;
    private double v = 0;
    public boolean onGround;

    public Letter (MainPanel mp, String s, double x) {
        letterWidth = calcWidth(mp);
        letterHeight = letterWidth;
        letterType = s;
        this.x = x;
        onGround = true;
    }

    static public int calcWidth (MainPanel mp) {
        return (mp.getWidth() - mergin*2) / letternum;
    }

    public String getLetterType () { return letterType; }
    public int getLetterWidth () { return letterWidth; }
    public int getLetterHeight () { return letterHeight; }
    public int getLetterNum () { return letternum; }
    public int getMergin () { return mergin; }
    public double getX () { return x; }
    public double getY () { return y; }
    public void setY (double y) { this.y = y; }
    // public double getA () { return a; }
    // public void setA (double a) { this.a = a; }
    public double getV () { return v; }
    public void setV (double v) { this.v = v; }


}
