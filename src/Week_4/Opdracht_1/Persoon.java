package Week_4.Opdracht_1;


import java.util.ArrayList;
import java.util.StringJoiner;

public class Persoon
{
	// zie sheets week 4
    private String bsn;
    private String naam;
    private ArrayList<Rekening> rekeningen;

    public Persoon(String bsn, String naam)
    {
        this.bsn  = bsn;
        this.naam = naam;
    }

    public void voegRekeningToe(Rekening rekening)
    {
        this.rekeningen.add(rekening);
    }

    public void verwijderRekening(Rekening rekening)
    {
        this.rekeningen.remove(this.rekeningen.indexOf(rekening));
    }

    public String getBsn()
    {
        return this.bsn;
    }

    public String getNaam()
    {
        return this.naam;
    }
}