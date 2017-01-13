package Week_5.Opdracht_1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainPaneel extends JPanel implements ActionListener {
    private JButton studButton;
    private JButton modButton;


    public MainPaneel() {

        studButton = new JButton("studenten");
        modButton = new JButton("modules");
        studButton.addActionListener(this);
        modButton.addActionListener(this);

        JPanel centrumPaneel = new JPanel();
        centrumPaneel.add(studButton);
        centrumPaneel.add(modButton);

        add(centrumPaneel, BorderLayout.CENTER);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == studButton) {
            Student student = new Student(0, "");
            StudentViewController studView = new StudentViewController(student);
            studView.setSize(600, 400);
            studView.setVisible(true);
            StudentenViewController studentenView = new StudentenViewController(student);
            studentenView.setSize(600, 400);
            studentenView.setVisible(true);
        }
    }

}