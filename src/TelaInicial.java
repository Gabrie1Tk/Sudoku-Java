import java.awt.*;
import javax.swing.*;

public class TelaInicial extends JFrame {
    
    public TelaInicial() {
        setTitle("Sudoku - Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Escolha a Dificuldade", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        add(label);

        JButton btnFacil = new JButton("Fácil");
        styleButton(btnFacil);
        btnFacil.addActionListener(e -> iniciarJogo(20));
        add(btnFacil);

        JButton btnMedio = new JButton("Médio");
        styleButton(btnMedio);
        btnMedio.addActionListener(e -> iniciarJogo(40));
        add(btnMedio);

        JButton btnDificil = new JButton("Difícil");
        styleButton(btnDificil);
        btnDificil.addActionListener(e -> iniciarJogo(60));
        add(btnDificil);

        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        setVisible(true);
    }

    private void iniciarJogo(int buracos) {

        SudokuGenerator gerador = new SudokuGenerator(9);
        
        gerador.gerarJogo();
        int[][] solucao = gerador.getCopiaTabuleiro(); 
        
        gerador.removerDigitos(buracos);
        int[][] puzzle = gerador.getTabuleiro();

        new Sudoku(puzzle, solucao);
        dispose();
    }

    private void styleButton(JButton btn) {
        btn.setFont(new Font("Arial", Font.PLAIN, 18));
        btn.setFocusable(false);
        btn.setBackground(Color.white);
    }
}