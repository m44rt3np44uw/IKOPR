package Week_4.Opdracht_2;

import java.util.ArrayList;

public class Persoon
{
	private String 				bsn;
	private String 				naam;
	private ArrayList<Rekening> rekeningen;

	public Persoon(String bsn, String naam)
	{
		this.bsn        = bsn;
		this.naam       = naam;
		this.rekeningen = new ArrayList<Rekening>();
	}

	public void voegRekeningToe(Rekening rekening)
	{
		rekeningen.add(rekening);
	}

	public void verwijderRekening(Rekening rekening)
	{
		rekeningen.remove(rekening);
	}

	public ArrayList<Rekening> getRekeningen()
	{
		return this.rekeningen;
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