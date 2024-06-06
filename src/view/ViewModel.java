package view;
import control.ControlView;
import model.GameModel;
import exceptions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewModel extends JFrame {
    private JPanel panel;
    private JPanel buttonPanel; // Nuevo panel para los botones de los números
    private JButton[][] numberButtons;
    private GameModel model; // Added GameModel instance

    public ViewModel(GameModel model) { // Constructor to pass GameModel instance
        this.model = model;
        numberButtons = new JButton[4][4];
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
                    numberButtons[i][j] = new JButton(String.valueOf(num));
                    numberButtons[i][j].setActionCommand("" + num);
                    numberButtons[i][j].setBackground(Color.decode("#eee4d9"));
                    numberButtons[i][j].setForeground(Color.decode("#81776f"));
                    numberButtons[i][j].setFont(new Font("Helvetica", Font.BOLD, 20));
                    numberButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2));
                } else {
                    //board[i][j] = 0;  // The empty space
                    numberButtons[i][j] = new JButton("");
                    numberButtons[i][j].setActionCommand("");
                    numberButtons[i][j].setBackground(Color.decode("#eee4d9"));
                    numberButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2));
                }
                numberButtons[i][j].addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String buttonText = button.getText();
                        System.out.println("Button pressed: " + buttonText);
                    }
                });
                panel.add(numberButtons[i][j]);//The current button is added to the main panel of the frame.
                num++;//The current number is incremented for the next iteration.
            }
        }
        buttonPanel.add(panel);
    }

    public void updateButtons(int[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0) {
                    numberButtons[i][j].setText("");
                    numberButtons[i][j].setActionCommand("");
                } else {
                    numberButtons[i][j].setText(String.valueOf(board[i][j]));
                    numberButtons[i][j].setActionCommand(String.valueOf(board[i][j]));
                }
            }
        }
    }

    public void handleButtonClick(int x, int y) {
        try {
            int buttonNumber = numberButtons[x][y].getText().isEmpty() ? 0 : Integer.parseInt(numberButtons[x][y].getText());
            model.swapWith0(buttonNumber);
            updateButtons(model.getBoard());
            if (model.checkForWin()) {
                JOptionPane.showMessageDialog(this, "You win!");
            }
        } catch (ImpossibleSwapException | SwapZeroException | OutOfRangeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initUI() {

        // Crear un nuevo panel para contener los botones
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Agregar el panel del juego al centro
        bottomPanel.add(panel, BorderLayout.CENTER);

        // Crear un nuevo panel para contener el botón y establecer su tamaño
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton newButton = new JButton("Restart");
        newButton.setBackground(Color.decode("#eee4d9")); // Cambiar el color de fondo
        newButton.setForeground(Color.decode("#81776f")); // Cambiar el color del texto
        newButton.setFont(new Font("Helvetica", Font.BOLD, 14)); // Cambiar la fuente y el tamaño
        newButton.setBorder(BorderFactory.createLineBorder(Color.decode("#b7aea1"), 2)); // Cambiar el borde
        buttonPanel.add(newButton); // Agregar el botón al panel
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH); // Agregar el panel del botón al panel inferior

        // Agregar el panel a la ventana
        add(bottomPanel);
    }

    private void winMessage() {
        // Crear un nuevo JFrame para la ventana emergente
        JFrame winJFrame = new JFrame("¡Congratulations!");
        // Crear un JLabel con el mensaje de felicitaciones
        JLabel winLabel = new JLabel("¡Congratulations! You win.");
        winLabel.setForeground(Color.BLUE); // Cambiar el color del texto
        winLabel.setFont(new Font("Helvetica", Font.BOLD, 18)); // Cambiar la fuente y el tamaño
        // Configurar el tamaño y la ubicación de la ventana emergente
        winJFrame.setSize(500, 500);
        winJFrame.setLocationRelativeTo(this);
        setTitle("15 Puzzle");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#ccc0b4"));
        // Agregar el JLabel a la ventana emergente
        winJFrame.add(winLabel);
        // Hacer visible la ventana emergente
        winJFrame.setVisible(true);
    }

    /**
     * Getters and setters of the buttons for the Control
     * @return
     */
    public JPanel getbuttonPanel() {
        return buttonPanel;
    }
    public void setNewButton(JButton newButton) {
        this.buttonPanel = buttonPanel;
    }

    public JButton[][] getNumberButtons() {
        return numberButtons;
    }
    public void setNumberButtons(JButton[][] buttons) {
        this.numberButtons = buttons;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel(); // Create an instance of GameModel
            ViewModel puzzle = new ViewModel(model); // Pass the GameModel instance to the ViewModel constructor
            puzzle.setVisible(true);
        });
    }
}



