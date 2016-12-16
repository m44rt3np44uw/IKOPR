package Week_4.Opdracht_1;

public class Rekening
{
	// zie sheets week 4
    private String  nummer;
    private double  saldo;
    private Persoon persoon;

    public Rekening(String nummer, Persoon persoon)
    {
        this.nummer  = nummer;
        this.saldo   = 0.0;
        this.persoon = persoon;
    }

    public String getNummer() {
        return nummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void pasSaldoAan(double bedrag)
    {
        this.saldo = bedrag;
    }
}