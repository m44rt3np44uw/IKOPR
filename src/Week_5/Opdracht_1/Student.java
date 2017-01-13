package Week_5.Opdracht_1;

import java.util.*;

class Student implements StudentSubject {
    private int sNummer;

    private String naam;

    private ArrayList<ModuleRun> moduleLijst;

    private ArrayList<StudentObserver> observerLijst;

    public Student(int sNummer, String naam) {
        this.sNummer = sNummer;
        this.naam = naam;
        observerLijst = new ArrayList<StudentObserver>();
        moduleLijst = new ArrayList<ModuleRun>();
    }

    public void setSNummer(int sNummer) {
        this.sNummer = sNummer;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public int getSNummer() {
        return sNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void voegModuleRunToe(ModuleRun mr) {
        moduleLijst.add(mr);
    }

    public void verwijderModuleRun(ModuleRun mr) {
        moduleLijst.remove(mr);
    }

    public ArrayList<ModuleRun> getModuleLijst() {
        return moduleLijst;
    }

    public String toString() {
        return "" + sNummer + " " + naam;
    }

    public void fromString(String tekst) {
        int sNummer, index;
        tekst = tekst.trim();
        String naam = tekst;

        index = tekst.indexOf(" ");
        if (index > 0) {
            if (tekst.substring(0, index).length() > 0) {
                sNummer = Integer.parseInt(tekst.substring(0, index));
                naam = naam.substring(index + 1);
                this.sNummer = sNummer;
                this.naam = naam;
            }
        }
    }

    public void registerObserver(StudentObserver o) {
        observerLijst.add(o);
    }

    public void removeObserver(StudentObserver o) {
        int i = observerLijst.indexOf(o);
        if (i >= 0) {
            observerLijst.remove(i);
        }
    }

    public void notifyObservers() {
        for (StudentObserver observer : observerLijst) {
            observer.update(this);
        }

    }

}