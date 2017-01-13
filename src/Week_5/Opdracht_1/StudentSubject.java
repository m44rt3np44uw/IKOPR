package Week_5.Opdracht_1;

public interface StudentSubject {
    public void registerObserver(StudentObserver o);

    public void removeObserver(StudentObserver o);

    public void notifyObservers();
}
