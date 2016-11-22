package Week_1.Opdracht_1;

public class VerkeersLichtModel {
    private boolean rood, oranje, groen;

    public VerkeersLichtModel(boolean rood, boolean oranje, boolean groen) {
        this.rood = rood;
        this.oranje = oranje;
        this.groen = groen;
    }

    public void setRood() {
        this.reset();
        this.rood = true;
    }

    public void setOranje() {
        this.reset();
        this.oranje = true;
    }

    public void setGroen() {
        this.reset();
        this.groen = true;

    }

    public void reset() {
        this.rood = false;
        this.oranje = false;
        this.groen = false;
    }

    // getters
    public boolean getRood() {
        return this.rood;
    }

    public boolean getOranje() {
        return this.oranje;
    }

    public boolean getGroen() {
        return this.groen;
    }


}