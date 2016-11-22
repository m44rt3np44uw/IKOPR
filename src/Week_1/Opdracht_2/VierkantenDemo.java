package Week_1.Opdracht_2;

import javax.swing.*;

public class VierkantenDemo extends JFrame {

    public VierkantenDemo() {
        setSize(500, 300);
        setLocationRelativeTo(null); // centreer het window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("VierkantenDemo");
        setContentPane(new VierkantenPaneel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new VierkantenDemo();
    }
}

