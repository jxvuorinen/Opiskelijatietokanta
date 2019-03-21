
package data;

public class Kurssi {
    private String kurssitunnus;
    private String kurssinNimi;
    private int laajuus;
    
    public Kurssi(String kurssitunnus, String kurssinNimi, int laajuus) {
        this.kurssitunnus = kurssitunnus;
        this.kurssinNimi = kurssinNimi;
        this.laajuus = laajuus;
    }

    public String getKurssitunnus() {
        return kurssitunnus;
    }

    public void setKurssitunnus(String kurssitunnus) {
        this.kurssitunnus = kurssitunnus;
    }

    public String getKurssinNimi() {
        return kurssinNimi;
    }

    public void setKurssinNimi(String kurssinNimi) {
        this.kurssinNimi = kurssinNimi;
    }

    public int getLaajuus() {
        return laajuus;
    }

    public void setLaajuus(int laajuus) {
        this.laajuus = laajuus;
    }

    @Override
    public String toString() {
        return "Kurssin tiedot: kurssitunnus: " + kurssitunnus + ", kurssin Nimi:" + kurssinNimi + ", laajuus: " + laajuus + " opintoviikkoa";
    }

    
}
