package GUI;

public class RepaintTheWindow implements Runnable {
    private Window window;

    public RepaintTheWindow(Window window){
        this.window = window;
    }
    @Override
    public void run() {
        window.repaint();
    }
}
