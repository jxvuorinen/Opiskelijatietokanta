package kayttoliittyma;

import javax.swing.JOptionPane;

import data.Opiskelija;

import tietokanta.Tietovarasto;

public class JFrLisays extends JFrAbstraktiLisaysJaMuut {

    //konstruktori
    public JFrLisays(Tietovarasto varasto) {
        super(varasto);
        btPaivita.setVisible(false);
        btNappi.setText("Talleta");
        this.setTitle("Lisää opiskelija");
    }

    @Override
    protected void kasitteleNappi() {
        try {
            int opiskelijaID = Integer.parseInt(tfId.getText());
            String etunimi = tfEtunimi.getText();
            String sukunimi = tfSukunimi.getText();
            int opintoviikot = Integer.parseInt(tfOpintoviikot.getText());
            String paaAine = tfPaaAine.getText();
            
            if (etunimi.isEmpty() || sukunimi.isEmpty() || tfId.getText().isEmpty() || tfOpintoviikot.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Tiedoissa puutteita", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Opiskelija tyyppi = new Opiskelija(opiskelijaID, etunimi, sukunimi, opintoviikot, paaAine);
                rekisteri.lisaaOpiskelija(tyyppi);
                JOptionPane.showMessageDialog(this, "Tiedot tallennettu", "Tallennus", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Virhe", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    protected void haeTiedot() {
    }
    
}
