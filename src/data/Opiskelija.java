package data;

import java.text.Collator;
import java.util.List;

public class Opiskelija implements Comparable<Opiskelija> {

    private int opiskelijaID;
    private String etunimi;
    private String sukunimi;
    private int opintoviikot;
    private String paaAine;
    //konstruktori 1 lähetetään kaikki tiedot

    /**
     * @param etunimi
     * @param sukunimi
     * @param opintoviikot
     */
    public Opiskelija(int opiskelijaID, String etunimi, String sukunimi, int opintoviikot, String paaAine) {
        this.opiskelijaID = opiskelijaID;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opintoviikot = opintoviikot;
        this.paaAine = paaAine;
    }
    //konstruktori 2 lähetetään vain etu -ja sukunimi opintoviikot asetetaan 0:ksi, pääaine "".

    /**
     * @param etunimi
     * @param sukunimi
     */
    public Opiskelija(int opiskelijaID, String etunimi, String sukunimi) {
        this.opiskelijaID = opiskelijaID;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.opintoviikot = 0;
        this.paaAine = "";
    }

    //kaikille ominaisuuksille get- ja set-metodit
    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getOpintoviikot() {
        return opintoviikot;
    }

    public void setOpintoviikot(int opintoviikot) {
        this.opintoviikot = opintoviikot;
    }
    public void lisaaSuoritus(int opintoviikot) {
        this.opintoviikot += opintoviikot;
    }

    public int getOpiskelijaID() {
        return opiskelijaID;
    }

    public void setOpiskelijaID(int opiskelijaID) {
        this.opiskelijaID = opiskelijaID;
    }

    public String getPaaAine() {
        return paaAine;
    }

    public void setPaaAine(String paaAine) {
        this.paaAine = paaAine;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((etunimi == null) ? 0 : etunimi.hashCode());
        result = prime * result + opintoviikot;
        result = prime * result + opiskelijaID;
        result = prime * result
                + ((sukunimi == null) ? 0 : sukunimi.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Opiskelija other = (Opiskelija) obj;
        if (etunimi == null) {
            if (other.etunimi != null) {
                return false;
            }
        } else if (!etunimi.equals(other.etunimi)) {
            return false;
        }
        if (opintoviikot != other.opintoviikot) {
            return false;
        }
        if (opiskelijaID != other.opiskelijaID) {
            return false;
        }
        if (sukunimi == null) {
            if (other.sukunimi != null) {
                return false;
            }
        } else if (!sukunimi.equals(other.sukunimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Opiskelija: [opiskelijaID=" + opiskelijaID + ", etunimi="
                + etunimi + ", sukunimi=" + sukunimi + ", opintoviikot="
                + opintoviikot + ", pääaine: " + paaAine + "]";
    }

    @Override
    public int compareTo(Opiskelija olio) {
        Collator apu = Collator.getInstance();
        apu.setStrength(Collator.PRIMARY);
        int tulos = apu.compare(this.sukunimi, olio.sukunimi);
        if (tulos != 0) {
            return tulos;
        } else {
            return apu.compare(this.etunimi, olio.etunimi);
        }
    }

    public static String listaMerkkijonona(List<Opiskelija> lista) {
        String merkit = "";
        for (Opiskelija uusi : lista) {
            merkit += uusi + "\n";
        }
        return merkit;
    }

}
