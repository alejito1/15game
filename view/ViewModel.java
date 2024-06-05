package view;
import javax.swing.*;
import java.awt.*;

public class ViewModel extends JFrame {
    private JPanel panel;
    private JButton[][] buttons;
    private int[][] board;

    public ViewModel() {
        board = new int[4][4];
        buttons = new JButton[4][4];
        panel = new JPanel(new GridLayout(4, 4));

        initBoard();
        initUI();

        setTitle("15 Puzzle");
        setSize(1300, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#ccc0b4"));
    }

    /**
     * For cycle to make more efficient the creation of the buttons
     */
    private void initBoard() {
        int num = 1; //Keeps track of the number to be assigned to each button
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (num <= 15) {
                    board[i][j] = num;
                    buttons[i][j] = new JButton(String.valueOf(num));
                    buttons[i][j].setBackground(Color.decode("#eee4d9"));
                    buttons[i][j].setForeground(Color.decode("#81776f"));
                    buttons[i][j].setFont(new Font("Helvetica", Font.BOLD, 20));
                    buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2));
                } else {
                    board[i][j] = 0;  // The empty space
                    buttons[i][j] = new JButton("");
                }
                panel.add(buttons[i][j]);//The current button is added to the main panel of the frame.
                num++;//The current number is incremented for the next iteration.
            }
        }
    }

    private void initUI() {
        // Create a new panel for put the new button
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Locate the panel of the game on the center
        bottomPanel.add(panel, BorderLayout.CENTER);

        // Locate the new button y the low part
        JButton newButton = new JButton("New game");
        newButton.setBackground(Color.decode("#eee4d9")); // Cambiar el color de fondo
        newButton.setForeground(Color.decode("#81776f")); // Cambiar el color del texto
        newButton.setFont(new Font("Helvetica", Font.BOLD, 14)); // Cambiar la fuente y el tamaño
        newButton.setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2)); // Cambiar el borde
        bottomPanel.add(newButton, BorderLayout.SOUTH);

        add(bottomPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewModel puzzle = new ViewModel();
            puzzle.setVisible(true);
        });
    }
}
