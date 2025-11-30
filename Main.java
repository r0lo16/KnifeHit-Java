import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        // Tworzymy główne okno (ramkę)
        JFrame window = new JFrame();
        
        // Ustawiamy tytuł okna
        window.setTitle("Knife Hit Clone");
        
        // Co ma się stać po kliknięciu "X" - zamykamy program
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Nie pozwalamy użytkownikowi zmieniać rozmiaru okna myszką
        window.setResizable(false);
        
        // Dodajemy nasz panel gry do okna
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        // Dopasowujemy rozmiar okna do rozmiaru panelu (pack)
        window.pack();
        
        // Centrujemy okno na ekranie
        window.setLocationRelativeTo(null);
        
        // Wyświetlamy okno
        window.setVisible(true);


        window.setLocationRelativeTo(null);
            window.setVisible(true);

        // DODAJ TĘ LINIĘ NA KOŃCU:
        gamePanel.startGame(); 
           
    }
}