package kayttoliittyma;

import javax.swing.JOptionPane;

import data.Opiskelija;
import javax.swing.JButton;

import tietokanta.Tietovarasto;

public class JFrMuutos extends JFrAbstraktiLisaysJaMuut {

    //konstruktori
    public JFrMuutos(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(true);
        btNappi.setText("Tallenna");
        this.setTitle("Muuta opiskelijan tiedot");
        tfEtunimi.setEditable(false);
        tfSukunimi.setEditable(false);
        tfOpintoviikot.setEditable(false);
        tfPaaAine.setEditable(false);
    }

    @Override
    protected void haeTiedot() {
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
                tfEtunimi.setEditable(true);
                tfSukunimi.setEditable(true);
                tfOpintoviikot.setEditable(true);
                tfPaaAine.setEditable(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void kasitteleNappi() {
        try {
            int opiskelijaID = Integer.parseInt(tfId.getText());
            String etunimi = tfEtunimi.getText();
            String sukunimi = tfSukunimi.getText();
            int opintoviikot = Integer.parseInt(tfOpintoviikot.getText());
            String paaAine = tfPaaAine.getText();

            if (tfId.getText().isEmpty() || etunimi.isEmpty() || sukunimi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tiedoissa puutteita", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Opiskelija muutettava = new Opiskelija(opiskelijaID, etunimi, sukunimi, opintoviikot, paaAine);
                rekisteri.teeMuutos(muutettava);
                JOptionPane.showMessageDialog(this, "Tiedot tallennettu", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
