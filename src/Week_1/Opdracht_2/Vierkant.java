package Week_1.Opdracht_2;

import java.awt.*;

public class Vierkant {

    private Color kleur;
    private int zijde;
    private static int aantalVierkanten = 0;

    public Vierkant(Color kleur, int zijde) {
        this.kleur = kleur;
        this.zijde = zijde;
        aantalVierkanten++;
    }

    public Color getKleur() {
        return this.kleur;
    }

    public int getZijde() {
        return this.zijde;
    }

    public int getAantalVierkanten() {
        return Vierkant.aantalVierkanten;
    }


    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public void setZijde(int zijde) {
        this.zijde = zijde;
    }
}