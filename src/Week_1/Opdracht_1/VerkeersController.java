package Week_1.Opdracht_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerkeersController extends JPanel implements ActionListener {
    private VerkeersLichtModel model;
    private VerkeersLichtView view;
    private JButton roodKnop, oranjeKnop, groenKnop;


    public VerkeersController(VerkeersLichtModel model, VerkeersLichtView view) {

        this.model = model;
        this.view = view;

        this.setBackground(Color.DARK_GRAY);

        this.roodKnop = new JButton("Rood");
        this.oranjeKnop = new JButton("Oranje");
        this.groenKnop = new JButton("Groen");

        this.roodKnop.addActionListener(this);
        this.oranjeKnop.addActionListener(this);
        this.groenKnop.addActionListener(this);

        this.add(roodKnop);
        this.add(oranjeKnop);
        this.add(groenKnop);
    }


    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == roodKnop) {
            this.model.setRood();
        }

        else if(e.getSource() == oranjeKnop) {
            this.model.setOranje();
        }

        else if(e.getSource() == groenKnop) {
            this.model.setGroen();
        }

        this.view.repaint();
    }

}