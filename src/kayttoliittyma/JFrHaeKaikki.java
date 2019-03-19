package kayttoliittyma;

import javax.swing.JOptionPane;

import data.Opiskelija;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import tietokanta.Tietovarasto;

public class JFrHaeKaikki extends JFrAbstraktiLisaysJaMuut {

    //konstruktori
    public JFrHaeKaikki(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(false);
        btNappi.setText("Hae kaikkien opiskelijoiden tiedot");
        this.setTitle("Hae kaikki opiskelijat");
        tfId.setEditable(false);
        tfEtunimi.setEditable(false);
        tfSukunimi.setEditable(false);
        tfOpintoviikot.setEditable(false);
        tfPaaAine.setEditable(false);
    }

    @Override
    protected void kasitteleNappi() {
        try {
            ArrayList<Opiskelija> listaus = rekisteri.haeKaikki();
            if (listaus == null) {
                JOptionPane.showMessageDialog(this, "Opiskelijoita ei löytynyt", "Virhe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JTextArea kaikkiOpiskelijat = new JTextArea(10, 50);
                 for(Opiskelija opiskelija: listaus) {
                    kaikkiOpiskelijat.append(opiskelija.toString());
                    kaikkiOpiskelijat.append("\n");
                }
            JOptionPane.showMessageDialog(this, new JScrollPane(kaikkiOpiskelijat), "Kaikki opiskelijat",
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
