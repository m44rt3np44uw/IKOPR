package Week_5.Opdracht_1;

import javax.swing.*;

public class ModuleApp extends JFrame {

    public ModuleApp() {
        setSize(500, 200);
        setLocation(100, 100);
        setTitle("Studenten Module Applikatie");
        MainPaneel mainPaneel = new MainPaneel();
        add(mainPaneel);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ModuleApp();
    }
}