package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * For cycle to make more efficient the creation of the buttons
     */
    private void initBoard() {
        int num = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (num <= 15) {
                    board[i][j] = num;
                    buttons[i][j] = new JButton(String.valueOf(num));
                    buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                } else {
                    board[i][j] = 0;  // The empty space
                    buttons[i][j] = new JButton("");
                }
                panel.add(buttons[i][j]);
                num++;
            }
        }
    }

    private void initUI() {
        add(panel);
    }

    private class ButtonClickListener implements ActionListener {
        private int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button click, move pieces
            // Implement the logic to move pieces based on the click
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewModel viewModel = new ViewModel();
            viewModel.setVisible(true);
        });
    }
}
