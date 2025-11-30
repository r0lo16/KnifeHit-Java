import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

// Dodajemy 'implements Runnable' - to pozwala klasie działać w osobnym wątku
public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    // To jest nasz wątek gry - silnik, który napędza pętlę
    private Thread gameThread;
    
    // FPS - ile klatek na sekundę chcemy (60 to standard)
    private final int FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(30, 30, 30));
        this.setDoubleBuffered(true);
    }

    // Metoda startująca grę (wywołamy ją później w Main)
    public void startGame() {
        gameThread = new Thread(this); // Tworzymy wątek
        gameThread.start(); // Uruchamiamy go -> to wywoła metodę run()
    }

    @Override
    public void run() {
        // To jest serce gry - PĘTLA GRY
        
        double drawInterval = 1000000000 / FPS; // 1 sekunda (w nanosekundach) / 60
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            
            // 1. UPDATE: Aktualizacja pozycji (logika)
            update();

            // 2. REPAINT: Rysowanie (grafika)
            repaint(); // To magicznie wywołuje paintComponent

            // 3. SLEEP: Czekanie, aby zachować 60 FPS
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000; // Konwersja na milisekundy

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Tutaj będziemy aktualizować obrót kłody i lot noża
        // Na razie pusto :)
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Rysowanie testowe
        g.setColor(Color.WHITE);
        g.drawString("Game Loop działa!", 150, 350);
    }
}