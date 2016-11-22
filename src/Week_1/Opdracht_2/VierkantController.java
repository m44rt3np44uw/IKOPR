package Week_1.Opdracht_2;


import java.awt.*;
import java.awt.event.*;

public class VierkantController extends MouseAdapter
        implements MouseMotionListener, MouseWheelListener {
    private Vierkant vk;
    private VierkantView view;

    private boolean dragged = false;
    private int dragAnkerX = 0;
    private int dragAnkerY = 0;

    // constructors
    public VierkantController(Vierkant vk, VierkantView view) {
        this.vk = vk;
        this.view = view;

        // Voeg de verschillende listeners toe aan de view
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
        view.addMouseWheelListener(this);
    }

    public void mouseEntered(MouseEvent event) {
        // maak het vierkant rood
        this.vk.setKleur(Color.RED);

        // teken de view opnieuw
        this.view.repaint();
    }

    public void mouseExited(MouseEvent event) {
        // maak het vierkant weer blauw
        this.vk.setKleur(Color.BLUE);

        // teken de view opnieuw
        this.view.repaint();
    }


    public void mouseReleased(MouseEvent event) {
        dragged = false;
    }

    public void mouseWheelMoved(MouseWheelEvent event) // ga na!
    {
        int ticks = event.getWheelRotation();
        // pas de breedte en de hoogte van de view
        // aan mbv 'ticks'
        // gebruik view.getWidth() en view.getHeight() en view.setSize(int, int)
        this.view.setSize(this.view.getWidth() + ticks, this.view.getHeight() + ticks);
    }

    public void mouseDragged(MouseEvent event) // ga na!
    {
        if (!dragged) {
            dragged = true;
            dragAnkerX = event.getX();
            dragAnkerY = event.getY();
        }
        int x = view.getX() + event.getX() - dragAnkerX;
        int y = view.getY() + event.getY() - dragAnkerY;
        view.setLocation(x, y);
    }

    public void mouseMoved(MouseEvent event) {
    } // waarom moet deze methode hier staan?
}                                               // hij doet toch niets?
