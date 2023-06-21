package model;

public class PrenotazioneSingola extends Prenotazione {
    private Preferenza preferenza;

    public PrenotazioneSingola(String codice, Preferenza preferenza) {
        super(codice, 1);
        this.preferenza = preferenza;
    }

    public Preferenza getPreferenza() {
        return preferenza;
    }

    public void setPreferenza(Preferenza preferenza) {
        this.preferenza = preferenza;
    }

    @Override
    public String toString() {
        return "PrenotazioneSingola{" +
                "preferenza=" + preferenza +
                "} " + super.toString();
    }
}
