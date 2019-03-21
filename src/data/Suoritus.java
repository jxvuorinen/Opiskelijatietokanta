
package data;

import java.sql.Date;
import data.Kurssi;

public class Suoritus {
    private int suorituskerta;
    private int opiskelijaID;
    private String kurssitunnus;
    private Date suorituspvm;
    private Kurssi kurssi;

    public Suoritus(int suorituskerta, int opiskelijaID, String kurssitunnus, Date suorituspvm) {
        this.suorituskerta = suorituskerta;
        this.opiskelijaID = opiskelijaID;
        this.kurssitunnus = kurssitunnus;
        this.suorituspvm = suorituspvm;
    }
    
    public Suoritus(int opiskelijaID, String kurssitunnus, Date suorituspvm) {
        this.opiskelijaID = opiskelijaID;
        this.kurssitunnus = kurssitunnus;
        this.suorituspvm = suorituspvm;
    }
    public Suoritus(String nimi, int laajuus, Date suorituspvm) {
        
    }

    public int getSuorituskerta() {
        return suorituskerta;
    }

    public void setSuorituskerta(int suorituskerta) {
        this.suorituskerta = suorituskerta;
    }

    public int getOpiskelijaID() {
        return opiskelijaID;
    }

    public void setOpiskelijaID(int opiskelijaID) {
        this.opiskelijaID = opiskelijaID;
    }

    public String getKurssitunnus() {
        return kurssitunnus;
    }

    public void setKurssitunnus(String kurssitunnus) {
        this.kurssitunnus = kurssitunnus;
    }

    public Date getSuorituspvm() {
        return suorituspvm;
    }

    public void setSuorituspvm(Date suorituspvm) {
        this.suorituspvm = suorituspvm;
    }

    @Override
    public String toString() {
        return "Suoritus{" + "kurssitunnus=" + kurssitunnus + ", suorituspvm=" + suorituspvm + '}';
    }
    
    
    
}
