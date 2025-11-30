import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

// Dziedziczymy po JPanel - to jak czysta kartka papieru w oknie
public class GamePanel extends JPanel {

    // Ustawiamy stałe wymiary okna (jak w telefonie)
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    public GamePanel() {
        // Ustawiamy preferowany rozmiar panelu
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // Ustawiamy kolor tła na ciemny (jak w oryginalnej grze)
        this.setBackground(new Color(30, 30, 30));
        // Włączenie podwójnego buforowania (zapobiega miganiu animacji)
        this.setDoubleBuffered(true);
    }

    // Ta metoda jest wywoływana automatycznie, gdy system chce narysować panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Tutaj w przyszłości będziemy rysować kłodę i noże
        // Na razie narysujmy tymczasowy napis, żeby sprawdzić czy działa
        g.setColor(Color.WHITE);
        g.drawString("Knife Hit - Start", 150, 350);
    }
}