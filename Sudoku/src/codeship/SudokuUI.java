package codeship;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SudokuUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField[][] grid = new JTextField[9][9];

    public static void main(String[] args) {
        new SudokuUI();
    }

    public SudokuUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(9, 9, 2, 2));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new JTextField();
                grid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                contentPane.add(grid[i][j]);
            }
        }

        JButton btnSolve = new JButton("Solve");
        btnSolve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[][] g = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (grid[i][j].getText().isEmpty()) {
                            g[i][j] = 0;
                        } else {
                            g[i][j] = Integer.parseInt(grid[i][j].getText());
                        }
                    }
                    System.out.println();
                }

                if (SudokuSolver.solve(g)) {
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            grid[i][j].setText(String.valueOf(g[i][j]));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Unsolvable");
                }
            }
        });
        contentPane.add(btnSolve);

        setVisible(true);
    }
}
