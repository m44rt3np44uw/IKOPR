package Week_5.Opdracht_1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentViewController extends View implements StudentObserver,
        ActionListener

{
    private JTextField naamField;

    private JTextField sNummerField;

    private JButton studentButton;

    private JTextArea textArea;

    private Student student;

    public StudentViewController(Student student) {
        this.student = student;
        student.registerObserver(this);

        naamField = new JTextField(10);
        sNummerField = new JTextField(10);
        studentButton = new JButton("student");
        studentButton.addActionListener(this);

        JPanel noordPaneel = new JPanel();
        noordPaneel.add(new JLabel("sNummer"));
        noordPaneel.add(sNummerField);
        noordPaneel.add(new JLabel("naam"));
        noordPaneel.add(naamField);
        noordPaneel.add(studentButton);

        textArea = new JTextArea(10, 15);
        JPanel centrumPaneel = new JPanel();
        centrumPaneel.add(new JLabel("huidige student"));
        centrumPaneel.add(new JScrollPane(textArea));

        add(noordPaneel, BorderLayout.NORTH);
        add(centrumPaneel, BorderLayout.CENTER);

    }

    public void update(Student s) {
        student.setSNummer(s.getSNummer());
        student.setNaam(s.getNaam());
        naamField.setText(student.getNaam());
        sNummerField.setText("" + student.getSNummer());
        textArea.setText(student.toString());
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == studentButton) {
            student.setSNummer(Integer.parseInt(sNummerField.getText()));
            student.setNaam(naamField.getText());
            student.notifyObservers();
        }
    }

    public void windowClosing(WindowEvent we) {
        student.removeObserver(this);
        this.dispose();
    }

}