package Week_4.Opdracht_2;

public class Rekening
{
  private   String  nummer;
  private   double  saldo;
  private   Persoon persoon;

  public Rekening (String nummer, Persoon persoon)
  {
      this.nummer  = nummer;
      this.persoon = persoon;
      this.saldo   = 0.0;
  }

  public Rekening (String nummer, Persoon persoon, double saldo)
  {
      this.nummer  = nummer;
      this.persoon = persoon;
      this.saldo   = saldo;
  }

  public Persoon getPersoon ()
  {
      return this.persoon;
  }

  public String getNummer ()
  {
      return this.nummer;
  }

  public double getSaldo ()
  {
      return this.saldo;
  }

  public void pasSaldoAan (double bedrag)
  {
      this.saldo += bedrag;
  }
}