package Week_1.Opdracht_2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VierkantenPaneel extends JPanel implements MouseListener {

    private JLabel labelAantalVierkanten = new JLabel(); // In dit label wordt het aantal vierkanten getoond.

    public VierkantenPaneel() {
        // geef het panel een null-lay-out; waarom?
        this.setLayout(null);

        // voeg een MouseListener toe aan het panel
        this.addMouseListener(this);
    }
  

    // alle methods van  MouseListener; waarom alle?
    public void mousePressed(MouseEvent me) {
        Vierkant model = new Vierkant(Color.BLUE, 70); // maak een nieuw vierkant met kleur blauw en zijde 70
        VierkantView view = new VierkantView(model, me.getX(), me.getY()); // maak een view van dit model en geef door waar
        // het geplaatst moet worden op het panel
        new VierkantController(model, view); //maak een VierkantController object van het
        //model en zijn view
        labelAantalVierkanten.setText("Het aantal vierkanten is " + model.getAantalVierkanten());
        this.add(view);
    }

    public void mouseClicked(MouseEvent me) {
    }


    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

}
