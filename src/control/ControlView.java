/*package control;
import view.*;
import model.*;
import javax.swing.*;
import java.awt.event.*;

public class ControlView{
    private GameModel model;
    private ViewModel view;

    public ControlView(GameModel model, ViewModel view){
        this.model = model;
        this.view = view;
          viewSetup();

    }
    public void viewSetup(){
        view.setVisible(true);
        view.getNewGame().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameHandler();
            }
        });
        // Add listeners for number buttons
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int x = i;
                int y = j;
                view.getNumberButton(i, j).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        view.handleButtonClick(x, y);
                    }
                });
            }
        }
    }
    private void gameHandler(){
        try{
            model.shuffle();
            view.updateButtons(model.getBoard());
            while (!model.checkForWin()){
                // Add logic to handle user moves and update the view
            }
            JOptionPane.showMessageDialog(view, "You win!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}
*/

