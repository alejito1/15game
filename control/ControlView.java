package control;
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
            public void actionPerformed(ActionEvent e){
                @Override
                public void actionPerformed(ActionEvent e){
                    gameHandler();
                }
            }
        });
    }
    private void gameHandler(){
        try{
            model.setBoard();
            model.shuffle();
            while (model.checkForWin() == false){


            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }


}
