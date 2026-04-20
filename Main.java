
public class Main {
    public static void main (String[] args) {
        Thread runnableThread = new Thread(new MainPanel());
        runnableThread.start();
    }
}
