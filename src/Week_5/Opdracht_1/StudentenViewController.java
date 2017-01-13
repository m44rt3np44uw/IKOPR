package Week_5.Opdracht_1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentenViewController extends View implements StudentObserver,
        ActionListener

{

    private JComboBox dropList;

    private JTextArea textArea;

    private Student student;

    public StudentenViewController(Student student) {
        this.student = student;
        student.registerObserver(this);

        dropList = new JComboBox();
        dropList.addActionListener(this);

        textArea = new JTextArea(10, 15);

        JPanel centrumPaneel = new JPanel();
        centrumPaneel.add(new JLabel("alle studenten"));
        centrumPaneel.add(dropList);
        centrumPaneel.add(new JScrollPane(textArea));

        add(centrumPaneel, BorderLayout.CENTER);

    }

    public void update(Student s) {
        boolean found = false;
        student.setSNummer(s.getSNummer());
        student.setNaam(s.getNaam());
        for (int i = 0; i < dropList.getItemCount(); i++) {
            if (dropList.getItemAt(i).equals(student.toString())) {
                dropList.setSelectedItem(dropList.getItemAt(i));
                found = true;
            }
        }
        if (!found) {
            dropList.addItem(student.toString());
            dropList.setSelectedItem(dropList
                    .getItemAt(dropList.getItemCount() - 1));
        }

    }

    public void actionPerformed(ActionEvent ae) {
        String selected = (String) dropList.getSelectedItem();
        if (!student.toString().equals(selected)) {
            student.fromString(selected);
            student.notifyObservers();

        }

    }

    public void windowClosing(WindowEvent we) {
        student.removeObserver(this);
        this.dispose();
    }

}