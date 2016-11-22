package Week_1.Opdracht_1;

import javax.swing.*;
import java.awt.*;

public class Opdracht_1 extends JFrame {

    public Opdracht_1() {
        this.setSize(300, 400);
        this.setTitle("Opdracht 1 - Verkeerslicht applicatie");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HoofdPaneel hoofdPaneel = new HoofdPaneel();
        this.add(hoofdPaneel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Opdracht_1();
    }
}
