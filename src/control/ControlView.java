package control;
import view.*;
import model.*;
import exceptions.*;
import javax.swing.*;
import java.awt.event.*;

public class ControlView{
    private GameModel model;
    private ViewModel view;
    public ControlView(GameModel model, ViewModel view){
        this.model = model;
        this.view = view;
        view.updateBoard(model.getBoard());
        view.addTileButtonListener(new ButtonListener());
        view.addNewGameButtonListener(new ButtonListener()); // Added this line
    }
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton button = (JButton)e.getSource();
            if (button.getText().equals("Restart")) {
                model.shuffle();
                view.updateBoard(model.getBoard());
                return;
            }
            int value = Integer.parseInt(button.getText());
            try {
                model.swapWith0(value);
                view.updateBoard(model.getBoard());
                if (model.checkForWin()) {
                    JOptionPane.showMessageDialog(view, "You win!");
                }
            } catch (ImpossibleSwapException | SwapZeroException | OutOfRangeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        GameModel model = new GameModel();
        ViewModel view = new ViewModel(model);
        view.setVisible(true);
    }
}