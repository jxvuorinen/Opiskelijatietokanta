package kayttoliittyma;

import data.Kurssi;
import data.Kysely;
import javax.swing.JOptionPane;

import data.Opiskelija;
import data.Suoritus;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tietokanta.Tietovarasto;

public class JFrHaeSuoritukset extends JFrAbstraktiLisaysJaMuut {
    
    public JFrHaeSuoritukset(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(false);
        btNappi.setText("Hae");
        this.setTitle("Hae opiskelijan kurssisuoritukset");
        tfEtunimi.setEditable(false);
        tfSukunimi.setEditable(false);
        tfOpintoviikot.setEditable(false);
        tfPaaAine.setEditable(false);
    }

    @Override
    protected void kasitteleNappi() {
        try {
            int opiskelijaID = Integer.parseInt(tfId.getText());
            Opiskelija haettu = rekisteri.haeOpiskelija(opiskelijaID);
            if (haettu == null) {
                JOptionPane.showMessageDialog(this, "Opiskelijaa ei löytynyt", "Virhe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTextArea opiskelijanSuoritukset = new JTextArea(10, 50);
                ArrayList<Kysely> kyselytulos = rekisteri.haeSuoritukset(haettu);
                 for(Kysely suoritus: kyselytulos) {
                    opiskelijanSuoritukset.append(suoritus.toString());
                    opiskelijanSuoritukset.append("\n");
                }
            JOptionPane.showMessageDialog(this, new JScrollPane(opiskelijanSuoritukset), "Kaikki opiskelijan suoritukset",
            JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void haeTiedot() {
  
    }


    
}
