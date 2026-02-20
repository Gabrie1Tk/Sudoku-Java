import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sudoku {
    private class Casa extends JButton {
        int l, c;
        Casa(int l, int c) {
            this.l = l;
            this.c = c;
        }
    }

    private int[][] puzzle;
    private int[][] solution;

    private JFrame frame = new JFrame("Sudoku");
    private JLabel textLabel = new JLabel();
    private JLabel titleLabel = new JLabel();
    private JPanel textPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();

    private JButton numSelected = null;
    private int errors = 0;
    private int casasRestantes = 0;

    public Sudoku(int[][] puzzleGerado, int[][] solucaoGerada) {
        this.puzzle = puzzleGerado;
        this.solution = solucaoGerada;

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textPanel.setLayout(new GridLayout(1, 3));
        textPanel.add(new JLabel());

        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setText("Sudoku");
        textPanel.add(titleLabel);
        
        textLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        textLabel.setText("Erros: 0");
        textLabel.setHorizontalAlignment(JLabel.RIGHT);
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        textPanel.add(textLabel);

        frame.add(textPanel, BorderLayout.NORTH);
        
        boardPanel.setLayout(new GridLayout(9, 9));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boardPanel.setBackground(Color.BLACK); 
        boardPanel.setPreferredSize(new Dimension(500, 500));
        
        setupCasas();
        frame.add(boardPanel, BorderLayout.CENTER);

        buttonsPanel.setLayout(new GridLayout(1, 9, 10, 0)); 
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        
        setupButtons();
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private void setupCasas() {
        casasRestantes = 0;

        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                Casa casa = new Casa(l, c);
                int valor = puzzle[l][c];

                if (valor != 0) {
                    casa.setFont(new Font("Arial", Font.BOLD, 20));
                    casa.setText(String.valueOf(valor));
                    casa.setBackground(Color.lightGray);
                    casa.setForeground(Color.BLACK);
                } else {
                    casa.setFont(new Font("Arial", Font.PLAIN, 20));
                    casa.setBackground(Color.white);
                    casasRestantes++;
                }

                int bottom = (l == 2 || l == 5) ? 5 : 1;
                int right = (c == 2 || c == 5) ? 5 : 1;
                casa.setBorder(BorderFactory.createMatteBorder(1, 1, bottom, right, Color.black));

                casa.setFocusable(false);
                boardPanel.add(casa);

                casa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Casa casa = (Casa) e.getSource();
                        int l = casa.l;
                        int c = casa.c;

                        if (numSelected == null || casa.getText().length() > 0) {
                                return;
                        }

                        String numSelectedText = numSelected.getText();
                        String solucaoCorreta = String.valueOf(solution[l][c]);

                        if (solucaoCorreta.equals(numSelectedText)) {
                            casa.setText(numSelectedText);
                            casa.setForeground(Color.BLACK);

                            casasRestantes--;
                            if (casasRestantes == 0) {
                                JOptionPane.showMessageDialog(frame, "Parabéns! Você completou o Sudoku!");
                                
                                frame.dispose();
                                new TelaInicial();
                            }
                        } else {
                            errors++;
                            textLabel.setText("Erros: " + errors);
                        }
                    }
                });
            }
        }   
    }

   private void setupButtons() {
        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setFocusable(false);
            button.setBackground(Color.white);
            button.setForeground(Color.BLACK);
            
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if (numSelected != null) {
                        numSelected.setBackground(Color.white);
                    }
                    numSelected = button;
                    numSelected.setBackground(Color.lightGray);
                }
            });
        } 
    }
}