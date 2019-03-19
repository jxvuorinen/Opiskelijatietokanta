package kayttoliittyma;

import javax.swing.JOptionPane;

import data.Opiskelija;

import tietokanta.Tietovarasto;

public class JFrPoisto extends JFrAbstraktiLisaysJaMuut {

    //konstruktori
    public JFrPoisto(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(false);
        btNappi.setText("Poista");
        this.setTitle("Poista opiskelijan tiedot");
        tfEtunimi.setEditable(false);
        tfSukunimi.setEditable(false);
        tfOpintoviikot.setEditable(false);
        tfPaaAine.setEditable(false);
    }

    @Override
    protected void kasitteleNappi() {
        try {
            int opiskelijaID = Integer.parseInt(tfId.getText());
            Opiskelija poistettava = rekisteri.haeOpiskelija(opiskelijaID);
            if (poistettava == null) {
                JOptionPane.showMessageDialog(this, "Poistettavaa opiskelijaa ei löytynyt", "Virhe", JOptionPane.INFORMATION_MESSAGE);
            } else {
                rekisteri.poistaOpiskelija(poistettava);
                JOptionPane.showMessageDialog(this, "Tiedot poistettu", "Poisto",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void haeTiedot() {
    }

}
