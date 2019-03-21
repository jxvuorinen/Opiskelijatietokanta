
package data;

import java.sql.Date;

public class Kysely {
    private String kurssinNimi;
    private int laajuus;
    private Date suorituspvm;
    
    public Kysely(String kurssinNimi, int laajuus, Date suorituspvm) {
        this.kurssinNimi = kurssinNimi;
        this.laajuus = laajuus;
        this.suorituspvm = suorituspvm;
    }

    @Override
    public String toString() {
        return "Kurssi: " + kurssinNimi + ", laajuus: " + laajuus + ", suorituspvm: " + suorituspvm;
    }
    
    
}
