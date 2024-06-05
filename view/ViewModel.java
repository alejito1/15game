package view;
import javax.swing.*;
import java.awt.*;

public class ViewModel extends JFrame {
    private JPanel panel;
    private JPanel buttonPanel; // Nuevo panel para los botones de los números
    private JButton[][] buttons;
    private int[][] board;

    public ViewModel() {
        board = new int[4][4];
        buttons = new JButton[4][4];
        panel = new JPanel(new GridLayout(4, 4)); // GridLayout para los botones de los números
        buttonPanel = new JPanel(new GridLayout(1, 1)); // GridLayout para contener el panel de botones

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
        buttonPanel.add(panel);
    }

    private void initUI() {

        // Crear un nuevo panel para contener los botones
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Agregar el panel del juego al centro
        bottomPanel.add(panel, BorderLayout.CENTER);

        // Crear un nuevo panel para contener el botón y establecer su tamaño
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton newButton = new JButton("New Game");
        newButton.setBackground(Color.decode("#eee4d9")); // Cambiar el color de fondo
        newButton.setForeground(Color.decode("#81776f")); // Cambiar el color del texto
        newButton.setFont(new Font("Arial", Font.BOLD, 14)); // Cambiar la fuente y el tamaño
        newButton.setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2)); // Cambiar el borde
        buttonPanel.add(newButton); // Agregar el botón al panel
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH); // Agregar el panel del botón al panel inferior

        // Agregar el panel a la ventana
        add(bottomPanel);
    }

    // Getter para el botón nuevo
    public JPanel getbuttonPanel() {
        return buttonPanel;
    }

    // Setter para el botón nuevo
    public void setNewButton(JButton newButton) {
        this.buttonPanel = buttonPanel;
    }

    // Getter para los botones de los números
    public JButton[][] getNumberButtons() {
        return buttons;
    }

    // Setter para los botones de los números
    public void setNumberButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewModel puzzle = new ViewModel();
            puzzle.setVisible(true);
        });
    }
}
