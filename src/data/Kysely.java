
package data;

import java.sql.Date;

public class Kysely {
    private String kurssitunnus;
    private String kurssinNimi;
    private int laajuus;
    private Date suorituspvm;
    
    public Kysely(String kurssitunnus, String kurssinNimi, int laajuus, Date suorituspvm) {
        this.kurssitunnus = kurssitunnus;
        this.kurssinNimi = kurssinNimi;
        this.laajuus = laajuus;
        this.suorituspvm = suorituspvm;
    }

    @Override
    public String toString() {
        return "Kurssi: kurssin tunnus: " + kurssitunnus + ": " + kurssinNimi + ", laajuus: " + laajuus + ", suorituspvm: " + suorituspvm;
    }
    
    
}
