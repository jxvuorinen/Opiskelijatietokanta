package kayttoliittyma;

import javax.swing.JOptionPane;

import data.Opiskelija;

import tietokanta.Tietovarasto;

public class JFrHaku extends JFrAbstraktiLisaysJaMuut {

    //konstruktori
    public JFrHaku(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(false);
        btNappi.setText("Hae");
        this.setTitle("Hae opiskelija");
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
                tfEtunimi.setText(haettu.getEtunimi());
                tfSukunimi.setText(haettu.getSukunimi());
                tfOpintoviikot.setText("" + haettu.getOpintoviikot());
                tfPaaAine.setText(haettu.getPaaAine());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void haeTiedot() {
  
    }

}
